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
public class HangmanGameCheatingComputer  extends Executioner{
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    

    // what is shown to the user
    //private DisplayWord myDisplayWord;
    // tracks letters guessed
    //private StringBuilder myLettersLeftToGuess; 
    // executioner state
    private List<String> myRemainingWords;



    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    public HangmanGameCheatingComputer (HangmanDictionary dictionary, int wordLength) {
    	super(dictionary, wordLength);
        myRemainingWords = dictionary.getWords(wordLength);
    }





    
    public void cheat(char guess) {
        // create template of guesses and find one with most matching remaining words
        HashMap<DisplayWord, List<String>> templatedWords = new HashMap<DisplayWord, List<String>>();
        for (String w : myRemainingWords) {
            DisplayWord template = new DisplayWord(myDisplayWord);
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
        myDisplayWord = maxKey;
    }
 
//    // Record that a specific letter was guessed
//    private void recordGuess (int index) {
//        myLettersLeftToGuess.deleteCharAt(index);
//    }
//
//    // Returns true only if given guess is in the secret word.
//    private boolean checkGuessInSecret (char guess) {
//        if (mySecretWord.indexOf(guess) >= 0) {
//            myDisplayWord.update(guess, mySecretWord);
//            return true;
//        }
//        return false;
//    }

//    // Returns a secret word.
//    private String getSecretWord (HangmanDictionary dictionary, int wordLength) {
//        return dictionary.getRandomWord(wordLength).toLowerCase();
//    }
//
//    // Returns true only if the guesser has guessed all letters in the secret word.
//    private boolean isGameWon () {
//        return myDisplayWord.toString().equals(mySecretWord);
//    }
//
//    // Returns true only if the guesser has used up all their chances to guess.
//    private boolean isGameLost () {
//        return myNumGuessesLeft == 0;
//    }
//
//    // Print game stats
//    private void printStatus () {
//        System.out.println(myDisplayWord);
//        System.out.println("# misses left = " + myNumGuessesLeft);
//        System.out.println("letters not yet guessed = " + myLettersLeftToGuess);
//        // NOT PUBLIC, but makes it easier to test
//        System.out.println("*** " + mySecretWord);
//        System.out.println();
//    }
}
