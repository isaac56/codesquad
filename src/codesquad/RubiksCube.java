package codesquad;

public class RubiksCube {
	private Plane frontPlane = new Plane('W');
	private Plane rearPlane = new Plane('G');
	private Plane leftPlane = new Plane('O');
	private Plane rightPlane = new Plane('Y');
	private Plane topPlane = new Plane('B');
	private Plane bottomPlane = new Plane('R');
	
	public RubiksCube() {
		
	}
	
	
	@Override
	public String toString() {
		String result = "";
		result += ("TOP\n");
		result += topPlane + "\n";
		
		result += "FRONT\tRIGHT\tREAR\tLEFT\n";
		for(int i = 0; i < 3; i++) {
			result += frontPlane.getRowString(i) + "\t"
					+ rightPlane.getRowString(i) + "\t"
					+ rearPlane.getRowString(i) + "\t"
					+ leftPlane.getRowString(i) + "\n";
		}
		result += "\n";
		
		result += "BOTTOM\n";
		result += bottomPlane + "\n";
		
		return result;
	}
	
	private class Plane {
		private char[][] state;
		
		public Plane (char init) {
			state = new char[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					state[i][j] = init;
				}
			}
		}
		
		public char[] getRow(int row) {
			return state[row];
		}
		
		public char[] getCol(int col) {
			char[] column = new char[3];
			for(int i = 0; i < 3; i++) {
				column[i] = state[i][col];
			}
			return column;
		}
		
		public String getRowString (int row) {
			String result = "";
			for(int i = 0; i < 3; i++) {
				result += state[row][i] + " ";
			}
			return result;
		}
		
		@Override
		public String toString() {
			String result = "";
			for(char[] row : state) {
				for(char element : row) {
					result += String.valueOf(element) + " ";
				}
				result += "\n";
			}
			return result;
		}
	}
}
