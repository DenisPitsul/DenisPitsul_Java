package task2;

public class Task2 {

    public static void main(String[] args) {
        BracketSequenceAlgorithm algorithm = new BracketSequenceAlgorithm();

        String bracketSequence = "[((())()(())]]";
        if (algorithm.isCorrectBracketSequence(bracketSequence)) {
            System.out.println("The bracket sequence is correct.");
        } else {
            System.out.println("The bracket sequence is incorrect.");
            System.out.println(algorithm.validateBracketSequence(bracketSequence));
            String correctedSequence = algorithm.correctBracketSequence(bracketSequence);
            System.out.println("Corrected sequence: " + correctedSequence);
        }
    }
}
