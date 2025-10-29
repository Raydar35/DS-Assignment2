package hashing;
/**
 * @author Fahmida Hamid
 * @param <U> a generic type, used for keys
 * @param <T> a generic type, used for values
 */

public interface OurHashMap<U extends Comparable, T extends Comparable>{
	/**
	 * insert method intends to compute the index using the hash function and key 
	 * so it can insert the value into the hash table
	 * @param key
	 * @param data
	 * @return boolean (true: insert operation successful, 
	 *                   false: insert operation unsuccessful due to collision)
	 */
    public boolean insert(U key, T data);
    
    /**
	 * lookup method intends to find the value that corresponds to the key and return it
	 * in case of failure, it returns null
	 * @param key
	 * @return value
	 */
    
    public T lookup(U key);
    
    /**
	 * delete method intends to compute the index using the hash function and key 
	 * so it can delete the value from the hash table
	 * @param key
	 * @return boolean (true: delete operation successful, 
	 *                   false: delete operation unsuccessful)
	 */
    
    public boolean delete(U key);
    
    /**
   	 * getHashCode method intends to compute the hash key.  
   	 * it may use the GenerateHashCode class, if needed
   	 * @param value (entire data, with an assumption that key can be generated from it)
   	 * @return key  
   	 *              
   	 */
    public U getHashCode(T value);
    
    /**
   	 * hashFunction is where we implement the hash function.  
   	 * @param key 
   	 * @return integer, an index fitting the hash table  
   	 *              
   	 */
    
    public int hashFunction(U key);
    
    /**
     * prints the whole hash table 
     */
    public void printHashMap();
		
}
