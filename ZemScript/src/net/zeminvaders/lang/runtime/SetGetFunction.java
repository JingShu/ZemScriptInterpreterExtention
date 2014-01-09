package net.zeminvaders.lang.runtime;

import net.zeminvaders.lang.Interpreter;
import net.zeminvaders.lang.SourcePosition;

/**
 * set_get built-in function. get the element in the index i.
 *
 * @author <a href="mailto:js.shujing@gmail.com">Jing Shu</a>
 * @author <a href="mailto:mrdiallo.abdoul@gmail.com">Abdoul Diallo</a>
 */
public class SetGetFunction extends Function {
	private String[] parameters = {"set", "index"};

	@Override
	public int getParameterCount() {
		return 2;
	}

	@Override
	public String getParameterName(int index) {
		return parameters[index];
	}

	@Override
	public ZemObject getDefaultValue(int index) {
		return null;
	}

	@Override
	public ZemObject eval(Interpreter interpreter, SourcePosition pos) {
		ZemSet set = (ZemSet) interpreter.getVariable("set", pos);
        return set.get(interpreter.getVariable("index", pos));
	}

}
