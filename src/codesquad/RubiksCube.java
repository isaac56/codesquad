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
	
	public String restoreCmd(char cmd) {
		if(cmd == 'u' || cmd == 'l' || cmd == 'f' ||
		   cmd == 'r' || cmd == 'b' || cmd == 'd')
		{
			return (cmd + ('A' - 'a')) + "'";
		}
		else {
			return String.valueOf(cmd);
		}
	}
	
	public String filterCmd(String cmd) {
		//U',L',F',R',B',D'와 u,l,f,r,b,d를 혼동하지 않도록 filtering하기 전에 소문자 제거 
		cmd = cmd.replace("u", "");
		cmd = cmd.replace("l", "");
		cmd = cmd.replace("f", "");
		cmd = cmd.replace("r", "");
		cmd = cmd.replace("b", "");
		cmd = cmd.replace("d", "");
		
		//U',L',F',R',B',D'를 소문자로 변경 
		cmd = cmd.replace("U'", "u");
		cmd = cmd.replace("L'", "l");
		cmd = cmd.replace("F'", "f");
		cmd = cmd.replace("R'", "r");
		cmd = cmd.replace("B'", "b");
		cmd = cmd.replace("D'", "d");
		return cmd;
	}
	
	public boolean executeCmd(char cmd) {
		if(cmd == 'U') { U(); 	return true; }
		if(cmd == 'u') { U_R(); return true; }
		if(cmd == 'L') { L(); 	return true; }
		if(cmd == 'l') { L_R(); return true; }
		if(cmd == 'F') { F(); 	return true; }
		if(cmd == 'f') { F_R(); return true; }
		if(cmd == 'R') { R();	return true; }
		if(cmd == 'r') { R_R();	return true; }
		if(cmd == 'B') { B(); 	return true; }
		if(cmd == 'b') { B_R();	return true; }
		if(cmd == 'D') { D(); 	return true; }
		if(cmd == 'd') { D_R();	return true; }
		return false;
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
	
	public void L() {
		char[] temp = frontPlane.getCol(0);
		
		frontPlane.setCol(0, topPlane.getCol(0));
		topPlane.setColReverse(0, rearPlane.getCol(2));
		rearPlane.setColReverse(2, bottomPlane.getCol(0));
		bottomPlane.setCol(0, temp);
	}
	
	public void L_R() {
		char[] temp = frontPlane.getCol(0);
		
		frontPlane.setCol(0,  bottomPlane.getCol(0));
		bottomPlane.setColReverse(0, rearPlane.getCol(2));
		rearPlane.setColReverse(2, topPlane.getCol(0));
		topPlane.setCol(0, temp);
	}
	
	public void F() {
		char[] temp = topPlane.getRow(2);
		
		topPlane.setRowReverse(2, leftPlane.getCol(2));
		leftPlane.setCol(2, bottomPlane.getRow(0));
		bottomPlane.setRowReverse(0, rightPlane.getCol(0));
		rightPlane.setCol(0, temp);
	}
	
	public void F_R() {
		char[] temp = topPlane.getRow(2);
		
		topPlane.setRow(2, rightPlane.getCol(0));
		rightPlane.setColReverse(0, bottomPlane.getRow(0));
		bottomPlane.setRow(0, leftPlane.getCol(2));
		leftPlane.setColReverse(2, temp);
	}
	
	public void R() {
		char[] temp = frontPlane.getCol(2);
		
		frontPlane.setCol(2, bottomPlane.getCol(2));
		bottomPlane.setColReverse(2, rearPlane.getCol(0));
		rearPlane.setColReverse(0, topPlane.getCol(2));
		topPlane.setCol(2, temp);
	}
	
	public void R_R() {
		char[] temp = frontPlane.getCol(2);
		
		frontPlane.setCol(2, topPlane.getCol(2));
		topPlane.setColReverse(2, rearPlane.getCol(0));
		rearPlane.setColReverse(0, bottomPlane.getCol(2));
		bottomPlane.setCol(2, temp);
	}
	
	public void B() {
		char[] temp = rightPlane.getCol(2);
		
		rightPlane.setColReverse(2, bottomPlane.getRow(2));
		bottomPlane.setRow(2, leftPlane.getCol(0));
		leftPlane.setColReverse(0, topPlane.getRow(0));
		topPlane.setRow(0,  temp);
	}
	
	public void B_R() {
		char[] temp = rightPlane.getCol(2);
		
		rightPlane.setCol(2, topPlane.getRow(0));
		topPlane.setRowReverse(0, leftPlane.getCol(0));
		leftPlane.setCol(0, bottomPlane.getRow(2));
		bottomPlane.setRowReverse(2, temp);
	}
	
	public void D() {
		char[] temp = frontPlane.getRow(2);
		
		frontPlane.setRow(2, leftPlane.getRow(2));
		leftPlane.setRow(2, rearPlane.getRow(2));
		rearPlane.setRow(2, rightPlane.getRow(2));
		rightPlane.setRow(2, temp);
	}
	
	public void D_R() {
		char[] temp = frontPlane.getRow(2);
		
		frontPlane.setRow(2, rightPlane.getRow(2));
		rightPlane.setRow(2, rearPlane.getRow(2));
		rearPlane.setRow(2,  leftPlane.getRow(2));
		leftPlane.setRow(2, temp);
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
		
		public char[] getRow(int rowNum) {
			char[] row = new char[3];
			for(int i = 0; i < 3; i++) {
				row[i] = state[rowNum][i];
			}
			return row;
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
			for(int i = 0; i < 3; i++) {
				this.state[row][i] = toReplace[i];
			}
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
