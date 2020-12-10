package codesquad;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		RubiksCube cube;
		System.out.println("Welcome to Rubik's Cube!");
		while(true) {
			System.out.print("Do you want a random cube? (Y / N): ");
			String input = sc.nextLine();
			if(input.toUpperCase().equals("Y")) {
				cube = new RubiksCube(100);
				break;
			}
			else if (input.toUpperCase().equals("N")) {
				cube = new RubiksCube();
				break;
			}
		}
		System.out.println(cube);
		
		while(true) {
			System.out.print("Cube> ");
			if(cube.executeCmds(sc.nextLine()) == false)
				break;
		}
		sc.close();
	}
}
