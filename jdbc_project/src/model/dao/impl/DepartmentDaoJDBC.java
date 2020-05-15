package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteId(int id) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
