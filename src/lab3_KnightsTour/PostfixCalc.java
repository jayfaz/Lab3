package lab3_KnightsTour;

public class PostfixCalc {
	 
	private String[] values;
	private MyStack stack;
	
	public PostfixCalc(String input) {
		stack = new MyStack();
		values = input.split("\\s+");
		
		Integer num1;
		Integer num2;
		Integer num3;
		
		for(int i = 0; i < values.length; i++) {
			if(values[i].equals("+")) {
				num1 = stack.pop();
				num2 = stack.pop();
				num3 = num1 + num2;
				stack.push(num3);
			} else if(values[i].equals("-")) {
				num1 = stack.pop();
				num2 = stack.pop();
				num3 = num2 - num1;
				stack.push(num3);
			} else if(values[i].equals("*")) {
				num1 = stack.pop();
				num2 = stack.pop();
				num3 = num1 * num2;
				stack.push(num3);
			} else if(values[i].equals("/")) {
				num1 = stack.pop();
				num2 = stack.pop();
				num3 = num2 / num1;
				stack.push(num3);
			} else {
				stack.push(Integer.parseInt(values[i]));
			}
		}
	}
	public int getOutput() {
		return stack.pop();
	}

}
