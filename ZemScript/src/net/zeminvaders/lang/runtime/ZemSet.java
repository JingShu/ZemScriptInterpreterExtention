package net.zeminvaders.lang.runtime;

import java.util.Iterator;
import java.util.Set;

/**
 * Set data type.
 *
 * @author <a href="mailto:js.shujing@gmail.com">Jing Shu</a>
 * @author <a href="mailto:mrdiallo.abdoul@gmail.com">Abdoul Diallo</a>
 */
public class ZemSet extends ZemObject implements Iterable<ZemObject> {
	private Set<ZemObject> elements;
	
	public ZemSet(Set<ZemObject> elements){
		this.elements = elements;
	}
	
	public int size(){
		return elements.size();
	}
	
	public ZemObject get(ZemObject index){
		int ind = -1;
		if(! (index instanceof ZemNumber)){
			return null;
		}
		ind = ((ZemNumber)index).intValue();
		if(ind < 0 || ind >= elements.size()){
			return null;
		}
		Iterator<ZemObject> iter = elements.iterator();
		while(ind > 0){
			if(iter.hasNext()){
				iter.next();
			}
			ind--;
		}
		return iter.next();
	}
	
	public void add(ZemObject element){
		elements.add(element);
	}
	
	public void remove(ZemObject element){
		elements.remove(element);
	}
	
	public boolean contains(ZemObject element){
		return elements.contains(element);
	}
	
	public boolean isEmpty(){
		return elements.isEmpty();
	}
	
	public void clear(){
		elements.clear();
	}

	@Override
	public int compareTo(ZemObject arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterator<ZemObject> iterator() {
		return elements.iterator();
	}

	@Override
	public String toString(){
		return elements.toString();
	}
}
