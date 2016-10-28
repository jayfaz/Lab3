package lab3;

public class PostfixCalc {
	 
	private String[] values;
	private double output;
	private MyStack stack;
	
	public PostfixCalc(String input) {
		stack = new MyStack();
		values = input.split("\\s+");
		
		int num1;
		int num2;
		
		for(int i = 0; i < values.length; i++) {
			if(values[i].equals("+")) {
				num1 = stack.pop();
			}
		}
	}

}
