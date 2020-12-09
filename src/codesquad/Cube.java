package codesquad;

public class Cube {
	private char[][] current = {{'R','R','W'},{'G','C','W'},{'G','B','B'}};
	
	public Cube () {
	}
		
	public void shiftLeft(int row, int num) {
		if(row < 0 || row >= 3)
			return;
		
		//num이 음수인 경우를 고려하여 계산
		num = 3 + (num % 3);
		
		char[] temp = new char[3];
		for(int i = 0; i < 3; i++) {
			temp[i] = this.current[row][(i + num) % 3];
		}
		replaceRow(row, temp);
	}
	
	public void shiftUp(int col, int num) {
		if(col < 0 || col >= 3)
			return;
		
		//num이 음수인 경우를 고려하여 계산 
		num = 3 + (num % 3);
		
		char[] temp = new char[3];
		for(int i = 0; i < 3; i++) {
			temp[i] = this.current[(i + num) % 3][col];
		}
		replaceColumn(col, temp);
	}
	
	private void replaceColumn(int col, char[] toReplace) {
		if(toReplace.length < 3 || (col < 0 || col >= 3)) 
			return;
		
		for(int i = 0; i < 3; i++) {
			this.current[i][col] = toReplace[i];
		}
	}
	
	private void replaceRow(int row, char[] toReplace) {
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
