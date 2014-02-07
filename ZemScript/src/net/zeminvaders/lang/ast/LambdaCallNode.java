package net.zeminvaders.lang.ast;

import java.util.ArrayList;
import java.util.List;

import net.zeminvaders.lang.Interpreter;
import net.zeminvaders.lang.SourcePosition;
import net.zeminvaders.lang.runtime.UserFunction;
import net.zeminvaders.lang.runtime.ZemObject;

public class LambdaCallNode extends Node {
	final static public List<Node> NO_ARGUMENTS = new ArrayList<Node>(0);

    private LambdaNode lambda;
    private List<Node> arguments;

	public LambdaCallNode(SourcePosition pos, LambdaNode lambda, List<Node> arguments) {
		super(pos);
		this.lambda = lambda;
		this.arguments = arguments;
	}

	@Override
    public ZemObject eval(Interpreter interpreter) {
		Interpreter localInterpreter = new Interpreter();
		localInterpreter.setSymbolTable(lambda.getEnv());
		
        // Evaluate the arguments
        List<ZemObject> args = new ArrayList<ZemObject>(arguments.size());
        for (Node node : arguments) {
            args.add(node.eval(localInterpreter));
        }
        ZemObject res = localInterpreter.callFunction((UserFunction)lambda.eval(localInterpreter), args, getPosition());
        System.out.println(res);
        return res;
    }
}
