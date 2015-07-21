package ba.bitcamp.lectures.generics;

import java.util.HashSet;

import ba.bitcamp.lectures.generics.string.StringQueueComposition;
import ba.bitcamp.lectures.generics.string.StringQueueInheritance;

public class QueueTest {
	public static void main(String[] args) {
		// string queue implemented using composition - keep queue values internally in LinkedList
		System.out.println("StringQueueComposition");
		StringQueueComposition strComp = new StringQueueComposition();
		strComp.enqueue("A");
		strComp.enqueue("B");
		strComp.enqueue("C");
		// strComp.add() - not possible - no such method in class
		System.out.println(strComp.toString()); // toString() inherited from Object
		for (int i = 0; i < 3; i++) {
			System.out.println(strComp.dequeue());
			System.out.println(strComp.size());
		}

		// string queue implemented using inheritance
		System.out.println("\nStringQueueInheritance");
		StringQueueInheritance strInh = new StringQueueInheritance();
		strInh.enqueue("A");
		strInh.enqueue("B");
		strInh.enqueue("C");
		System.out.println(strInh.toString()); // inherited from LinkedList
		for (int i = 0; i < 3; i++) {
			System.out.println(strInh.dequeue());
			System.out.println(strInh.size());
		}
		// String queue but using generic queue
		System.out.println("\nQueueComposition<String>");
		QueueComposition<String> queueCompStr = new QueueComposition<String>();
		queueCompStr.enqueue("A");
		queueCompStr.enqueue("B");
		queueCompStr.enqueue("C");
		for (int i = 0; i < 3; i++) {
			System.out.println(queueCompStr.dequeue());
		}
		// we can use same class for queue of integers
		System.out.println("\nQueueComposition used for Integer");
		QueueComposition<Integer> queueInt = new QueueComposition<Integer>();
		queueInt.enqueue(1);
		queueInt.enqueue(20);
		queueInt.enqueue(3);
		
		//
		System.out.println("\nQueueInheritance used for Integer");
		QueueInheritance<Integer> ints = new QueueInheritance<Integer>();
		ints.enqueue(1);
		ints.enqueue(20);
		ints.enqueue(3);
		
		System.out.println(ints.dequeue());
		
		// test enqueueAll
		System.out.println("Size before enqueuAll:" + ints.size());
		HashSet<Integer> intSet = new HashSet<Integer>();
		intSet.add(100);
		intSet.add(11);
		System.out.println("Enque all for: " + intSet);
		ints.enqueueAll(intSet);
		System.out.println("Size after enqueuAll:" + ints.size());
		System.out.println("After enqueue: " + ints);
		
		// test dequeue to
		System.out.println("\nTest dequeueToCollection");
		intSet.clear();
		System.out.println("Before dequeueing: " + ints);
		ints.dequeueToCollection(intSet);
		System.out.println("After dequeueing: " + ints);
		System.out.println("Target: " + intSet);
		
		// test Number queue
		System.out.println("\nUsing base class Number as type");
		QueueInheritance<Number> nums = new QueueInheritance<Number>();
		nums.enqueue(1);
		nums.enqueue(10L);
		nums.enqueue(20.12);
		System.out.println("Mixed number queue: " + nums);
		// cannot pass Collection<Integer> where expected Collection<Number>
		// nums.enqueueAll(numSet);
		// unless use "? extends" to note collection of any subclass
		nums.enqueueAllAnySubtype(intSet);
		System.out.println("Target after dequeue: " + intSet);
		
		// in oposite direcion - try to dequeueTo queue of integers to collection of Numbers
		System.out.println("\nDequeue to collection of base type");
		HashSet<Number> numSet = new HashSet<Number>();
		// cannot pass Collection<Number> where expected collection<Integer>
		// ints.dequeueToCollection(numSet);
		// unless use "? super" to note collection of any supertype
		ints.add(1);
		ints.dequeueToCollectionAnySuperType(numSet);
		System.out.println("Target after dequeue: " + numSet);
		
		// test NumberQueue - cannot instantiate for anything that is not number
		// new NumberQueue<String>();
		NumberQueue<Integer> intNums = new NumberQueue<Integer>();
		intNums.enqueue(12);
	}
}
