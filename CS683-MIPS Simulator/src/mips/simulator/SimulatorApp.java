package mips.simulator;

import java.io.File;

import mips.simulator.context.Memory;
import mips.simulator.context.RegisterFile;
import mips.simulator.parser.InstructionParser;

public class SimulatorApp {

	public static void main (String args[]) {
		//Create application object 
		if (args.length < 1) {
			System.out.println("Usage: java Simulator <name_of_exe>");
			System.exit(0);
		}
		
		//perform Register file and memory loading
		RegisterFile.initialize();
		Memory.initialize();
		
		File exeFile = new File(args[0]);
		if (exeFile.exists()) {
		
			//Launch a parsing thread which will add every parsed instruction to the queue
			InstructionParser parser = new InstructionParser(exeFile);
			if (parser.validate()) {
				parser.parseInstructions();
				
				MIPSProcessor simulator = new MIPSProcessor();
				simulator.startSimulation();
			} else {
				System.out.println("File " + args[1] + " is not a valid exe.");
			}
	
		} else {
			System.out.println("File " + args[1] + " not found. Terminating Simulation Process.");
			System.exit(0);
		}
	}
}
