import java.util.ArrayDeque;
import java.util.Scanner;

public class reversePolishNotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        //Shunting-yard algoryth

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            String curr = input[i];
            if(Character.isLetterOrDigit(curr.charAt(0))){
                queue.offer(curr);
            }else{
                if(stack.isEmpty()){
                    stack.push(curr);
                    continue;
                }
                if((curr.equals("+") || curr.equals("-"))){
                    if(stack.peek().equals("+") || stack.peek().equals("-")){
                        queue.offer(stack.pop());
                    }
                    stack.push(curr);
                }
                if(curr.equals("(")){
                    stack.push(curr);
                }else if(curr.equals(")")){
                    while (!stack.peek().equals("(")){
                        queue.offer(stack.pop());
                    }
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }
                if(curr.equals("*") || curr.equals("/")){
                    stack.push(curr);
                }


            }
        }
        while (!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
