package ba.bitcamp.lectures.generics.string;

import java.util.LinkedList;

import ba.bitcamp.lectures.generics.QueueComposition;
import ba.bitcamp.lectures.generics.QueueInheritance;

/**
 * Queue implementation that can be used only for strings.
 * It extends {@link LinkedList} and adds queue methods - hence *Inheritance.
 * 
 * @author emir
 * @see StringQueueComposition
 * @see QueueComposition
 * @see QueueInheritance
 *
 */
@SuppressWarnings("serial")
public class StringQueueInheritance extends LinkedList<String> {

	public void enqueue(String val) {
		add(0, val);
	}
	
	public String dequeue() {
		return remove(size()-1);
	}
}
