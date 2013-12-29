package net.zeminvaders.lang.ast;

import net.zeminvaders.lang.Interpreter;
import net.zeminvaders.lang.SourcePosition;
import net.zeminvaders.lang.runtime.ZemObject;

public class DefaultSwitchNode extends Node{

	private Node defaultBlock;
	
	public DefaultSwitchNode(SourcePosition position, Node defaultBlock) {
		super(position);
		this.defaultBlock = defaultBlock;
	}

	public Node getDefaultBlock() {
		return defaultBlock;
	}

	public void setDefaultBlock(Node defaultBlock) {
		this.defaultBlock = defaultBlock;
	}

	@Override
	public ZemObject eval(Interpreter interpreter) {
		return this.defaultBlock.eval(interpreter);
	}

}
