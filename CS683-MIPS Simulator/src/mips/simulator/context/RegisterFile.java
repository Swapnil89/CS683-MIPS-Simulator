package mips.simulator.context;


public class RegisterFile {
	private static RegisterFile regFile;
	private int[] registerArray;
	
	private RegisterFile() {
		registerArray = new int[AppContext.NO_OF_REGISTERS];
	}
	
	public static void initialize() {
		regFile = new RegisterFile();
	}
		
	public static RegisterFile getInstance() {
		if (regFile == null) {
			regFile = new RegisterFile();
		} 
		return regFile;
	}
	
	public int getRegisterValue(int address) {
		return registerArray[address];
	}
	
	public void setRegisterValue(int address, int val) {
		registerArray[address] = val;
	}
	
}
