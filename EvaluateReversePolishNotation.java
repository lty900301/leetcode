import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * http://en.wikipedia.org/wiki/Reverse_Polish_notation Valid operators are +, -, *, /. Each operand may be an integer
 * or another expression.
 * 
 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * @author joshluo
 * 
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> values = new Stack<Integer>();
        for (String token : tokens) {
            if (token.equals("+")) {
                values.push(values.pop() + values.pop());
            } else if (token.equals("-")) {
                int minused = values.pop();
                values.push(values.pop() - minused);
            } else if (token.equals("*")) {
                values.push(values.pop() * values.pop());
            } else if (token.equals("/")) {
                int divided = values.pop();
                values.push(values.pop() / divided);
            } else {
                values.push(Integer.parseInt(token));
            }
        }
        return values.pop();
    }
}
