/**
 * Represents a sentence, which is a sequence of words and punctuation.
 * Provides methods to parse and identify words and punctuation,
 * and convert the sentence to lowercase.
 */
public class Sentence {
    private Word[] words;
    private final Punctuation[] punctuationMarks;
    private final int[] punctuationPositions;

    /**
     * Constructs a Sentence from a string, parsing it into words and punctuation marks.
     *
     * @param sentence the input string to be parsed into a Sentence
     */
    public Sentence(String sentence) {
        StringBuffer sentenceSB = new StringBuffer(sentence);

        int punctCount = punctCount(sentenceSB);

        this.words = findWords(sentenceSB);
        this.punctuationMarks = findPunctuations(sentenceSB, punctCount);
        this.punctuationPositions = findPunctuationPos(sentenceSB, punctCount);
    }

    /**
     * Constructs a Sentence from a StringBuffer, parsing it into words and punctuation marks.
     *
     * @param sentence the input StringBuffer to be parsed into a Sentence
     */
    public Sentence(StringBuffer sentence) {
        int punctCount = punctCount(sentence);

        this.words = findWords(sentence);
        this.punctuationMarks = findPunctuations(sentence, punctCount);
        this.punctuationPositions = findPunctuationPos(sentence, punctCount);
    }

    /**
     * Returns the array of punctuation marks in this Sentence.
     *
     * @return an array of Punctuation objects
     */
    public Punctuation[] getPunctuations() {
        return punctuationMarks;
    }

    /**
     * Returns the array of Word objects in this Sentence.
     *
     * @return an array of Word objects
     */
    public Word[] getWords() {
        return words;
    }

    /**
     * Parses and returns words in a given StringBuffer sentence.
     *
     * @param sentence the StringBuffer containing the sentence to parse
     * @return an array of Word objects
     */
    public Word[] findWords(StringBuffer sentence) {
        int whitespacesCount = 0;

        StringBuffer sentenceSB = new StringBuffer(sentence.toString());

        for (int i = 0; i < sentenceSB.length(); i++) {
            if (Punctuation.isPunctuation(sentenceSB.charAt(i))) {
                sentenceSB.replace(i, i+1, "");
            }
        }

        for (int i = 0; i < sentenceSB.length(); i++) {
            if (sentenceSB.charAt(i) == ' ') {
                whitespacesCount++;
            }
        }

        if (whitespacesCount == 0) {
            Word[] words = new Word[1];
            words[0] = new Word(sentenceSB);
            return words;
        }

        int[] whitespacesPositions = new int[whitespacesCount];
        StringBuffer[] wordsSB = new StringBuffer[whitespacesCount + 1];

        int index = 0;

        for (int j = 0; j < sentenceSB.length(); j++) {
            if (sentenceSB.charAt(j) == ' ' && index < whitespacesPositions.length) {
                whitespacesPositions[index] = j;
                index++;
            }
        }

        for (int i = 0; i < wordsSB.length; i++) {
            if (i == 0) {
                // First word in sentence
                wordsSB[i] = new StringBuffer(sentenceSB.substring(0, whitespacesPositions[i]));
            } else if (i == wordsSB.length - 1) {
                // Last word in sentence
                wordsSB[i] = new StringBuffer(sentenceSB.substring(whitespacesPositions[i - 1] + 1, sentenceSB.length()));
            } else {
                // Other words in sentence
                wordsSB[i] = new StringBuffer(sentenceSB.substring(whitespacesPositions[i - 1] + 1, whitespacesPositions[i]));
            }
        }

        Word[] words = new Word[wordsSB.length];
        for (int i = 0; i < wordsSB.length; i++) {
            words[i] = new Word(wordsSB[i]);
        }

        return words;
    }

    /**
     * Counts the punctuation marks in a StringBuffer sentence.
     *
     * @param sentence the sentence to check
     * @return the number of punctuation marks
     */
    public int punctCount(StringBuffer sentence) {
        int punctCount = 0;

        for (int i = 0; i < sentence.length(); i++) {
            if (Punctuation.isPunctuation(sentence.charAt(i))) {
                punctCount++;
            }
        }

        return punctCount;
    }

    /**
     * Finds and returns an array of Punctuation objects in a sentence.
     *
     * @param sentence the StringBuffer containing punctuation marks
     * @param punctCount the number of punctuation marks in the sentence
     * @return an array of Punctuation objects
     */
    public Punctuation[] findPunctuations(StringBuffer sentence, int punctCount) {
        Punctuation[] punctuationMarks = new Punctuation[punctCount];
        int index = 0;

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (Punctuation.isPunctuation(c)) {
                punctuationMarks[index] = new Punctuation(c);
                index++;
            }
        }

        return punctuationMarks;
    }

    /**
     * Finds and returns the position indexes of punctuation marks in a sentence.
     *
     * @param sentence the StringBuffer containing punctuation marks
     * @param punctCount the number of punctuation marks
     * @return an array of punctuation mark positions
     */
    public int[] findPunctuationPos(StringBuffer sentence, int punctCount) {
        int[] punctuationPositions = new int[punctCount];
        int index = 0;

        for (int i = 0; i < sentence.length(); i++) {
            if (Punctuation.isPunctuation(sentence.charAt(i))) {
                punctuationPositions[index] = i;
                index++;
            }
        }

        return punctuationPositions;
    }

    /**
     * Calculates the length of the sentence, including words, punctuation and whitespaces.
     *
     * @return the total length of the sentence
     */
    public int length() {
        int length = 0;

        for (Word word : words) {
            length += word.length();
        }

        length += punctuationMarks.length;
        length += words.length - 1; // whitespaces count

        return length;
    }

    /**
     * Converts all words in the sentence to lowercase.
     *
     * @return this Sentence instance in lowercase
     */
    public Sentence toLowerCase() {
        for (Word word : words) {
            word.toLowerCase();
        }
        return this;
    }

    /**
     * Checks if a specific word exists within the sentence.
     *
     * @param wantedWord the word to search for
     * @return true if the word exists, false otherwise
     */
    public boolean sentenceHasWord(String wantedWord) {
        for (Word word : words) {
            if (word.equals(wantedWord)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the sentence as a string.
     *
     * @return the sentence in string format
     */
    @Override
    public String toString() {
        StringBuffer sentence = new StringBuffer();

        for (int i = 0; i < words.length; i++) {
            sentence.append(words[i]);
            if (i < words.length - 1) {
                sentence.append(" ");
            }
        }

        for (int i = 0; i < punctuationMarks.length; i++) {
            int pos = punctuationPositions[i];
            // Checks if the position does not extend beyond the current row
            if (pos >= 0 && pos <= sentence.length()) {
                sentence.insert(pos, punctuationMarks[i].getPunctuation());
            }
        }

        return sentence.toString();
    }
}
