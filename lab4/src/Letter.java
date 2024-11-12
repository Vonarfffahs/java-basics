/**
 * Represents a single letter in a word, ensuring it is alphabetic.
 * Provides methods to convert the letter to lowercase and check
 * if a character is an alphabetic letter.
 */
public class Letter {
    private char character;

    /**
     * Constructs a Letter with the given character.
     * Throws an exception if the character is not an alphabetic letter.
     *
     * @param character the character to be wrapped in a Letter object
     * @throws IllegalArgumentException if character is not alphabetic
     */
    public Letter(char character) {
        if (!isLetter(character)) {
            throw new IllegalArgumentException("The given character is not an alphabetic letter");
        }

        this.character = character;
    }

    /**
     * Returns the character of this Letter.
     *
     * @return the character represented by this Letter
     */
    public char getLetter() {
        return character;
    }

    /**
     * Converts the character of this Letter to lowercase.
     *
     * @return this Letter instance in lowercase
     */
    public Letter toLowerCase() {
        character = Character.toLowerCase(character);
        return this;
    }

    /**
     * Checks if the given character is alphabetic.
     *
     * @param letter the character to check
     * @return true if the character is alphabetic, false otherwise
     */
    public boolean isLetter(char letter) {
        return  letter != '.' && letter != '!' && letter != '?' &&
                letter != ',' && letter != ';' && letter != ':' &&
                letter != '[' && letter != ']' && letter != '{' &&
                letter != '}' && letter != '\"';
    }
}
