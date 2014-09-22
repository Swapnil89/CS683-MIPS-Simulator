package mips.simulator.context;

public class AppContext {
	private static AppContext appContext;
	public static final int INSRUCTION_LENGTH = 4; // It is a simulator for 32 bit instruction
	public static final int OPCODE_LENGTH = 6; // in bits
	public static final int NO_OF_PIPELINE_STAGES = 6; // in bits
	public static final int NO_OF_REGISTERS = 32;
	public static final int VIRTUAL_MEMORY_ADDRESS_BITS = 21; // in bits

	private static int totalCycles = 0; // It is a simulator for 32 bit instruction
	public static int PROGRAM_COUNTER = 0;
	
	private AppContext() {
	}
	 
	public static AppContext getInstance() {
		if (appContext == null) {
			appContext = new AppContext();
		}
		return appContext;
	}
	
	public void resetCycleCount() {
		totalCycles = 0;
	}
	
	public void incrementCycleCount(int count) {
		totalCycles += count;
	}
	
	public int getCycleCount() {
		return totalCycles;
	}
	
}
