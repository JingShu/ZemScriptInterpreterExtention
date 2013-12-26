package net.zeminvaders.lang.ast;

import java.util.HashSet;
import java.util.Set;

import net.zeminvaders.lang.Interpreter;
import net.zeminvaders.lang.SourcePosition;
import net.zeminvaders.lang.runtime.ZemObject;
import net.zeminvaders.lang.runtime.ZemSet;


/**
 * A set. Eg. [|1, 2, 3|]
 *
 * @author <a href="mailto:js.shujing@gmail.com">Jing Shu</a>
 * @author <a href="mailto:mrdiallo.abdoul@gmail.com">Abdoul Diallo</a>
 */
public class SetNode extends Node {
	private Set<Node> elements;

	public SetNode(SourcePosition pos, Set<Node> elements) {
		super(pos);
		this.elements = elements;
	}

	@Override
	public ZemObject eval(Interpreter interpreter) {
		Set<ZemObject> items = new HashSet<ZemObject>(elements.size());
        for (Node node : elements) {
            items.add(node.eval(interpreter));
        }
        return new ZemSet(items);
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[|");
        for (Node node : elements) {
            sb.append(node);
            sb.append(' ');
        }
        sb.append("|]");
        return sb.toString();
    }
}
