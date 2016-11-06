package lab3_KnightsTour;

public class Driver {

	public static void main(String[] args) {
		/*
		 * this is the driver for the calculators
		 */
		InfixCalc i = new InfixCalc("2+(4-6)/2+3"); // put the expression you want to test in here (no spaces plz)
		System.out.println("Infix Expression is: " + i.getOutput());
		PostfixCalc p = new PostfixCalc(i.getOutput());
		System.out.println("Final Answer is: " + p.getOutput());
	
		/*
		 * this is the driver for Knight's Tour
		 */
		KnightsTour k = new KnightsTour(3);
		k.run(1,0);
	}
}
