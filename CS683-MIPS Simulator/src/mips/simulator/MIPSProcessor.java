package mips.simulator;

import mips.simulator.context.AppContext;
import mips.simulator.dao.Instruction;
import mips.simulator.dao.InstructionQueue;
import mips.simulator.dao.JTypeInstruction;
import mips.simulator.misc.InstructionStage;
import mips.simulator.utils.InstructionExecutor;
import mips.simulator.utils.Validator;

/*
 This class is the main class for running simulation
  */
public class MIPSProcessor {

	public void startSimulation() {
		int insructionExecutionCount = 0;
		InstructionQueue instructionQueue = InstructionQueue.getInstance();
		Instruction previousInstruction = null, instruction = null;
		do {
			instruction = instructionQueue.getFromQueue();
			if (instruction == null) {
				//TODO:  calculate the total cycles taken
				System.out.println("Execution completed!");
				System.out.println("Total cycles required for execution = " + AppContext.getInstance().getCycleCount());
				System.out.println("CPI = " + (double)AppContext.getInstance().getCycleCount()/ insructionExecutionCount);
				break;
			} else {
				//adjust stalls accordingly
				if (instruction instanceof JTypeInstruction) {
					AppContext.getInstance().incrementCycleCount(InstructionStage.getStallCyclesForBranchInstrction());
				} else {
					//check RAW hazard
					if(Validator.checkForRAWHazard(instruction, previousInstruction)) {
						AppContext.getInstance().incrementCycleCount(InstructionStage.getStallCyclesForRAWHazard());
					} else {
						//normal case, add stall for fetch stage
						AppContext.getInstance().incrementCycleCount(InstructionStage.FETCH.getCyclesForCompletion());
					}
				}

				//now execute the actual instruction
				InstructionExecutor.execute(instruction);
				insructionExecutionCount++;
				System.out.println("Instruction no " + insructionExecutionCount + " executed successfully!");
			}
			previousInstruction = instruction;
		} while (true);
		
	}

}
