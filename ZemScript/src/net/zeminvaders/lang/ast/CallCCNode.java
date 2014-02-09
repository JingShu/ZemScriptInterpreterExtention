package net.zeminvaders.lang.ast;

import java.util.ArrayList;
import java.util.List;

import net.zeminvaders.lang.Interpreter;
import net.zeminvaders.lang.SourcePosition;
import net.zeminvaders.lang.runtime.Function;
import net.zeminvaders.lang.runtime.Parameter;
import net.zeminvaders.lang.runtime.UserFunction;
import net.zeminvaders.lang.runtime.ZemNumber;
import net.zeminvaders.lang.runtime.ZemObject;

/**
 * Node that represents the keyword to call a continuation
 * 
 * @author <a href="mailto:js.shujing@gmail.com">Jing Shu</a>
 * @author <a href="mailto:mrdiallo.abdoul@gmail.com">Abdoul Diallo</a>
 */
public class CallCCNode extends FunctionCallNode {

	public CallCCNode(SourcePosition pos, List<Node> arguments) {
		super(pos, "callcc", arguments);
	}

	@Override
    public ZemObject eval(Interpreter interpreter) {
        if(arguments.size() < 1){
        	return null;
        }
        Node node = arguments.get(0);
        UserFunction fun = null;
        
        if(node instanceof VariableNode){
        	fun = (UserFunction) interpreter.getSymbolTable().get(((VariableNode)node).getName());	
        }
        if(node instanceof LambdaNode){
        	fun = (UserFunction)((LambdaNode)node).eval(interpreter);
        }
        
        if(fun == null){
    		return null;
    	}
        
        if(fun.getParameterCount() != 1){
        	return null;
        }
        
        String continuationName = fun.getParameterName(0);
        
        List<ZemObject> args = new ArrayList<ZemObject>(1);
        args.add(new ZemNumber("99"));
        
        Interpreter localInterpreter = new Interpreter();
        localInterpreter.setSymbolTable(fun.getEnv());
        
        return localInterpreter.callFunction(continuationName, args, getPosition());
    }
}
