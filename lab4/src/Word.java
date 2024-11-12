/**
 * Represents a word, composed of a sequence of Letter objects.
 * Validates that the input string contains only a single word.
 * Provides methods to get the letters, check equality with a string,
 * convert the word to lowercase, and calculate word length.
 */
public class Word {
    private Letter[] letters;

    /**
     * Constructs a Word from a StringBuffer.
     * Throws an exception if the input contains more than one word.
     *
     * @param wordSB a StringBuffer containing a single word
     * @throws IllegalArgumentException if input has more than one word
     */
    public Word(StringBuffer wordSB) {
        if (!isASingleWord(wordSB)) {
            throw new IllegalArgumentException("The input must contain only one word");
        }

        this.letters = new Letter[wordSB.length()];
        for (int i = 0; i < wordSB.length(); i++) {
            letters[i] = new Letter(wordSB.charAt(i));
        }
    }

    /**
     * Returns the array of Letter objects in this Word.
     *
     * @return an array of Letter objects
     */
    public Letter[] getLetters() {
        return letters;
    }

    /**
     * Checks if the input contains a single word.
     *
     * @param word the StringBuffer to check
     * @return true if input is a single word, false otherwise
     */
    public boolean isASingleWord(StringBuffer word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isWhitespace(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the length of the word.
     *
     * @return the number of letters in the word
     */
    public int length() {
        return letters.length;
    }

    /**
     * Converts all letters in the word to lowercase.
     *
     * @return this Word instance in lowercase
     */
    public Word toLowerCase() {
        for (Letter letter : letters) {
            letter.toLowerCase();
        }
        return this;
    }

    /**
     * Checks if the word is equal to a given string.
     *
     * @param otherWord the string to compare with
     * @return true if equal, false otherwise
     */
    public boolean equals(String otherWord) {
        if (this.length() != otherWord.length()) {
            return false; // Якщо кількість літер різна
        }
        for (int i = 0; i < letters.length; i++) {
            if ( letters[i].getLetter() != otherWord.charAt(i) ) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the word as a string.
     *
     * @return the word in string format
     */
    @Override
    public String toString() {
        StringBuffer word = new StringBuffer();

        for (Letter letter : letters) {
            word.append(letter.getLetter());
        }

        return word.toString();
    }
}
