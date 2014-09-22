package mips.simulator.utils;

import mips.simulator.dao.ITypeInstruction;
import mips.simulator.dao.Instruction;
import mips.simulator.dao.RTypeInstruction;

public class Validator {
	
	public static boolean checkForRAWHazard(Instruction currentInstruction, 
				Instruction previousInstruction) {
		if (previousInstruction == null || currentInstruction == null) {
			return false;
		}
		
		int prevRegTarget = 0, currentRegSource1 = 0, currentRegSource2 = -1;
		if (previousInstruction instanceof ITypeInstruction) {
			prevRegTarget = ((ITypeInstruction) previousInstruction).getRegTarget();
		} else if (previousInstruction instanceof RTypeInstruction) {
			prevRegTarget = ((RTypeInstruction) previousInstruction).getRegTarget();
		}
		
		if (currentInstruction instanceof ITypeInstruction) {
			currentRegSource1 = ((ITypeInstruction) currentInstruction).getRegSource();
		} else if (currentInstruction instanceof RTypeInstruction) {
			currentRegSource1 = ((RTypeInstruction) currentInstruction).getRegSource1();
			currentRegSource2 = ((RTypeInstruction) currentInstruction).getRegSource2();
		}
		
		if (prevRegTarget == currentRegSource1 || (currentRegSource2 != -1 && 
				prevRegTarget == currentRegSource2)) {
			return true;
		}
		
		return false;
	}

}
