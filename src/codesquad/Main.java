package codesquad;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		RubiksCube cube;
		
		System.out.println("Welcome to Rubik's Cube!");
		if(checkRandom(sc)) 
			cube = new RubiksCube(100);
		else 
			cube = new RubiksCube();
		System.out.println(cube);
		
		while(true) {
			System.out.print("Cube> ");
			if(cube.executeCmds(sc.nextLine()) == false)
				break;
		}
		
		sc.close();
	}
	
	public static Boolean checkRandom(Scanner sc) {
		while(true) {
			System.out.print("Do you want a random cube? (Y / N): ");
			String input = sc.nextLine();
			if(input.toUpperCase().equals("Y")) {
				return true;
			}
			else if (input.toUpperCase().equals("N")) {
				return false;
			}
		}
	}
}
