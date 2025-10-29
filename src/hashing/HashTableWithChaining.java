package hashing;

import student.Student;
import linkedlist.SinglyLinkedList;

public class HashTableWithChaining implements OurHashMap<Integer, Student> {

    private SinglyLinkedList<Student>[] table;
    private int tableSize;
    private int totalEntries;
    private int totalCollisions;

    @SuppressWarnings("unchecked")
    public HashTableWithChaining(int size) {
        this.tableSize = size;
        table = new SinglyLinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new SinglyLinkedList<>();
        }
        totalEntries = 0;
        totalCollisions = 0;
    }

    @Override
    public boolean insert(Integer key, Student value) {
        int index = hashFunction(key);

        // Avoid duplicate sID
        if (table[index].containsSID(value.getSID())) {
            return false;
        }

        if (!table[index].isEmpty()) totalCollisions++; // collision if chain already has entries

        table[index].insert(value);
        totalEntries++;
        return true;
    }

    @Override
    public Student lookup(Integer key) {
        int index = hashFunction(key);
        for (int i = 0; i < tableSize; i++) {
            Student s = table[index].searchBySID("" + key.hashCode());
            if (s != null) return s;
        }
        return null;
    }

    @Override
    public boolean delete(Integer key) {
        int index = hashFunction(key);
        Student s = table[index].searchBySID("" + key.hashCode());
        if (s != null) {
            table[index].delete(s);
            totalEntries--;
            return true;
        }
        return false;
    }

    @Override
    public Integer getHashCode(Student value) {
        return value.getSID().hashCode();
    }

    @Override
    public int hashFunction(Integer key) {
        return key % tableSize;
    }

    @Override
    public void printHashMap() {
        System.out.println("*** Printing the current HashTable with Chaining ***");
        for (int i = 0; i < tableSize; i++) {
            System.out.print(i + " >> ");
            table[i].printList();
        }
        System.out.println("*** End of HashTable ***");
        System.out.println("Total entries: " + totalEntries + ", Total collisions: " + totalCollisions);
    }

    public int countCollision() {
        return totalCollisions;
    }
}
