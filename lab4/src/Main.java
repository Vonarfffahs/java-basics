public class Main {
    public static void main(String[] args) {
        System.out.println("The text before replacing tabulation and few whitespaces with one whitespace:");
        System.out.println("This          is,     a sample text.   How are you?");
        Text text1 = new Text("This          is,     a sample text.   How are you?");
        System.out.println("The text after:");
        System.out.println(text1);

        System.out.println("\nThe input text:");
        Text text = new Text("Hey, this is a test sentence. Is this test simple? Let's test this again. Protest!");
        System.out.println(text);

        String[] wantedWords = {"this", "test", "again", "is"};
        System.out.println("Wanted words:");
        for (int i = 0; i < wantedWords.length; i++) {
            if (i == wantedWords.length - 1) {
                System.out.println(wantedWords[i] + '\n');
            } else {
                System.out.print(wantedWords[i] + ", ");
            }
        }

        int[] counts = countSentencesWithWantedWords(text, wantedWords);

        for (int i = 0; i < counts.length; i++) {
            System.out.printf("Word '%s' found in %d sentences.%n", wantedWords[i], counts[i]);
        }
    }

    /**
     * Counts the number of sentences in the provided Text that contain each of the specified words.
     *
     * @param text the Text object containing sentences to analyze
     * @param wantedWords an array of words to search for in each sentence
     * @return an array of integers where each element represents the count of sentences containing the corresponding word
     */
    public static int[] countSentencesWithWantedWords(Text text, String[] wantedWords) {

        int[] wordsCount = new int[wantedWords.length];

        text.toLowerCase();

        for (int i = 0; i < text.getSentences().length; i++) {
            Sentence sentence = text.getSentences()[i];

            for (int j = 0; j < wantedWords.length; j++) {
                if (sentence.sentenceHasWord(wantedWords[j])) {
                    wordsCount[j]++;
                }
            }
        }

        return wordsCount;
    }
}