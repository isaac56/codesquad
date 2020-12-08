package codesquad;

public class Cube {
	private char[][] current = {{'R','R','W'},{'G','C','W'},{'G','B','B'}};
	
	public Cube () {
	}
	
	@Override
	public String toString() {
		String result = "";
		for(char[] row : current) {
			for(char element : row) {
				result += String.valueOf(element) + " ";
			}
			result += "\n";
		}
		return result;
	}
}
