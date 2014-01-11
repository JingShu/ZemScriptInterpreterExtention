package net.zeminvaders.lang.ast;

import net.zeminvaders.lang.Interpreter;
import net.zeminvaders.lang.Parser;
import net.zeminvaders.lang.SourcePosition;
import net.zeminvaders.lang.runtime.ZemObject;

/**
 * Node that represents the keyword to call a continuation
 * 
 * @author <a href="mailto:js.shujing@gmail.com">Jing Shu</a>
 * @author <a href="mailto:mrdiallo.abdoul@gmail.com">Abdoul Diallo</a>
 */
public class CallCCNode extends Node {

	public CallCCNode(SourcePosition position) {
		super(position);
	}

	@Override
	public ZemObject eval(Interpreter interpreter) {
		return Parser.getCall_ccNode().eval(interpreter);
	}

}
