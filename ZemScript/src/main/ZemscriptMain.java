package main;

import java.io.File;
import java.io.IOException;

import net.zeminvaders.lang.Interpreter;

/**
 * @author <a href="mailto:js.shujing@gmail.com">Jing Shu</a>
 */
public class ZemscriptMain {
	public static void main(String[] args) throws IOException{
		if(args.length < 1)
		{
			System.out.println("You don't have enough arguments");
			return;
		}
		String scriptFile = args[0];
		Interpreter interpreter = new Interpreter();
        interpreter.eval(new File(scriptFile));
	}
}
