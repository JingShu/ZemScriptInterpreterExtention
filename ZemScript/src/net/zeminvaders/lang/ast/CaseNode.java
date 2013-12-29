package net.zeminvaders.lang.ast;

import net.zeminvaders.lang.Interpreter;
import net.zeminvaders.lang.SourcePosition;
import net.zeminvaders.lang.runtime.ZemObject;

public class CaseNode extends Node  {

    private Node var;
    private Node caseBlock;

	public CaseNode(SourcePosition position, Node var, Node caseBlock) {
		super(position);
		this.var = var;
		this.caseBlock = caseBlock;
	}

	public Node getVar() {
		return var;
	}

	public void setVar(Node var) {
		this.var = var;
	}

	public Node getCaseBlock() {
		return caseBlock;
	}

	public void setCaseBlock(Node caseBlock) {
		this.caseBlock = caseBlock;
	}

	@Override
	public ZemObject eval(Interpreter interpreter) {
		return this.caseBlock.eval(interpreter);
	}

}
