
README - Simple CPU Emulator

This project is a CPU and memory simulation system developed in Java. It includes a cache, main memory, and a CPU emulator. The simulation is executed based on input files.

CONTENTS:
---------
1. Main.java           - Reads the txt files and loads them into the CPUEmulator.
2. CPUEmulator.java    - Simulates the CPU's operation.
3. Cache.java          - Manages the cache memory.
4. Memory.java         - Defines the structure and behavior of the main memory.
5. config.txt          - Line 1: Program load address (hexadecimal, e.g., 0x1000)
                         Line 2: Initial PC value (hexadecimal, absolute address)
6. program.txt         - Contains binary instructions (16-bit strings, one per line) for emulate.

USAGE:
------
1. Compile all .java files:
   javac *.java

2. Run the program (assuming the main class is in Main.java:)
   java Main program.txt config.txt
  

3. Make sure that config.txt and program.txt are located in the same directory as the compiled classes.


AUTHOR:
-------
Harun ASKERDEN 
