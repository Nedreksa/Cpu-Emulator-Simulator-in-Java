
public class Memory {
    private byte[] memory;

    public Memory() {
    memory = new byte[65536];
    }

   
    public byte readByte(int address) {
        return memory[address];
    }

   
    public void writeByte(int address, byte value) {
        memory[address] = value;
    }

  
    public short readShort(int address) {
    	int low = 0, high = 0;
    	if (address%2 == 0) {
            low = memory[address] & 0xFF;
            high = memory[address + 1] & 0xFF;
    	} else {
            low = memory[address-1] & 0xFF;
            high = memory[address] & 0xFF;
    	}
        return (short) ((high << 8) | low);
    }

   
    public void writeShort(int address, short value) {
        memory[address] = (byte) (value & 0xFF);          
        memory[address + 1] = (byte) ((value >> 8) & 0xFF); 
    
}

}