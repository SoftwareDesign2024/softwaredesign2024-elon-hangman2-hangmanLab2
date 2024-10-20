package game;

import util.HangmanDictionary;

public class HonestExecutioner extends ExecutionerBase {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private String mySecretWord;
	private HangmanGame hangmanGame;


    public HonestExecutioner (HangmanDictionary dictionary, int wordLength) {
    	super(dictionary, wordLength);
    }

	//only in use by the HangmanGame, returns the secret word of the hangman/executioner
	public String getSecretWord()
	{
		return this.mySecretWord;
	}
	
	
	//honestly checks the guess before returning the result, no cheating
	@Override
	public boolean checkGuessInSecret(char guess) {
		if (mySecretWord.indexOf(guess) >= 0) {
			this.hangmanGame.updateDisplayWord(guess, mySecretWord);
			return true;
		}
		return false;
	}
}
