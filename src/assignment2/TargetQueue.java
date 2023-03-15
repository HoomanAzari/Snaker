package assignment2;

import java.util.NoSuchElementException;

public class TargetQueue extends MyQueue<Position> {
    private MyStack<String> string_Stack;       //used to check the validity of  input
    private String num;             //used to save numbers for iterations

    public TargetQueue() {
        super();
        this.string_Stack = new MyStack<String>();
    }

    public void clear() {
        super.clear();
        if (!(this.string_Stack.isEmpty())) {
            string_Stack.clear();
        }
    }

    public void addTarget(String input) {
        boolean end = false;
        for (int i = 0; i < input.length() - 1; i++) {                  //TODO length-1 or length
            char c = input.charAt(i);
            if (c == '(') {
                if (!(this.string_Stack.isEmpty()) || !(this.num.isEmpty()) || end) {
                    throw new IllegalArgumentException();
                } else {
                    this.string_Stack.push("(");
                }

            } else if (Character.isDigit(c)) {                             //not sure why I'm using Character
                if (this.num.isEmpty()) {
                    this.num = "";
                }
                this.num += c;

            } else if (c == ',') {
                if (this.num.isEmpty()) {
                    throw new IllegalArgumentException("Invalid input.");
                } else {
                    string_Stack.push(num);
                    string_Stack.push(",");
                    this.num = "";
                }

            } else if (c == ')') {
                if (this.string_Stack.getSize() != 3) {
                    throw new IllegalArgumentException("Invalid input.");
                } else {
                    int number;
                    if (this.string_Stack.pop().equals(",")) {
                        try {
                            number = Integer.parseInt(this.string_Stack.pop());
                        } catch (Exception e) {
                            throw new IllegalArgumentException("Invalid input.");
                        }
                        if (!(this.string_Stack.pop().equals("("))) {
                            throw new IllegalArgumentException("Invalid input.");
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid input.");
                    }
                    if (this.num.isEmpty()) {
                        throw new IllegalArgumentException("Invalid input.");
                    }
                    Position position = new Position(number, Integer.parseInt(this.num));
                    this.enqueue(position);
                    end = true;
                    this.num = "";
                }
            } else if (c == '.') {
                if (!(this.num.isEmpty()) || !(this.string_Stack.isEmpty())) {
                    throw new IllegalArgumentException("Invalid input.");
                }
                end = false;
            } else {
                throw new IllegalArgumentException("Invalid input.");
            }
        }
        if (!(this.string_Stack.isEmpty()) || !(this.num.isEmpty())) {
            throw new IllegalArgumentException("Invalid input.");
        }
    }
}
