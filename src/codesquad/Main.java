package codesquad;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Cube cube = new Cube();
		System.out.println(cube);
		
		while(true) {
			System.out.print("CUBE> ");
			String cmds = sc.nextLine();
			if(cube.executeCmds(cmds) == false) {
				break;
			};
		}
		
		sc.close();
		return;
	}

}
