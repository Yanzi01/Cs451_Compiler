import java.util.ArrayList;

import jminusminus.CLEmitter;

import static jminusminus.CLConstants.*;

public class GenSeq {
    public static void main(String[] args) {
	CLEmitter e = new CLEmitter(true);
    
    ArrayList<String> modifiers = new ArrayList<String>();

    // Class header public class Seq
    modifiers.add("public");
    e.addClass(modifiers, "Seq", "java/lang/Object", null, true);

    modifiers.clear();
    // Method header public static void main(String[])
    modifiers.add("public");
    modifiers.add("static");
    e.addMethod(modifiers, "main", "([Ljava/lang/String;)V", null, true);


    // Instrutions to accept start (int), step (int), and stop (int) as command-line arguments 

    // int start = Integer.parseInt(args[0]);
    e.addNoArgInstruction(ALOAD_0); 
    e.addNoArgInstruction(ICONST_0);
    e.addNoArgInstruction(AALOAD);
    e.addMemberAccessInstruction(INVOKESTATIC, "java/lang/Integer", "parseInt", "(Ljava/lang/String;)I");
    e.addNoArgInstruction(ISTORE_1);

    // int step = Integer.parseInt(args[1]);
    e.addNoArgInstruction(ALOAD_1);
    e.addNoArgInstruction(ICONST_1);
    e.addNoArgInstruction(AALOAD);
    e.addMemberAccessInstruction(INVOKESTATIC, "java/lang/Integer", "parseInt", "(Ljava/lang/String;)I");
    e.addNoArgInstruction(ISTORE_2);

    // int stop = Integer.parseInt(args[2]);
    e.addNoArgInstruction(ALOAD_2);
    e.addNoArgInstruction(ICONST_2);
    e.addNoArgInstruction(AALOAD);
    e.addMemberAccessInstruction(INVOKESTATIC, "java/lang/Integer", "parseInt", "(Ljava/lang/String;)I");
    e.addNoArgInstruction(ISTORE_3);

    e.addLabel("topLabel"); // Label "topLabel"

    // Instructions to load start and stop, and branch to "endLabel" if start > stop
    e.addNoArgInstruction(ILOAD_1); 
    e.addNoArgInstruction(ILOAD_3); 
    e.addBranchInstruction(IF_ICMPGT, "endLabel"); 

    // Instructions to write the current value of start to standard output
    e.addMemberAccessInstruction(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
    e.addNoArgInstruction(ILOAD_1); 
    e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V");

    // Instructions to load start and step, compute their sum, and store the result in start
    e.addNoArgInstruction(ILOAD_1); 
    e.addNoArgInstruction(ILOAD_2); 
    e.addNoArgInstruction(IADD);
    e.addNoArgInstruction(ISTORE_1); 

    // Instruction to unconditionally branch to "topLabel"
    e.addBranchInstruction(GOTO, "topLabel");

    // Label "endLabel"
    e.addLabel("endLabel");

    // The RETURN instruction
    e.addNoArgInstruction(RETURN);

    // Write e to the file system
    e.write();
    
    }
}
