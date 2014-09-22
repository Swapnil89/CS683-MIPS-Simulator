package mips.simulator.dao;

public class ITypeInstruction extends Instruction {
	private int regTarget;
	private int regSource;
	private int immediateVal;

	public ITypeInstruction(byte[] instructionBytes) {
		super(instructionBytes);
		regTarget = (instructionBytes[3] & 0x03) << 3 +  (instructionBytes[2] & 0xE0) >> 5;
		regSource = instructionBytes[2] & 0x1F;
		immediateVal = (instructionBytes[1] & 0xFFFF) << 8 + instructionBytes[0] & 0xFF;
	}	
	
	public int getRegTarget() {
		return regTarget;
	}

	public int getRegSource() {
		return regSource;
	}

	public int getImmediateVal() {
		return immediateVal;
	}


}
