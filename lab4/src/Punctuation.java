public class Punctuation {
    private final char punctuation;

    public Punctuation(char punctuation) {
        if(!isPunctuation(punctuation)) {
            throw new IllegalArgumentException("The argument is not a punctuation ('.', '!', '?')");
        }

        this.punctuation = punctuation;
    }

    public char getPunctuation() {
        return punctuation;
    }

    public static boolean isPunctuation(char punctuation) {
        return punctuation == '.' || punctuation == '!' || punctuation == '?' ||
               punctuation == ',' || punctuation == ';' || punctuation == ':' ||
               punctuation == '[' || punctuation == ']' || punctuation == '{' ||
               punctuation == '}' || punctuation == '\"';
    }
}
