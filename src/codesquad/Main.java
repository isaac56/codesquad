package codesquad;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int cnt = sc.nextInt() % word.length();
		char cmd = sc.next().charAt(0);
		
		if (cmd == 'L' || cmd == 'l') {
			int startIdx = (word.length() + cnt) % word.length(); 
			System.out.println(word.substring(startIdx) + word.substring(0, startIdx));
		}
		else if (cmd == 'R' || cmd == 'r') {
			int startIdx = (word.length() - cnt) % word.length();
			System.out.println(word.substring(startIdx) + word.substring(0, startIdx));
		}
		sc.close();
	}

}
