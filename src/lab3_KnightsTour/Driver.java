package lab3_KnightsTour;

public class Driver {

	public static void main(String[] args) {
		
		InfixCalc i = new InfixCalc("5+6*3*(4+5)");
		System.out.println(i.getOutput());
		
	}
}
