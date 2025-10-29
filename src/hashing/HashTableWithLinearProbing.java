package hashing;

import student.Student;

public class HashTableWithLinearProbing implements OurHashMap<Integer, Student> {
    private Student[] table;
    private int tableSize;
    private int totalEntries;
    private int totalCollisions;

    public HashTableWithLinearProbing(int size) {
        this.tableSize = size;
        this.table = new Student[size];
        this.totalEntries = 0;
        this.totalCollisions = 0;
    }

    @Override
    public boolean insert(Integer key, Student value) {
        int index = hashFunction(key);
        int probeCount = 0;

        while (table[index] != null && probeCount < tableSize) {
            totalCollisions++;
            index = (index + 1) % tableSize;
            probeCount++;
        }

        if (probeCount == tableSize) {
            System.out.println(value.getName() + " cannot be inserted :( Table full");
            return false;
        }

        table[index] = value;
        totalEntries++;
        return true;
    }

    @Override
    public Student lookup(Integer key) {
        int index = hashFunction(key);
        int probeCount = 0;

        while (table[index] != null && probeCount < tableSize) {
            if (table[index].getSID().hashCode() == key) {
                return table[index];
            }
            index = (index + 1) % tableSize;
            probeCount++;
        }
        return null;
    }

    @Override
    public boolean delete(Integer key) {
        int index = hashFunction(key);
        int probeCount = 0;

        while (table[index] != null && probeCount < tableSize) {
            if (table[index].getSID().hashCode() == key) {
                System.out.println("Deleting " + table[index].getName() + " from index " + index);
                table[index] = null;
                totalEntries--;
                return true;
            }
            index = (index + 1) % tableSize;
            probeCount++;
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
        System.out.println("*** Printing the current HashTable ***");
        for (int i = 0; i < tableSize; i++) {
            if (table[i] != null) {
                System.out.println(i + " >> " + table[i].getName());
            } else {
                System.out.println(i + " >> ---");
            }
        }
        System.out.println("*** End of HashTable ***");
        System.out.println("Total entries: " + totalEntries + ", Total collisions: " + totalCollisions);
    }

    public int countCollision() {
        return totalCollisions;
    }
}
