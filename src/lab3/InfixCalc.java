package lab3;

public class InfixCalc {
	private String[] characters;
	private String input;
	private String holder1;
	private String holder2;
	private String output;
	
	public InfixCalc(String input) {
		this.input = input;
		characters = input.split("(?!^)");
		
		for(int i = 0; i < characters.length; i++) {
			if(characters[i].equals("+") || characters[i].equals("-") || characters[i].equals("*") || characters[i].equals("/")) {
				holder1 = output + characters[i+1]+ " ";
				output = holder1;
				holder2 = output + characters[i]+ " ";
				output = holder2;
				i++;
			} else if(characters[i].equals("(")) {
				
			}
		}
	}

}