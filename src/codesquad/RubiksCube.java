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
	
	public void U() {
		char[] temp = frontPlane.getRow(0);
		
		frontPlane.setRow(0, rightPlane.getRow(0));
		rightPlane.setRow(0, rearPlane.getRow(0));
		rearPlane.setRow(0, leftPlane.getRow(0));
		leftPlane.setRow(0, temp);
	}
	
	public void U_R() {
		char[] temp = frontPlane.getRow(0);
		
		frontPlane.setRow(0, leftPlane.getRow(0));
		leftPlane.setRow(0,  rearPlane.getRow(0));
		rearPlane.setRow(0,  rightPlane.getRow(0));
		rightPlane.setRow(0, temp);
	}
	
	@Override
	public String toString() {
		String result = "[Rubik's cube state] \n";
		for(int i = 0; i < 3; i++) {
			result += "\t" + topPlane.getRowString(i) + "\n";
		}
		result += "\n";
		
		for(int i = 0; i < 3; i++) {
			result += leftPlane.getRowString(i) + "\t" 
					+ frontPlane.getRowString(i) + "\t"
					+ rightPlane.getRowString(i) + "\t"
					+ rearPlane.getRowString(i) + "\n";
		}
		result += "\n";
		
		for(int i = 0; i < 3; i++) {
			result += "\t" + bottomPlane.getRowString(i) + "\n";
		}
		result += "\n";
		
		return result;
	}
	
	private class Plane {
		private char[][] state;
		
		public Plane() {
			state = new char[3][3];
			char t = 'A';
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					state[i][j] = t;
					t++;
				}
			}
		}
		
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
		
		public void setRow(int row, char[] toReplace) {
			if(toReplace.length != 3) {
				return;
			}
			this.state[row] = toReplace;
		}
		
		public void setCol(int col, char[] toReplace) {
			if(toReplace.length != 3) {
				return;
			}
			for(int i = 0; i < 3; i++) {
				this.state[i][col] = toReplace[i];
			}
		}
		
		public void setRowReverse(int row, char[] toReplace) {
			if(toReplace.length != 3) {
				return;
			}
			for(int i = 0; i < 3; i++) {
				this.state[row][2-i] = toReplace[i];
			}
		}
		
		public void setColReverse(int col, char[] toReplace) {
			if(toReplace.length != 3) {
				return;
			}
			for(int i = 0; i < 3; i++) {
				this.state[2-i][col] = toReplace[i];
			}
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
