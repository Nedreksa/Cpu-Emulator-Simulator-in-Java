
README - Simple CPU Emulator

This project is a CPU and memory simulation system developed in Java. It includes a cache, main memory, and a CPU emulator. The simulation is executed based on input files.

CONTENTS:
---------
1. Main.java           - Reads the txt files and loads them into the CPUEmulator.
2. a120210808017.java  - Same function with main class this for the if user wants to execute with this name.
3. CPUEmulator.java    - Simulates the CPU's operation.
4. Cache.java          - Manages the cache memory.
5. Memory.java         - Defines the structure and behavior of the main memory.
6. config.txt          - Line 1: Program load address (hexadecimal, e.g., 0x1000)
                         Line 2: Initial PC value (hexadecimal, absolute address)
7. program.txt         - Contains binary instructions (16-bit strings, one per line) for emulate.

USAGE:
------
1. Compile all .java files:
   javac *.java

2. Run the program (assuming the main class is in Main.java:)
   java Main program.txt config.txt
   java a120210808017 program.txt config.txt

3. Make sure that config.txt and program.txt are located in the same directory as the compiled classes.


AUTHOR:
-------
Harun ASKERDEN 
20210808017.
