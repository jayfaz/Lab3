package lab3_KnightsTour;

public class Driver {

	public static void main(String[] args) {
		
		InfixCalc i = new InfixCalc("2+(4-6)/2+3");
		System.out.println("Infix Expression is: " + i.getOutput());
		PostfixCalc p = new PostfixCalc(i.getOutput());
		System.out.println("Final Answer is: " + p.getOutput());
	}
}
