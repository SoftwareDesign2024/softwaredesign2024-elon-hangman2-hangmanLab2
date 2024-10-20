package game;

import util.ConsoleReader;

public class ManualGuesser extends GuesserBase {

	public ManualGuesser(int numGuesses, int wordLength) {
		super(numGuesses, wordLength);
		
	}
	@Override
	public String decideLetterToGuess()
	{
		String guess = ConsoleReader.promptString("Make a guess: ");
		return guess;
	}

}
