package game;

import util.DisplayWord;

public abstract class GuesserBase {
	
	protected static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    // tracks letters guessed
    protected StringBuilder myLettersLeftToGuess;
    protected int myNumGuessesLeft;
    protected DisplayWord myDisplayWord;
    
    protected HangmanGame hangmanGame;
    
    //gives the Guesser a display word object so that this class is never exposed to the secret word.
    public GuesserBase(int numGuesses,int wordLength)
    {
    	this.myNumGuessesLeft = numGuesses;
    	this.myLettersLeftToGuess = new StringBuilder(ALPHABET);
    	
    }
    
    public void setDisplayWord(DisplayWord displayWord)
    {
    	this.myDisplayWord = displayWord;
    }
    
    
    //returns the number of Guesses left, only in use by HangmanGame
    public int getNumberofGuesses()
    {
    	return myNumGuessesLeft;
    }
    
    //returns the DisplayWord object of this class, only in use by HangmanGame
    public DisplayWord getDisplayword()
    {
    	return this.myDisplayWord;
    }
    
    //returns the letters left to guess, only in use by HangmanGame
    public StringBuilder getLettersLeftToGuess()
    {
    	return this.myLettersLeftToGuess;
    }
    
    //remove the guessed letter from the letters left to guess
    protected void recordGuess (int index) {
        myLettersLeftToGuess.deleteCharAt(index);
    }
    
    //overrideable method call for making a guess, whether automatic or otherwise
    public void makeGuess (char guess) {
        // do not count repeated guess as a miss
        int index = myLettersLeftToGuess.indexOf("" + guess);
        if (index >= 0) {
            recordGuess(index);
            if (!hangmanGame.checkGuess(guess)) {
                myNumGuessesLeft -= 1;
            }
        }
    }
	//updates the display word from Executioner with HangmanGame as a middle man	
	public void updateDisplayWord(char guess, String mySecretWord) {
		this.myDisplayWord.update(guess, mySecretWord);
		
	}


	public void setGameVar(HangmanGame newHangmanGame) {
		this.hangmanGame = newHangmanGame;
	}

	public void makeDisplayWord(DisplayWord displayWord) 
	{
		this.myDisplayWord = displayWord;
	}

	public abstract String decideLetterToGuess();

}

