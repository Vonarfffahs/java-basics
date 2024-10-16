//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
// C3 = 2 - StringBuffer
// C17 = 9 - Задано текст та масив слів. Підрахувати у скількох реченнях зустрічається кожне слово масиву.
public class Main {
    public static void main(String[] args) {
        String sentences = "This is a test sentence. This test is simple. Let's test this again. Protest!";
        String[] wantedWords = {"this", "test", "again"};

        int[] counts = countSentencesWithWantedWords(sentences, wantedWords);

        System.out.println(sentences);
        for (int i = 0; i < counts.length; i++) {
            System.out.printf("Word '%s' found in %d sentences.%n", wantedWords[i], counts[i]);
        }
    }

    public static int[] countSentencesWithWantedWords(String sentences, String[] wantedWords) {
        if (sentences == null || wantedWords == null) {
            throw new IllegalArgumentException("Sentences or wanted words array cannot be null.");
        } else if (sentences.isEmpty() || wantedWords.length == 0) {
            throw new IllegalArgumentException("Text or wanted words cannot be empty.");
        }

        int[] wordsCount = new int[wantedWords.length];
        StringBuffer text = new StringBuffer(sentences);
        int startIndex = 0;

        toLowerCase(text);

        try {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == '.' || text.charAt(i) == '!' || text.charAt(i) == '?') {
                    StringBuffer sentence = new StringBuffer(text.substring(startIndex, i));

                    for (int j = 0; j < wantedWords.length; j++) {
                        if (sentenceHasWord(sentence, wantedWords[j])) {
                            wordsCount[j]++;
                        }
                    }

                    startIndex = i + 1;
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.err.println("Error processing sentence boundaries: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }

        return wordsCount;
    }

    public static void toLowerCase(StringBuffer sb) {
        if (sb == null) {
            throw new IllegalArgumentException("StringBuffer cannot be null.");
        }

        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            sb.setCharAt(i, Character.toLowerCase(ch));
        }
    }

    public static boolean sentenceHasWord(StringBuffer sentence, String word) {
        if (sentence == null || word == null) {
            throw new IllegalArgumentException("Sentence or word cannot be null.");
        }

        int wordIndex = sentence.indexOf(word);

        return  wordIndex != -1 && isSeparateWord(sentence, word, wordIndex);
    }

    public static boolean isSeparateWord(StringBuffer sentence, String word, int wordIndex) {
        int endIndex = wordIndex + word.length();

        if (wordIndex > 0 && Character.isLetterOrDigit(sentence.charAt(wordIndex - 1))) {
            return false;
        } else if (endIndex < sentence.length() && Character.isLetterOrDigit(sentence.charAt(endIndex))) {
            return false;
        }

        return true;
    }
}