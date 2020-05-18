package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import db.DB;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
	
	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Department department) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO Department (nameDepartment) "+
									   "VALUES (?)");
			st.setString(1, department.getName());
			st.executeUpdate();
		} 
		catch (SQLException e) {
			System.out.println("Impossible to insert new data, error: " + e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Department department) {
		PreparedStatement st =  null;
		
		try {
			st = conn.prepareStatement("UPDATE Department SET nameDepartment = ? WHERE idDepartment = ?");
			st.setString(1, department.getName());
			st.setInt(2, department.getId());
			st.executeUpdate();
		} 
		catch (SQLException e) {
			System.out.println("Impossible to update information, error: " + e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteId(int id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("DELETE FROM Department WHERE idDepartment = ?");
			st.setInt(1, id);
			st.executeUpdate();
			
		} 
		catch (SQLException e) {
			System.out.println("Impossible to delete row, error: " + e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Department getId(int id) {
		ResultSet rs = null;
		PreparedStatement st = null; 
		
		try {
			st = conn.prepareStatement("SELECT * FROM Department WHERE idDepartment = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				 Department department = new Department();
				 department.setId(rs.getInt("idDepartment"));
				 department.setName(rs.getString("nameDepartment"));
				 return department;
			}
		} 
		catch (SQLException e) {
			System.out.println("Impossible to get this information, error: " + e.getMessage());
		}
		finally{
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

		return null;
	}

	@Override
	public List<Department> getAll() {
		List<Department> departmentList = new ArrayList<Department>();
		ResultSet rs = null;
		Statement st = null; 
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Department");
			
			while (rs.next()) {
				departmentList.add(new Department(rs.getInt("idDepartment"), rs.getString("nameDepartment")));
			}
			
			return departmentList;
		} 
		catch (SQLException e) {
			System.out.println("Impossible to get all entries, error: " + e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		
		return null;
	}

}
