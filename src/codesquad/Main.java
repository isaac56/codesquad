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
		
		doCubeGame(cube, sc);
		printExitingMessage(cube);
		sc.close();
	}
	
	public static void printExitingMessage(RubiksCube cube) {
		if (cube.isSuccessCube()) 
			System.out.println("축하합니다! 큐브 맞추기에 성공하셨습니다");
		
		System.out.println("조작갯수: " + cube.getChangeNum());
		System.out.println("이용해주셔서 감사합니다. 뚜뚜뚜.");
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
	
	public static void doCubeGame(RubiksCube cube, Scanner sc) {
		System.out.println(cube);
		
		while(true) {
			System.out.print("Cube> ");
			if(cube.executeCmds(sc.nextLine()) == false)
				return;
		}
	}
}
