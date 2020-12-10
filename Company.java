package Project;
import java.util.Scanner;
class Company {

	public static void main(String[] args) {
		int choice;
		Scanner input = new Scanner(System.in);
		Employees C = new Employees();
		do {
			//program menu
			System.out.println("*************************");
			System.out.println("Please choose: ");
			System.out.println("1-Add employee");
			System.out.println("2-Print employee");
			System.out.println("3-Print all employees");
			System.out.println("4-calculate the bonus");
			System.out.println("5-Find highest salary");
			System.out.println("6-Exit");
			System.out.println("*************************");
			System.out.print("Enter your choice:");
			choice = input.nextInt();
		
		if(choice==1) {
			System.out.println("Enter ID, Name, Years, Salary, Department:");
				
			int id= input.nextInt();
            String name= input.next();
            int years= input.nextInt(); 
            double salary=input.nextDouble();
            String department= input.next();

                if(C.addEmployee(id,name,years,salary,department)==1) {
                    System.out.println("Added");
                }
                else if (C.addEmployee(id,name,years,salary,department)==-1) {
                    System.out.println("Cannot add! ID is already used!");
                }else if (C.addEmployee(id,name,years,salary,department)==-2) {
                	System.out.println("Cannot add! array is full!");
                }
                }
		else if(choice==2) {
			System.out.print("Enter the ID of the employee you want to print:");
				C.printEmployee(input.nextInt());
				}
		else if(choice==3) {
			 	C.printAll();
			    }
		else if(choice==4) {
			System.out.println("Enter the ID of the employee:");
			int index = input.nextInt();
			if(C.findEmploye(index)==-1) {
				 System.out.println("“ID is not correct!");
				}
			else {
				C.printEmployee(index);
				System.out.print("Bonus: ");
				System.out.println(C.calculateBonus(index));
				}
		}
		else if(choice==5) {
			System.out.print("Enter the department:");
			String Department = input.next();
			if(C.findHighestSalary(Department)==-1) {
				System.out.println("The department is not found!");
			}
			else {
				System.out.print("The employee with highest salary in the "+Department+" department is: ");
				C.printEmployee(C.findHighestSalary(Department));
				}
		}
		else if(choice<1||choice>6) {
			System.out.println("incorrect input please try again!");}
	}
		// 6 will end the program loop  
		while(!(choice==6));
		System.out.print("Thanks goodbye!");
	}

}
