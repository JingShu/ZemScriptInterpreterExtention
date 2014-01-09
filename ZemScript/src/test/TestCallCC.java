package test;

import java.io.File;
import java.io.IOException;

import net.zeminvaders.lang.Interpreter;

/**
 * @author <a href="mailto:js.shujing@gmail.com">Jing Shu</a>
 * @author <a href="mailto:mrdiallo.abdoul@gmail.com">Abdoul Diallo</a>
 */
public class TestCallCC {
	public static void main(String[] args) throws IOException{
		Interpreter interpreter = new Interpreter();
        interpreter.eval(new File("sampleCallCC.zem"));
	}
}
