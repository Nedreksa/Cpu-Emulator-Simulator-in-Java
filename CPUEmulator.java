import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CPUEmulator {
    private int AC = 0;
    private int PC = 0;
    private int FLAG = 0;

    private int[] opcodes;
    private int[] operands;
    private Memory memory;
    private Cache cache;

    public CPUEmulator(String[] opcodeBin, String[] operandBin, String configFile) {
        this.opcodes = new int[opcodeBin.length];
        this.operands = new int[operandBin.length];

        for (int i = 0; i < opcodeBin.length; i++) {
            this.opcodes[i] = Integer.parseInt(opcodeBin[i], 2);
            this.operands[i] = Integer.parseInt(operandBin[i], 2);
        }

        this.memory = new Memory();
        this.cache = new Cache(memory);

        try (BufferedReader br = new BufferedReader(new FileReader(configFile))) {
            int loadAddress = Integer.decode(br.readLine());
            this.PC = Integer.decode(br.readLine());

            for (int i = 0; i < opcodes.length; i++) {
                int instruction = (opcodes[i] << 12) | operands[i];
                memory.writeShort(loadAddress + i * 2, (short) instruction);
            }
            opcodes[0] = loadAddress;
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        execute();
    }
    
    private void execute() {
    	int a = 0;
        boolean running = true;
        while (running) {
            int instruction = memory.readShort(PC);
            int opcode = (instruction >>> 12) & 0xF;
            int operand = instruction & 0xFFF;

            switch (opcode) {
                case 0: // START
                    PC += 2;
                    break;
                case 1: // LOAD
                    AC = operand;
                    PC += 2;
                    break;
                case 2: // LOADM
                    AC = cache.read(operand*2);
                    PC += 2;
                    break;
                case 3: // STORE
                    cache.write(operand*2, (short) AC);
                    cache.cacheMiss();
                    PC += 2;
                    break;
                case 4: // CMPM
                    int memVal = cache.read(operand*2);
                    FLAG = Integer.compare(AC, memVal);
                    PC += 2;
                    break;
                case 5: // CJMP
                    if (FLAG > 0) PC = opcodes[0] + operand*2;
                    else PC += 2;
                    break;
                case 6: // JMP
                    PC = opcodes[0] + operand*2;
                    break;
                case 7: // ADD
                    AC += operand;
                    PC += 2;
                    break;
                case 8: // ADDM
                    AC += cache.read(operand*2);
                    PC += 2;
                    break;
                case 9: // SUB
                    AC -= operand;
                    PC += 2;
                    break;
                case 10: // SUBM
                    AC -= cache.read(operand*2);
                    PC += 2;
                    break;
                case 11: // MUL
                    AC *= operand;
                    PC += 2;
                    break;
                case 12: // MULM
                    AC *= cache.read(operand*2);
                    PC += 2;
                    break;
                case 13: // DISP
                    System.out.println("Value in AC: " + AC);
                    PC += 2;
                    break;
                case 14: // HALT
                    running = false;
                    break;
                default:
                    System.err.println("Unknown opcode: " + opcode);
                    running = false;
            }
            a++;
        }

        System.out.printf("Cache hit ratio: %.2f%%\n", cache.getHitRatio());
    }
}

