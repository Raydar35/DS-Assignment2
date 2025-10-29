package hashing;

import student.Student;

public class TestMain {

	public static void main(String[] args) {

		// Create some Student objects
		Student s1 = new Student("C1010", "CatWoman", 3.5f);
		Student s2 = new Student("N207", "Batman", 3.4f);
		Student s3 = new Student("C2009", "PowerPuff", 3.9f);
		Student s4 = new Student("S221", "Superman", 3.9f);
		Student s5 = new Student("C2010", "CatWoman", 4.0f);
		Student[] ss = {s1, s2, s3, s4, s5};

        /*
        NaiveHashMap nHM = new NaiveHashMap(7);
        for(Student s: ss) {
            boolean result = nHM.insert(HashCodeGenerator.generateHashCode(s.getName()), s);
            if(result)
                System.out.println(s.getName() + " is inserted without any trouble");
            else
                System.out.println(s.getName() + " cannot be inserted :(");
        }
        nHM.printHashMap();
        */


		// =============================
		// Choose which hash table to test
		// =============================

		// Option 1: Test Linear Probing hash table
		// Uncomment the following line if you want to test Linear Probing
		// HashTableWithLinearProbing hashTable = new HashTableWithLinearProbing(7);

		// Option 2: Test Chaining hash table
		// Uncomment the following line if you want to test Hash Table with Chaining
		HashTableWithChaining hashTable = new HashTableWithChaining(7);

		// Only one hash table should be active at a time.
		// Comment out the hash table you are not testing to avoid variable conflicts.


		// Insert students
		for (Student s : ss) {
			boolean inserted = hashTable.insert(hashTable.getHashCode(s), s);
			if (inserted)
				System.out.println(s.getName() + " is inserted without any trouble");
			else
				System.out.println(s.getName() + " cannot be inserted :(");
		}

		System.out.println();

		// Print the current hash table
		hashTable.printHashMap();
		System.out.println();

		// Lookup test cases
		String[] testIDs = {"C1010", "C2009", "S221"};
		for (String id : testIDs) {
			Student found = hashTable.lookup(id.hashCode());
			if (found != null)
				System.out.println(found.getName() + " is found and their ID is " + found.getSID());
			else
				System.out.println(id + " is not found in the system");
		}

		System.out.println();

		// Delete a student and show the effect
		System.out.println("Deleting Batman...");
		hashTable.delete("N207".hashCode());
		hashTable.printHashMap();

		System.out.println();

		// Show total collisions so far
		System.out.println("Total collisions so far: " + hashTable.countCollision());
	}
}
