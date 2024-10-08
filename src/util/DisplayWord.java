package util;


/**
 * This class represents a hidden word, displaying only some of the letters.
 * 
 * It overrides equals() and hashCode() so that it can be stored in collections
 * like Lists and Maps.
 * 
 * @author Robert C. Duvall
 */
public class DisplayWord {
    public static final String BLANK = "_";
    public static final String SPACER = " ";

    private StringBuilder myDisplayWord;


    /**
     * Create a display word with blanks indicating where the letters are in the sourceWord.
     */
    public DisplayWord (String sourceWord) {
        myDisplayWord = new StringBuilder(sourceWord.length());
        for (char ch : sourceWord.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                myDisplayWord.append(BLANK);
            }
            else {
                myDisplayWord.append(ch);
            }
        }
    }

    /**
     * Create a display word with blanks indicating where the letters are in the sourceWord.
     */
    public DisplayWord (DisplayWord other) {
        myDisplayWord = new StringBuilder(other.myDisplayWord);
    }

    /**
     * Update displayed knowledge based on given guess for given source word.
     */
    public void update (char guess, String sourceWord) {
        for (int k = 0; k < sourceWord.length(); k += 1) {
            if (sourceWord.toLowerCase().charAt(k) == guess) {
                myDisplayWord.setCharAt(k, guess);
            }
        }
    }

    /**
     * Returns displayable version of the secret word based on the history of guesses.
     *
     * @see Object#toString()
     */
    @Override
    public String toString () {
        StringBuilder result = new StringBuilder();
        for (int k = 0; k < myDisplayWord.length(); k += 1) {
            result.append(myDisplayWord.charAt(k)).append(SPACER);
        }
        return result.toString();
    }

    /**
     * Returns true only if all characters are the same.
     *
     * Note, can compare with any other String-like object.
     * 
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals (Object other) {
        return other != null &&
               (toString().equals(other.toString()) || myDisplayWord.toString().equals(other.toString()));
    }
    
    /**
     * Returns hash value for this object so it can be used in a HashMap.
     * 
     * @see Object#hashCode()
     */
    @Override
    public int hashCode () {
        return myDisplayWord.toString().hashCode();
    }
}
