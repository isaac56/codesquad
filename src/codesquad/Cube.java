package codesquad;

public class Cube {
	private char[][] current = {{'R','R','W'},{'G','C','W'},{'G','B','B'}};
	
	public Cube () {
	}
	
	public void executeCmds(String cmds) {
		cmds = filterCmd(cmds);
		
		System.out.println("");
		for(char cmd : cmds.toCharArray()) {
			if(executeCmd(cmd)) {
				System.out.println(restoreCmd(cmd));
				System.out.println(this);
			};
		}
	}
	
	private String restoreCmd(char cmd) {
		switch(cmd) {
		case 'u':
			return "U'";
		case 'r':
			return "R'";
		case 'l':
			return "L'";
		case 'b':
			return "B'";
		default:
			return String.valueOf(cmd);
		}
	}
	
	private String filterCmd(String cmd) {
		//U',R',L',B'와 u,r,l,b를 혼동하지 않도록 filtering하기 전에 소문자 제거 
		cmd = cmd.replace("u", "");
		cmd = cmd.replace("r", "");
		cmd = cmd.replace("l", "");
		cmd = cmd.replace("b", "");
		
		//U',R',L',B'를 소문자로 변경 
		cmd = cmd.replace("U'", "u");
		cmd = cmd.replace("R'", "r");
		cmd = cmd.replace("L'", "l");
		cmd = cmd.replace("B'", "b");
		return cmd;
	}
	
	
	
	private boolean executeCmd(char cmd) {
		switch(cmd) {
		case 'U':
			shiftLeft(0,1);
			break;
		case 'u':
			shiftLeft(0,-1);
			break;
		case 'R':
			shiftUp(2,1);
			break;
		case 'r':
			shiftUp(2,-1);
			break;
		case 'L':
			shiftUp(0, -1);
			break;
		case 'l':
			shiftUp(0, 1);
			break;
		case 'B':
			shiftLeft(2, -1);
			break;
		case 'b':
			shiftLeft(2, 1);
			break;
		default:
			return false;
		}
		return true;
	}
		
	private void shiftLeft(int row, int num) {
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
	
	private void shiftUp(int col, int num) {
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
