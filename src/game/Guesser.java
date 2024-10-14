package game;

public class Guesser {
	// how many guesses are remaining
    private int myNumGuessesLeft;
 // tracks letters guessed
    private StringBuilder myLettersLeftToGuess;
    
    public Guesser(String alphabet,int numGuesses) {
        myLettersLeftToGuess = new StringBuilder(alphabet);
        myNumGuessesLeft = numGuesses;
    }
    
   

    // Record that a specific letter was guessed
    public void recordGuess (int index) {
        myLettersLeftToGuess.deleteCharAt(index);
    }
    
    public StringBuilder getMyLettersLeftToGuess() {
    	return myLettersLeftToGuess;
    }
    
    public int getmyNumGuessesLeft() {
    	return myNumGuessesLeft;
    }
    
    public void subtractGuess() {
    	myNumGuessesLeft -= 1;
    }
}
