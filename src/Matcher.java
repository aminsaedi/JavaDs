import java.util.ArrayList;
import java.util.Stack;

public class Matcher {

    private Character getReverseOf(Character input){
        if (input == '(') return ')';
        if (input == '<') return '>';
        if (input == '{') return '}';
        if (input == '[') return ']';
        if (input == ')') return '(';
        if (input == '>') return '<';
        if (input == '}') return '{';
        if (input == ']') return '[';
        return null;
    }
    public boolean isMatch(String input){

        ArrayList<Character> openings = new ArrayList<>();
        openings.add('(');
        openings.add('<');
        openings.add('{');
        openings.add('[');
        ArrayList<Character> closings = new ArrayList<>();
        closings.add(')');
        closings.add('>');
        closings.add('}');
        closings.add(']');

        Stack<Character> stack = new Stack<>();
        for (char ch :
                input.toCharArray()) {
            if (openings.contains(ch)) stack.push(ch);

            else if (closings.contains(ch)) {

                if (stack.isEmpty()) return  false;
                var top = stack.pop();
                if (top != getReverseOf(ch)) return false;
            }
        }

       return stack.isEmpty();
    }
}
