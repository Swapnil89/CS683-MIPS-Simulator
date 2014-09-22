package mips.simulator.dao;

import java.nio.ByteBuffer;

public class JTypeInstruction extends Instruction {
	private int immediateAddress;
		
	public JTypeInstruction(byte[] instructionBytes) {
		super(instructionBytes);
		byte[] immediateAddressBytes = new byte[4];
		System.arraycopy(instructionBytes, 0, immediateAddressBytes, 0, 3);
		immediateAddress = ByteBuffer.wrap(instructionBytes).getInt();
		immediateAddress = immediateAddress + ((instructionBytes[3] & 0x02) << 24) & 0xFFFFFFFF;
	}	
	
	public int getImmediateAddress() {
		return immediateAddress;
	}
}