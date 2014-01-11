package net.zeminvaders.lang.ast;

import net.zeminvaders.lang.Interpreter;
import net.zeminvaders.lang.SourcePosition;
import net.zeminvaders.lang.runtime.ZemObject;

/**
 * Node that represents the fonction call/cc
 * 
 * @author <a href="mailto:js.shujing@gmail.com">Jing Shu</a>
 * @author <a href="mailto:mrdiallo.abdoul@gmail.com">Abdoul Diallo</a>
 */
public class Call_CCNode extends Node {
	private BlockNode continuation;

	public Call_CCNode(SourcePosition position, BlockNode continuation) {
		super(position);
		this.continuation = continuation;
	}

	@Override
	public ZemObject eval(Interpreter interpreter) {
		return continuation.eval(interpreter);
	}

}
