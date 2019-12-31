import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);;

        String[] calc = scanner.nextLine().split(" ");
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        for (int i = calc.length-1; i >=0 ; i--) {
            arrayDeque.push(calc[i]);
        }
        int res = Integer.parseInt(arrayDeque.pop());
        while(arrayDeque.size()>0) {
             if(!arrayDeque.pop().equals("-")){
                 res+=Integer.parseInt(arrayDeque.pop());
             }else{
                 res-=Integer.parseInt(arrayDeque.pop());
             }
        }
        System.out.println(res);
    }
}
