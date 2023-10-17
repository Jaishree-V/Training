package com.mindgate.repository;

import java.util.Set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import com.mindgate.domain.Employee;

public class EmployeeRepository implements EmployeeRepositoryInterface {
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String url ="jdbc:oracle:thin:@localhost:1521/xe";
	private String user = "shree";
	private String password ="neenu";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	private String insertEmployeeSQL = "insert into employee_details values(?,?,?)";
	

	@Override
	public boolean addNewEmployee(Employee employee) {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(insertEmployeeSQL);
			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setDouble(3, employee.getSalary());
			
			int rowCount = preparedStatement.executeUpdate();
			if(rowCount >0)
				return true;
			else
				return false;
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to Load Driver");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("Connection Failed!!");
			System.out.println(e.getMessage());
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee updateEmployeeSalary(int employeeId, double newSalary) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
