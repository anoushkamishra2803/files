package OOPSASSINGMENT;

import java.util.*;


class MinimumStack {
    Stack<Integer> s;
    int least;

    MinimumStack() {
        s = new Stack<Integer>();
    }

    void getMin() {
        if (s.isEmpty())
            System.out.println("Stack is empty");
        else
            System.out.println("Minimum Element in the " + " stack is: " + least);
    }

    void peek() {
        if (s.isEmpty()) {
            System.out.println("Stack is empty ");
            return;
        }

        int peek = s.peek(); // Top element.

        System.out.print("Top of stack is: " );

        if (peek < least)
            System.out.println(least);
        else
            System.out.println(peek);
    }

    void pop() {
        if (s.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.print("Top Most Element Removed: ");
        Integer t = s.pop();


        if (t < least) {
            System.out.println(least);
            least = 2 * least - t;
        }

        else
            System.out.println(t);
    }

    void push(int x) {
        if (s.isEmpty()) {
            least = x;
            s.push(x);
            System.out.println("Number Inserted: " + x);
            return;
        }

        if (x < least) {
            s.push(2 * x - least);
            least = x;
        }

        else
            s.push(x);

        System.out.println("Number Inserted: " + x);
    }
};

public class Q2 {
    public static void main(String[] args) {
        MinimumStack s = new MinimumStack();
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        while (exit != true) {
            System.out.println("What operation dye want to do?[Push(0), Pop(1), Peek(2), Get Minimum(3), Exit(4)]: ");
            int input = in.nextInt();
            switch (input) {
                case 0:
                    System.out.print("Enter value to push: ");
                    s.push(in.nextInt());
                    break;
                case 1:
                    s.pop();
                    break;
                case 2:
                    s.peek();
                    break;
                case 3:
                    s.getMin();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

        }
        in.close();
    }
}