package net.zeminvaders.lang.ast;

import java.util.ArrayList;
import java.util.List;

import net.zeminvaders.lang.Interpreter;
import net.zeminvaders.lang.Parser;
import net.zeminvaders.lang.SourcePosition;
import net.zeminvaders.lang.runtime.ZemNumber;
import net.zeminvaders.lang.runtime.ZemObject;

/**
 * Node that represents the keyword to call a continuation
 * 
 * @author <a href="mailto:js.shujing@gmail.com">Jing Shu</a>
 * @author <a href="mailto:mrdiallo.abdoul@gmail.com">Abdoul Diallo</a>
 */
public class CallCCNode extends FunctionCallNode {

	public CallCCNode(SourcePosition pos,
			List<Node> arguments) {
		super(pos, "callcc", arguments);
	}

	@Override
    public ZemObject eval(Interpreter interpreter) {
        if(arguments.size() != 1){
        	return null;
        }
        Node continuation = arguments.get(0);
        if(! (continuation instanceof FunctionNode)){
        	return null;
        }
        return null;
    }
}
