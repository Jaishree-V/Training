package com.mindgate.main;

import java.util.Scanner;

import com.mindgate.domain.Employee;
import com.mindgate.service.EmployeeService;
import com.mindgate.service.EmployeeServiceInterface;

public class EmployeeJDBC {

	public static void main(String[] args) {
		EmployeeServiceInterface employeeServiceInterface =new EmployeeService();
		Employee employee;
		int employeeId;
		String name ;
		double salary;
		double newSalary;
		String option;
		Scanner scanner = new Scanner(System.in);
		
		
		do{
			System.out.println("----------------MENU--------------\n\n");
			System.out.println("1.Add Employee\n 2.Print one Employee Detail \n 3.Print All Employee Details \n 4.Update Salary of an Employee \n 5.Delete an Employee");
			
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Employee Id:");
				employeeId = scanner.nextInt();
				System.out.println("Enter Employee Name:");
				name = scanner.next();
				System.out.println("Enter Employee Salary:");
				salary = scanner.nextDouble();
				employee = new Employee(employeeId,name,salary);
				if(employeeServiceInterface.addNewEmployee(employee))
					System.out.println("Emloyee added successfully !!!");
				else
					System.out.println("Employee is not added");
				break;
			
			case 2:
				System.out.println("Enter Employee Id:");
				employeeId = scanner.nextInt();
				System.out.println(employeeServiceInterface.getEmployeeByEmployeeId(employeeId));
				break;
				
			case 3:
				System.out.println(employeeServiceInterface.getAllEmployees() + "\n");
				
			case 4:
				System.out.println("Enter Employee Id:");
				employeeId = scanner.nextInt();
				System.out.println("Enter New Salary:");
				newSalary = scanner.nextDouble();
				Employee employee2 = employeeServiceInterface.updateEmployeeSalary(employeeId, newSalary);
				if(employee2 == null)
					System.out.println("Employee not Found");
				else
					System.out.println(employee2 + "Salary updated successfully !!");
				break;
				
			case 5:
				System.out.println("Enter Employee Id:");
				employeeId = scanner.nextInt();
				if(employeeServiceInterface.deleteEmployeeByEmployeeId(employeeId))
					System.out.println("Employee Deleted Successfully !");
				else
					System.out.println("Employee not Found");
				break;
				
			default:
				System.out.println("Enter a valid option !");
				break;
				
			}
			System.out.println("Do you want to continue?");
			option = scanner.next();
			
		} while(option.equalsIgnoreCase("yes"));
		scanner.close();
	}

	}


