package net.zeminvaders.lang.runtime;

import net.zeminvaders.lang.Interpreter;
import net.zeminvaders.lang.SourcePosition;

/**
 * set_add built-in function. Adds element to set.
 *
 * @author <a href="mailto:js.shujing@gmail.com">Jing Shu</a>
 * @author <a href="mailto:mrdiallo.abdoul@gmail.com">Abdoul Diallo</a>
 */
public class SetAddFunction extends Function {
	private String[] parameters = {"set", "element"};
	
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
        set.add(interpreter.getVariable("element", pos));
        return set;
	}

}
