package net.zeminvaders.lang.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.zeminvaders.lang.Interpreter;
import net.zeminvaders.lang.SourcePosition;
import net.zeminvaders.lang.runtime.Parameter;
import net.zeminvaders.lang.runtime.UserFunction;
import net.zeminvaders.lang.runtime.ZemObject;

/*
 * Anonymous Function Declaration
 * 
 * @author <a href="mailto:js.shujing@gmail.com">Jing Shu</a>
 */
public class LambdaNode extends FunctionNode {
	// The environment(bindings of variable and value) of the anonymous function
	private Map<String, ZemObject> env;

	public LambdaNode(SourcePosition pos, List<Node> parameters, Node body) {
		super(pos, parameters, body);
		this.env = new HashMap<String, ZemObject>();
	}

	public void setEnv(Map<String, ZemObject> env){
		this.env = env;
	}

	@Override
	public ZemObject eval(Interpreter interpreter) {
		List<Parameter> params = new ArrayList<Parameter>(parameters.size());
		for (Node node : parameters) {
			// TODO clean up getting parameters
			String parameterName;
			ZemObject parameterValue;
			if (node instanceof VariableNode) {
				parameterName = ((VariableNode) node).getName();
				parameterValue = null;
			} else if (node instanceof AssignNode) {
				parameterName = ((VariableNode) ((AssignNode) node).getLeft()).getName();
				parameterValue = ((AssignNode) node).getRight().eval(interpreter);
			} else {
				// This error should not occur
				throw new RuntimeException("Invalid function");
			}
			Parameter param = new Parameter(parameterName, parameterValue);
			params.add(param);
		}

		// copy the current environment (bindings of variable and value)
		env = new HashMap<String, ZemObject>(interpreter.getSymbolTable());	

		return new UserFunction(params, body);
	}

}
