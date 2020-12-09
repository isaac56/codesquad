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
			if(cmds.equals("Q")) {
				System.out.println("Bye~");
				break;
			}
			else {
				cube.executeCmds(cmds);
			}
		}
		sc.close();
	}

}
