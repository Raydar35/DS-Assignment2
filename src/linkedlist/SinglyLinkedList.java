/**
 * @author: Fahmida Hamid
 * @date: 10/02/2024
 * @version: 1.0
 *
*/

package linkedlist;

import student.Student;

class Node<T extends Comparable<T>>{

	T data;
	Node next;

	Node(T data){
		this.data = data;
		next = null;

	}

}

public class SinglyLinkedList<T extends Comparable<T>> {

	Node<T> head;
	int n; // number of items

	public SinglyLinkedList() {
		head = null;
		n = 0;
	}

	public void insert(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null)
			head = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}
		n++;
	}

	public boolean delete(T data) {
		Node<T> current = head;
		Node<T> prev = null;

		while (current != null) {
			if (current.data.equals(data)) {
				if (prev != null)
					prev.next = current.next;
				else
					head = head.next;
				n--;
				return true;
			}
			prev = current;
			current = current.next;
		}
		return false;
	}

	// ------------------------
	// New helper methods
	// ------------------------

	// Search Student by ID
	public T searchBySID(String sID) {
		Node<T> current = head;
		while (current != null) {
			Student s = (Student) current.data;
			if (s.getSID().equals(sID))
				return current.data;
			current = current.next;
		}
		return null;
	}

	// Check if Student exists
	public boolean containsSID(String sID) {
		return searchBySID(sID) != null;
	}

	public void printList() {
		Node<T> current = head;
		if (current == null) {
			System.out.println("---");
			return;
		}
		while (current != null) {
			Student s = (Student) current.data;
			System.out.print(s.getName());
			if (current.next != null) System.out.print(" -> ");
			current = current.next;
		}
		System.out.println();
	}

	// Check if linked list is empty
	public boolean isEmpty() {
		return head == null;
	}

}
