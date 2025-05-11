
public class Cache{
    private class CB {
        int tag;
        short data;
        boolean valid;

        public CB() {
            valid = false;
        }
    }

    private CB[] blocks;
    private Memory memory;
    private int hits;
    private int misses;

    public Cache(Memory memory) {
        this.memory = memory;
        blocks = new CB[8];
        for (int i = 0; i < 8; i++) {
            blocks[i] = new CB();
        }
        hits = 0;
        misses = 0;
    }

    public short read(int address) {
        int line = (address / 2) % 8;
        int tag = (address / 2) / 8;
        CB block = blocks[line];

        if (block.valid && block.tag == tag) {
            hits++;
            return block.data;
        } else {
            misses++;
            short value = memory.readShort(address);
            block.tag = tag;
            block.data = value;
            block.valid = true;
            return value;
        }
    }

    public void write(int address, short value) {
        int line = (address / 2) % 8;
        int tag = (address / 2) / 8;
        CB block = blocks[line];

        block.tag = tag;
        block.data = value;
        block.valid = true;

        memory.writeShort(address, value);
    }

    public double getHitRatio() {
        int total = hits + misses;
        return total == 0 ? 0.0 : (100.0 * hits / total);
    }

    public int getHits() {
        return hits;
    }

    public int getMisses() {
        return misses;
    }
    
    public void cacheMiss() {
    	misses++;
    }
}