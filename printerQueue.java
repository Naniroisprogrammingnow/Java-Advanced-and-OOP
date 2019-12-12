import java.util.ArrayDeque;
import java.util.Scanner;

public class printerQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        ArrayDeque<String> printer = new ArrayDeque<>();
        String doc = scanner.nextLine();
        while(!doc.equals("print")){
            if(doc.equals("cancel")){
                if(printer.size()==0){
                    System.out.println("Printer is on standby");
                }else{
                    System.out.println("Canceled " + printer.poll());
                }
            }else{
                printer.offer(doc);
            }
            doc = scanner.nextLine();
        }
        while(printer.size()>0){
            System.out.println(printer.poll());
        }
    }
}
