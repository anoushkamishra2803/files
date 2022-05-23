package OOPSASSINGMENT;

import java.util.*;

public class Q3 {
    public static void main(String[] args){
        System.out.println("Input an expression: ");
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        boolean result = Brackets.checkBalance(expression);
        if(result){
            System.out.println("The brackets are balanced.");
        } else{
            System.out.println("There is a bracket imbalance.");
        }
        in.close();

    }
}
class Brackets{
    static boolean checkBalance(String given) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < given.length(); i++) {
            char currentChar = given.charAt(i);

            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
                continue;
            }

            if (stack.isEmpty())
                return false;
            char check;
            switch (currentChar) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }
}