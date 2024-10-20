package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;


/**
 * This class represents the traditional word-guessing game Hangman
 * that plays interactively with the user.
 *
 * @author Robert C. Duvall
 */
public class CheatingExecutioner extends ExecutionerBase {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    
    /*

    // word that is being guessed
    private String mySecretWord;
    // how many guesses are remaining
    private int myNumGuessesLeft;
    // what is shown to the user
    private DisplayWord myDisplayWord;
    // tracks letters guessed
    private StringBuilder myLettersLeftToGuess;
    
    */
    
    
    // executioner state
    private List<String> myRemainingWords;
    

    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    public CheatingExecutioner (HangmanDictionary dictionary, int wordLength) {
    	super(dictionary, wordLength);
    	this.myRemainingWords = dictionary.getWords(wordLength);
    }



	public void cheat(char guess) {
        // create template of guesses and find one with most matching remaining words
        HashMap<DisplayWord, List<String>> templatedWords = new HashMap<DisplayWord, List<String>>();
        for (String w : myRemainingWords) {
            DisplayWord template = new DisplayWord(this.hangmanGame.getDisplayWord());
            template.update(guess, w);
            if (!templatedWords.containsKey(template)) {
                templatedWords.put(template, new ArrayList<>());
            }
            templatedWords.get(template).add(w);
        }
        int max = 0;
        DisplayWord maxKey = new DisplayWord("");
        for (Entry<DisplayWord, List<String>> entry : templatedWords.entrySet()) {
            //System.out.println(entry.getValue());
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                maxKey = entry.getKey();
            }
        }

        // update secret word to match template of guesses
        myRemainingWords = templatedWords.get(maxKey);
        Collections.shuffle(myRemainingWords);
        mySecretWord = myRemainingWords.get(0);
        this.hangmanGame.updateDisplayWord(guess, mySecretWord);
    }
 
    // Returns true only if given guess is in the secret word.
    @Override
    public boolean checkGuessInSecret (char guess) {
    	cheat(guess);
        if (mySecretWord.indexOf(guess) >= 0) {
			this.hangmanGame.updateDisplayWord(guess, mySecretWord);
			return true;
        }
        return false;
    }


}
