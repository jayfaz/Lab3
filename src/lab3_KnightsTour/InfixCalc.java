package lab3_KnightsTour;
import java.util.ArrayList;

public class InfixCalc {
	private String[] characters;
	private String input;
	private ArrayList<String> postFixForm;
	private String output;
	private String storage;
	
	public InfixCalc(String input) {
		this.input = input;
		postFixForm = new ArrayList<String>();
		input = input.replaceAll(".(?!$)", "$0 "); // puts in spaces to separate values
		characters = input.split("\\s+");
		
		for(int i = 0; i < characters.length; i++) {
			if(characters[i].equals("+") || characters[i].equals("-") || 
					characters[i].equals("*") || characters[i].equals("/")) {
				if(!(characters[i+1].equals("(") || characters[i+1].equals(")"))) {
					postFixForm.add(characters[i+1]);
					postFixForm.add(characters[i]);
					i++;
				} else {
					storage = characters[i];
				}
			} else if(characters[i].equals("(")) {
				// do nothing
			} else if(characters[i].equals(")")) {
				if(storage != null) {
					postFixForm.add(storage);
				}
			} else {
				postFixForm.add(characters[i]);
			}
		}
		setOutput();
	}
	
	private void setOutput() {
		for(int i = 0; i < postFixForm.size(); i++) {
			output += postFixForm.get(i) + " ";
		}
		output = output.substring(4,output.length()); // removes "null"
	}
	
	public String getOutput() {
		return output;
	}
}