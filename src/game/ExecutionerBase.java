package game;

import util.HangmanDictionary;

/*
 * Base HangmanGame Computer
 * 
 * Abstract class used to form the base for both cheating and non cheating computer
 * provides overridable methods and necessary data for both classes.
 * 
 * 
 */

public abstract class ExecutionerBase {
	
	protected String mySecretWord;
	protected HangmanGame hangmanGame;
	protected HangmanDictionary dictionary;
	
	
	public ExecutionerBase(HangmanDictionary dictionary, int wordLength) {
		this.mySecretWord = makeSecretWord(dictionary,wordLength);
	}
	
	


	// Provide an overrideable base method for all Computer types
	public abstract boolean checkGuessInSecret (char guess);
	
	// Returns a secret word which will become the secret word for this. class
	protected String makeSecretWord (HangmanDictionary dictionary, int wordLength) {
		return dictionary.getRandomWord(wordLength).toLowerCase();
	}

	//only in use by the HangmanGame, returns the secret word of the hangman/executioner
	//needs to be overridden so that cheating computer can instead return a random word.
	public String getSecretWord()
	{
		return this.mySecretWord;
	}




	public void setGameVar(HangmanGame newHangmanGame) {
		this.hangmanGame = newHangmanGame;
	}


}
