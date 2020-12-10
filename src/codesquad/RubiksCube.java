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
