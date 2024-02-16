package task2;

import java.util.Stack;

public class BracketSequenceAlgorithm {

    public String validateBracketSequence(String sequence) {
        Stack<Character> stack = new Stack<>();
        char[] sequenceChars = sequence.toCharArray();
        StringBuilder messageBuilder = new StringBuilder();
        for (int i = 0; i < sequenceChars.length; i++) {
            if (sequenceChars[i] == '(' || sequenceChars[i] == '[') {
                stack.push(sequenceChars[i]);
            } else if (sequenceChars[i] == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (sequenceChars[i] == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                messageBuilder.append("Closing bracket '").append(sequenceChars[i]).append("' at position ")
                        .append(i).append(" doesn't have corresponding opening bracket.").append('\n');
                stack.pop();
            }
        }
        return messageBuilder.toString();
    }

    public boolean isCorrectBracketSequence(String sequence) {
        return "".equals(validateBracketSequence(sequence));
    }

    public String correctBracketSequence(String sequence) {
        Stack<Character> stack = new Stack<>();
        StringBuilder correctedSequence = new StringBuilder(sequence);

        for (int i = 0; i < sequence.length(); i++) {
            char bracket = sequence.charAt(i);
            if (bracket == '(' || bracket == '[') {
                stack.push(bracket);
            } else if (bracket == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (bracket == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (bracket == ']' || bracket == ')') {
                if (bracket == ')') {
                    correctedSequence.setCharAt(i,  ']');
                    System.out.println("Closing bracket ')' at position " + i + " changed to ']'.");
                } else {
                    correctedSequence.setCharAt(i,  ')');
                    System.out.println("Closing bracket ']' at position " + i + " changed to ')'.");
                }
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            char top = stack.pop();
            System.out.println("Removed unclosing bracket '" + top + "'.");
            correctedSequence.deleteCharAt(sequence.indexOf(top));
        }

        return correctedSequence.toString();
    }
}
