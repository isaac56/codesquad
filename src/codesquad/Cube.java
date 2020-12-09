package codesquad;

public class Cube {
	private char[][] current = {{'R','R','W'},{'G','C','W'},{'G','B','B'}};
	
	public Cube () {
	}
	
	public void shiftLeft(int row) {
		if(row < 0 || row >= 3)
			return;
		
		char[] temp = new char[3];
		for(int i = 0; i < 3; i++) {
			temp[i] = this.current[row][(i + 1) % 3];
		}
		replaceRow(row, temp);
	}
	
	public void shiftRight(int row) {
		if(row < 0 || row >= 3)
			return;
		
		char[] temp = new char[3];
		for(int i = 0; i < 3; i++) {
			temp[i] = this.current[row][(3 + i - 1) % 3];
		}
		replaceRow(row, temp);
	}
	
	public void shiftUp(int col) {
		if(col < 0 || col >= 3)
			return;
		
		char[] temp = new char[3];
		for(int i = 0; i < 3; i++) {
			temp[i] = this.current[(i + 1) % 3][col];
		}
		replaceColumn(col, temp);
	}
	
	public void shiftDown(int col) {
		if(col < 0 || col >= 3)
			return;
		
		char[] temp = new char[3];
		for(int i = 0; i < 3; i++) {
			temp[i] = this.current[(3 + i - 1) % 3][col];
		}
		replaceColumn(col, temp);
	}
	
	public void replaceColumn(int col, char[] toReplace) {
		if(toReplace.length < 3 || (col < 0 || col >= 3)) 
			return;
		
		for(int i = 0; i < 3; i++) {
			this.current[i][col] = toReplace[i];
		}
	}
	
	public void replaceRow(int row, char[] toReplace) {
		if(toReplace.length < 3 || (row < 0 || row >= 3)) 
			return;
		
		this.current[row] = toReplace;	
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
