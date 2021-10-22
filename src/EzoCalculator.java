import java.util.Scanner;

public class EzoCalculator {
	
	public static void main(String[] args) {
		System.out.println("Enter your calcul here, type H for help, type Q to exit");
		Scanner sc = new Scanner(System.in);
		boolean stay = true;
	    while(stay){
	        String input = sc.next().toLowerCase();
	        switch (input) {
	        	case "q":
	        		stay = false;
	        		break;
	        	case "h" :
	        		System.out.println("Mayday mayday");
	        		break;
        		default :
        			System.out.println("Your input is : " + input);
	        }
	    }
	}
	
}
