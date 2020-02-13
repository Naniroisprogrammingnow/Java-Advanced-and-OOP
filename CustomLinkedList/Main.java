package LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt( br.readLine());
        CustomLinkedList myList = new CustomLinkedList();
        for (int i = 0; i < n; i++) {
            String [] command = br.readLine().split("\\s+");
            int num = Integer.parseInt(command[1]);
            if (command[0].equals("Add")){
                myList.add(num);
            }else{
                myList.remove(num);
            }
        }
        int size = myList.getSize();
        System.out.println(size);
        if (size!=0){
            for (Object a:myList) {
                System.out.print(a+ " ");
            }
        }
    }
}
