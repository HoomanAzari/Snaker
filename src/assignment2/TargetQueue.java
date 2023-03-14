package assignment2;

import java.util.NoSuchElementException;

public class TargetQueue extends MyQueue<Position> {
    private MyStack<String> string_Stack;       //used to check the validity of  input
    private String num;             //used to save numbers for iterations

    public TargetQueue() {
        super();                //TODO calls superclass constructor and initializes its fields.
        this.string_Stack = new MyStack<>();
    }

    public void clear() {
        super.clear();
        string_Stack.clear();
    }

    public void addTarget(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            char c = input.charAt(i);
            if ((c == '(') && (super.isEmpty()) & string_Stack.isEmpty()) {                 //have to you use '' not "" when referring to characters
                string_Stack.push(Character.toString(c));
            } else if (Character.isDigit(c)) {                             //not sure why I'm using Character
                this.num += c;

            } else if (c == ',') {                             //not directly checking for validity of integer
                if (this.num.isEmpty()) {
                    throw new IllegalArgumentException("Invalid input.");           //not sure about this part //Todo illegal argument or no such element
                }
                string_Stack.push(num);
                string_Stack.push(Character.toString(c));
                this.num = "";

            } else if (c == ')') {
                if ((string_Stack.getSize() == 3) && ((string_Stack.peek().equals(","))) && (!(this.num.isEmpty())) && ((string_Stack.peekEnd().equals("(")))) {
                    Position()                  //TODO where do i get y?
            } else if (this.num.isEmpty()) {
                throw new IllegalArgumentException("Invalid input.");               //TODO illegal argument or no such element
            } else {
                throw new NoSuchElementException("Invalid input.");
            }
            }
           else if (c == '.') {

            }
        }
    }
}

