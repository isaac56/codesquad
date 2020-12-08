package codesquad;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int cnt = sc.nextInt() % word.length();
		char cmd = sc.next().charAt(0);
		
		if(cnt < 0)
		{
			cnt = -cnt;
			if(cmd == 'L' || cmd == 'l')
				cmd = 'R';
			else if (cmd == 'R' || cmd == 'r')
				cmd = 'L';
		}
		
		if (cmd == 'L' || cmd == 'l') {
			System.out.println(word.substring(cnt) + word.substring(0, cnt));
		}
		else if (cmd == 'R' || cmd == 'r') {
			System.out.println(word.substring(word.length() - cnt) + word.substring(0, word.length() - cnt));
		}
	}

}
