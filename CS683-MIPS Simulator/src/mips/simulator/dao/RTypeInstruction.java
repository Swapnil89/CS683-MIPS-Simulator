package mips.simulator.dao;


public class RTypeInstruction extends Instruction {
	private int regTarget;
	private int regSource1;
	private int regSource2;
	private int shift;
	private int function;
	
	public RTypeInstruction(byte[] instructionBytes) {
		super(instructionBytes);
		
		//assign values to different fields
		regTarget = (instructionBytes[3] & 0x03) << 3 +  (instructionBytes[2] & 0xE0) >> 5;
		regSource1 = instructionBytes[2] & 0x1F;
		regSource2 = (instructionBytes[1] & 0xF8) >> 3;
		shift = (instructionBytes[1] & 0x07) << 2 + (instructionBytes[0] & 0xC0) >> 6;
		function = instructionBytes[0] & 0x3F;
	}	

	public int getRegTarget() {
		return regTarget;
	}

	public int getRegSource1() {
		return regSource1;
	}

	public int getRegSource2() {
		return regSource2;
	}

	public int getShift() {
		return shift;
	}

	public int getFunction() {
		return function;
	}

}
