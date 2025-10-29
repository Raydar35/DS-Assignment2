package hashing;
import student.Student;

public class NaiveHashMap implements OurHashMap<Integer, Student>{

	int tableSize;
	Student[] hashTable;
	
    NaiveHashMap(){
		
		this(10); // default table size = 10, if the user doesn't set the value
	}
	
    NaiveHashMap(int m){
		
		this.tableSize = m;
		this.hashTable = new Student[tableSize];
		for(int i = 0; i < m; i++)
			hashTable[i] = null;
	}
	
	@Override
	public boolean insert(Integer key, Student data) {
		
		int index = this.hashFunction(key);
		
		if(hashTable[index] == null) {
			hashTable[index] = data;
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public Student lookup(Integer key) {
		
		int index = this.hashFunction(key);
		
		return hashTable[index];
		
	}

	@Override
	public boolean delete(Integer key) {
		
		int index = this.hashFunction(key);
		if(hashTable[index]!= null)
		{
			hashTable[index] = null;
			return true; // an indication that the item is found and deleted successfully
		}
		else
			return false; // item was not found, so no delete operation took place
	}
	
	
	
	@Override
	public Integer getHashCode(Student s) {
		
		return HashCodeGenerator.generateHashCode(s.getName());
	}
	
	@Override
	public int hashFunction(Integer key) {
		
		return key % tableSize;
	}

	@Override
	public void printHashMap() {
		
		
		System.out.println("*** Printing the current HashTable ***");
		for(int i = 0; i < tableSize; i++)
		{
			if(hashTable[i] == null)
				System.out.println(i + " >> --- ");
			else
				System.out.println(i + " >> " + hashTable[i].getName());
			
		}
		System.out.println("*** End of HashTable ***");	
		
	}

	
	

}
