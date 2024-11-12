/**
 * Represents a text, composed of multiple sentences.
 * Provides methods to parse sentences, normalize spacing,
 * and convert the text to lowercase.
 */
public class Text {
    private final Sentence[] sentences;

    /**
     * Constructs a Text from a string, parsing it into sentences.
     *
     * @param text the input string to be parsed into a Text object
     */
    public Text(String text) {
        StringBuffer textSB = new StringBuffer(text);

        normalizeSpaces(textSB);

        this.sentences = findSentences(textSB);
    }

    /**
     * Returns the array of sentences in this Text.
     *
     * @return an array of Sentence objects
     */
    public Sentence[] getSentences() {
        return sentences;
    }

    /**
     * Parses and returns sentences in a given StringBuffer text.
     *
     * @param text the StringBuffer containing sentences to parse
     * @return an array of Sentence objects
     */
    public Sentence[] findSentences(StringBuffer text) {
        int sentenceCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '.' || c == '!' || c == '?') {
                sentenceCount++;
            }
        }

        Sentence[] sentences = new Sentence[sentenceCount];

        int sentenceIndex = 0;
        int start = 0;

        // creates sentences based on delimiters
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '.' || c == '!' || c == '?') {
                // add sentences to the array without spaces
                StringBuffer sentence = new StringBuffer();
                for (int j = start; j <= i; j++) {
                    sentence.append(text.charAt(j));
                }
                sentences[sentenceIndex++] = new Sentence(sentence);
                start = i + 2; // start of a new sentence
            }
        }

        return sentences;
    }

    /**
     * Normalizes whitespace in a StringBuffer text, ensuring single spaces between words.
     *
     * @param text the StringBuffer to normalize
     */
    public void normalizeSpaces(StringBuffer text) {
        boolean inWhitespace = false; // if the current character is part of a whitespace sequence
        int writeIndex = 0; // position to write the next non-whitespace character

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == ' ' || c == '\t') {
                if (!inWhitespace) { // if not in a whitespace sequence, write a single whitespace
                    text.setCharAt(writeIndex++, ' ');
                    inWhitespace = true; // indicating we're now in a whitespace sequence
                }
            } else {
                text.setCharAt(writeIndex++, c); // for non-whitespace characters, write the character to the writeIndex
                inWhitespace = false; // we're no longer in a whitespace sequence
            }
        }
        // alter the final length to remove whitespace at the end
        text.setLength(writeIndex > 0 && text.charAt(writeIndex - 1) == ' ' ? writeIndex - 1 : writeIndex);
    }

    /**
     * Calculates the total length of the text, including spaces and punctuation.
     *
     * @return the total length of the text
     */
    public int length() {
        int length = 0;

        for (Sentence sentence : sentences) {
            length += sentence.length();
        }

        length += sentences.length - 1;

        return length;
    }

    /**
     * Converts all sentences in the text to lowercase.
     *
     * @return this Text instance in lowercase
     */
    public Text toLowerCase() {
        for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < sentences[i].length(); j++) {
                sentences[i].toLowerCase();
            }
        }
        return this;
    }

    /**
     * Returns the text as a string.
     *
     * @return the text in string format
     */
    @Override
    public String toString() {
        StringBuffer textString = new StringBuffer();
        for (Sentence sentence : sentences) {
            textString.append(sentence.toString()).append(" ");
        }
        return textString.deleteCharAt(textString.length() - 1).toString(); // remove last space
    }
}