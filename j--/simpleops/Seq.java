import java.lang.Integer;
import java.lang.System;

public class Seq {
    public static void main(String[] args) {
    int start = Integer.parseInt(args[0]);
    int step = Integer.parseInt(args[1]);
    int stop = Integer.parseInt(args[2]);

    int i = start;
    int count = (stop - start) / step + 1;
    
    while (count > 0) {
     System.out.println(i);
     i = i + step;
     count = count - 1;
     }
     
}
}
