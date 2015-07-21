package ba.bitcamp.lectures.generics.string;

import java.util.Collection;
import java.util.LinkedList;

import ba.bitcamp.lectures.generics.QueueComposition;
import ba.bitcamp.lectures.generics.QueueInheritance;

/**
 * Queue implementation that can be used only for strings.
 * It uses {@link LinkedList} field to hold queue values - hence *Composition.
 * It does not implement {@link Collection} interface.
 * 
 * @author emir
 * @see StringQueueInheritance
 * @see QueueComposition
 * @see QueueInheritance
 */
public class StringQueueComposition {
	private LinkedList<String> values;
	
	public StringQueueComposition() {
		values = new LinkedList<String>();
	}
	
	public int size() {
		return values.size();
	}
	
	public void enqueue(String val) {
		values.add(0, val);
	}
	
	public String dequeue() {
		return values.remove(values.size()-1);
	}
}
