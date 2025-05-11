import java.util.*;
import java.io.*;

public class Main {
	
public static void main(String[]args){

  if(args.length < 2) {
  
  System.out.println("This program needs program.txt config.txt");
  return;
  }
	
 String pfile = args[0]; 
 String cfile = args[1]; 

 String[] opcode = null ;
 String[] mnemonic = null ;
  
 try{
	BufferedReader reader = new BufferedReader(new FileReader(pfile));
	BufferedReader reader1 = new BufferedReader(new FileReader(pfile));
	
	String line;
	int linecounter = 0;
 
	while((line = reader.readLine()) != null){
	  if(line.contains(" ") || line.trim().isEmpty()){
		continue;
	  } 
	  else {
		linecounter++;	 
	  }	
	}
	
	int i = 0;
	String line1;
	opcode = new String[linecounter];
	mnemonic = new String[linecounter];
	
	while((line1 = reader1.readLine()) != null){
	
	if(line1.contains(" ") || line1.trim().isEmpty()) {
             continue;
    }
	
	else {
	 opcode[i] = line1.substring(0, 4);
	 mnemonic[i] = line1.substring(4);
	 i++;
	}
	}
	
 }catch (IOException e) {
	e.printStackTrace();
}
 
 CPUEmulator emulator = new CPUEmulator(opcode,mnemonic,cfile);
 
} 	
		
}

class a120210808017 {
	
public static void main(String[]args){

  if(args.length < 2) {
  
  System.out.println("This program needs program.txt config.txt");
  return;
  }
	
 String pfile = args[0]; 
 String cfile = args[1]; 

 String[] opcode = null ;
 String[] mnemonic = null ;
  
 try{
	BufferedReader reader = new BufferedReader(new FileReader(pfile));
	BufferedReader reader1 = new BufferedReader(new FileReader(pfile));
	
	String line;
	int linecounter = 0;
 
	while((line = reader.readLine()) != null){
	  if(line.contains(" ") || line.trim().isEmpty()){
		continue;
	  } 
	  else {
		linecounter++;	 
	  }	
	}
	
	int i = 0;
	String line1;
	opcode = new String[linecounter];
	mnemonic = new String[linecounter];
	
	while((line1 = reader1.readLine()) != null){
	
	if(line1.contains(" ") || line1.trim().isEmpty()) {
             continue;
    }
	
	else {
	 opcode[i] = line1.substring(0, 4);
	 mnemonic[i] = line1.substring(4);
	 i++;
	}
	}
	
 }catch (IOException e) {
	e.printStackTrace();
}
 
 CPUEmulator emulator = new CPUEmulator(opcode,mnemonic,cfile);
 
} 	
		
}



