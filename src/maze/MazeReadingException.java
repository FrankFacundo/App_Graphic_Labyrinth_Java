package maze;

public class MazeReadingException extends Exception {
	
	/**
	 * 
	 * @param fileName, the name of the file that we are trying to read
	 * @param rowNumber, the number of the erroneous line
	 * @param errorMessage, the error message to display
	 */
	public MazeReadingException(String fileName, int rowNumber, String errorMessage) {
		
		super("Unable to read the file " + fileName + ". Error found at the labyrinth (row number:" 
		+ rowNumber + "). " + errorMessage);
		
	}

}
