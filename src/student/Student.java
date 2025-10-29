/**
 * @author: Fahmida Hamid
 * @date: 10/02/2024
 * @version: 1.0
 * 
*/
package student;


public class Student implements Comparable<Student>{
		
		String sID;
		String name;
		Float gpa;
		
		public Student(String sID, String name, Float gpa){
			
			this.sID = sID;
			this.name = name;
			this.gpa = gpa;
			
		}

		@Override
		public int compareTo(Student o) {
			
			if(this.sID == o.sID)
				return 0;
			else
				return -1;
		}
		
		public String getName() {return this.name;}
		public String getSID() {return this.sID;}
		public Float getgpa() {return this.gpa;}
}



