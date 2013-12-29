package net.zeminvaders.lang.ast;

import java.util.List;

import net.zeminvaders.lang.Interpreter;
import net.zeminvaders.lang.SourcePosition;
import net.zeminvaders.lang.TypeMismatchException;
import net.zeminvaders.lang.runtime.ZemBoolean;
import net.zeminvaders.lang.runtime.ZemObject;

public class SwitchNode extends Node  {

    private Node var;
    private Node switchBlock;
    
	public SwitchNode(SourcePosition position , Node var , Node switchBlock) {
		super(position);
		this.var = var;
		this.switchBlock = switchBlock;
	}

    protected void checkTypes(ZemObject left, ZemObject right) {
        if (!left.getClass().equals(right.getClass())) {
            throw new TypeMismatchException(getPosition(), left.getClass(), right.getClass());
        }
    }

	public Node getVar() {
		return var;
	}

	public void setVar(Node var) {
		this.var = var;
	}

	public Node getSwitchBlock() {
		return switchBlock;
	}

	public void setSwitchBlock(Node switchBlock) {
		this.switchBlock = switchBlock;
	}

	@Override
	public ZemObject eval(Interpreter interpreter) {
		List<Node> statements = ((BlockNode)switchBlock).getStatements();
		ZemObject defaultValue = null;
		for (Node statement : statements) {
			if(statement instanceof CaseNode){
				//System.out.println("ohoho" + ((CaseNode)statement).getVar());
				ZemObject varSwitch = getVar().eval(interpreter);
				ZemObject valueCase = (((CaseNode)statement).getVar()).eval(interpreter);
				
				ZemBoolean bool = ZemBoolean.valueOf(varSwitch.equals(valueCase));
				if(bool.booleanValue()){
					return (((CaseNode)statement).getCaseBlock()).eval(interpreter);
				}
			}
			else if(statement instanceof DefaultSwitchNode){
				defaultValue = (((DefaultSwitchNode)statement).getDefaultBlock()).eval(interpreter);
			}
		}
		if(defaultValue != null){
			return defaultValue;
		}
		else{
			return null;
		}
	}

    @Override
    public String toString() {
    	
    	return "switch";
    }
	
	

}
