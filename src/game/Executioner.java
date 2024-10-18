package game;

import util.DisplayWord;

//refactored @author jamie mancuso


import util.HangmanDictionary;

public class Executioner {
	
	
	 // word that is being guessed
    protected String mySecretWord;
    // what is shown to the user
    protected DisplayWord myDisplayWord;
    
    public Executioner(HangmanDictionary dictionary, int wordLength) {
    	mySecretWord = makeSecretWord(dictionary, wordLength);
        myDisplayWord = new DisplayWord(mySecretWord);
    }

	 // Returns true only if given guess is in the secret word.
    public boolean checkGuessInSecret (char guess) {
        if (mySecretWord.indexOf(guess) >= 0) {
            myDisplayWord.update(guess, mySecretWord);
            return true;
        }
        return false;
    }

    // Returns a secret word.
    private String makeSecretWord (HangmanDictionary dictionary, int wordLength) {
        return dictionary.getRandomWord(wordLength).toLowerCase();
    }
    
//    public String getMySecretWord() {
//    	return mySecretWord;
//    }
    
    public void printSecretWord() {
    	System.out.println("The secret word was " + mySecretWord);
    }
    public boolean isGameWon () {
        return myDisplayWord.equals(mySecretWord);
    }
    
    public DisplayWord getMyDisplayWord() {
    	return myDisplayWord;
    }

}
