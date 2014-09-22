package mips.simulator.context;


public class Memory {
	private static Memory virtualMemory;
	private int[] memory;
	private Memory() {
		 memory = new int[(int)Math.pow(2, AppContext.VIRTUAL_MEMORY_ADDRESS_BITS)];
	}

	public static void initialize() {
		virtualMemory = new Memory();
	}

	public static Memory getInstance() {
		if (virtualMemory == null) {
			virtualMemory = new Memory();
		} 
		return virtualMemory;
	}
	
	public int getMemoryValue(int address) {
		return memory[address];
	}
	
	public void setMemoryValue(int address, int val) {
		memory[address] = val;
	}
	
}
