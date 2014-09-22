package mips.simulator.utils;

import mips.simulator.context.AppContext;
import mips.simulator.dao.ITypeInstruction;
import mips.simulator.dao.Instruction;
import mips.simulator.dao.JTypeInstruction;
import mips.simulator.dao.RTypeInstruction;

public class InstructionExecutor {
	
	public static void execute(Instruction instruction) {
		switch (instruction.getOpCode()) {
		case 0: //R-Type instructions
			
			switch(((RTypeInstruction)instruction).getFunction()) {
			case 0:	
				
			case 8:
				InstructionProcessor.getInstance().executeJR((RTypeInstruction) instruction);
				break;
			default:
				InstructionProcessor.getInstance().executeADD((RTypeInstruction) instruction);
			}
			break;
		case 1:
		case 2:
			InstructionProcessor.getInstance().executeJ((JTypeInstruction) instruction);
			break;
			
		case 3:
			InstructionProcessor.getInstance().executeJAL((JTypeInstruction) instruction);
			break;

		case 4:
			InstructionProcessor.getInstance().executeBEQ((ITypeInstruction) instruction);
			break;
		default:
			AppContext.PROGRAM_COUNTER++;
		}
	}

}
