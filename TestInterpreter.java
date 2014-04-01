package design.pattern;

import java.util.ArrayList;
import java.util.List;

class Context{
	private String input;
	private String output;
	
	public Context(String input){
		this.input = input;
		this.output = "";
	}
	public String getInput(){
		return input;
	}
	public void setInput(String input){
		this.input = input;
	}
	public String getOutput(){
		return output;
	}
	public void setOutput(String output){
		this.output = output;
	}
}

abstract class Expression{
	public abstract void interpert(Context context);
}

class AExpression extends Expression{
	@Override
	public void interpert(Context context) {
		System.out.println("a expression");
		String input = context.getInput();
		context.setInput(input.substring(1)); 		//input = 'b'
		context.setOutput(context.getOutput()+"1");		//output='1'
	}
}

class BExpression extends Expression{
	@Override
	public void interpert(Context context) {
		System.out.println("b expression");
		String input = context.getInput();
		context.setInput(input.substring(1));		//input=''
		context.setOutput(context.getOutput()+"2"); 	//output='12'
	}
}
public class TestInterpreter {
	public static void main(String[] args){
		String string = "ab";
		Context context = new Context(string);
		List<Expression> list = new ArrayList<Expression>();
		list.add(new AExpression());
		list.add(new BExpression());
		for(Expression e : list){
			 e.interpert(context);		//AExpression and BExpression shared the context
		}
		System.out.println(context.getOutput());
	}
}
