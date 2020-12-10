package Project;

public class Employees {
	private int [] ids;
	private String [] names;
	private int [] years;
	private double [] salaries;
	private String [] departments;
	private int nEmployees;
	
//employee Class
public Employees(){
	ids = new int [50];
	names= new String [50];
	years= new int [50];
	salaries= new double [50];
	departments= new String [50];
}
public int getNEmpolyees(){
	//returns the number of employee
	return nEmployees;
}
public int addEmployee(int id, String name,int years,double salary,String department) {
	int b=0;
	//checks if the list is full
       if(nEmployees<50) {
           for(int i=0;i<nEmployees;i++) {
        	   //checks if id already been used
               if( id != ids[i]) {
                   b++;
               }
               }
           			if(b == nEmployees) {
           				//saves the information of new employee
               this.ids[nEmployees]=id;
               this.names[nEmployees]=name;
               this.years[nEmployees]=years;
               this.salaries[nEmployees]=salary;
               this.departments[nEmployees]=department;
               nEmployees++;
               b=1;
           }
           else {
        	 //if id is used
               b= -1;
           }
       }
       else {
    	   //if the list is full
           b= -2;
       }
       return b;
   }

public int findEmploye(int id) {
	//takes id of employee and gets their index in array 
		int employeePosition=-1;
	 for(int i=0;i<nEmployees;i++) {
         if( id == ids[i]) {
        	 employeePosition=i;
         }}
         return employeePosition;
}
public int findHighestSalary(String department) {
	double hSalary=0;
	int id=-1; // -1 is false by default 
	 for(int i = 0; i<nEmployees; i++){
		 //finds the wanted department
	        if(departments[i].equals(department) == true) {
	        	//if the next salary is higher it will save
	            if(salaries[i]>hSalary) {
	                hSalary=salaries[i];
	                id=ids[i];
	            }
	            }
	            } 
	 return id;
}
public void printEmployee(int integer) {
	//uses the fined employee method to get the index of wanted employee
	if(findEmploye(integer)<nEmployees&&findEmploye(integer)>=0) {
	System.out.println("ID:"+ids[findEmploye(integer)]+". Name:"+names[findEmploye(integer)]+". Years"+years[findEmploye(integer)]+". Salary"+salaries[findEmploye(integer)]+". Department:"+departments[findEmploye(integer)]);
	}
	//if id does not exist 
	else if(findEmploye(integer)==-1)
		System.out.println("Error cannot print");
}
public void printAll() {
	//if no employee has been added
	if (nEmployees==0) {
		System.out.println("The list is empty!");
	}
	else {
		//a loop to print employees  
		for(int i=0 ;i<nEmployees;i++) {
			System.out.println("ID:"+ids[i]+". Name:"+names[i]+". Years"+years[i]+". Salary"+salaries[i]+". Department:"+departments[i]);
		}
	}
}
public double calculateBonus(int index) {
	// bonus increases by years
	int nYears;
	double salary,bonus=0;
	nYears= years[findEmploye(index)];
	salary= salaries[findEmploye(index)];
	if(nYears<5) {
	 bonus = salary*2;
	}
	else if(nYears>=5&&nYears<=10) {
		bonus = salary*3;
	}
	else if(nYears>10) {
		bonus = salary*4;
	}
	return bonus;
}
}
