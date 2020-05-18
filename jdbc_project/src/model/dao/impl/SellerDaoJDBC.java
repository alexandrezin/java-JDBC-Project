package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller seller) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO Seller (nameSeller, emailSeller, bdateSeller, incomeSeller, depidSeller)" +
									   "VALUES (?,?,?,?,?); ");
			st.setString(1, seller.getName());
			st.setString(2, seller.getEmail());
			st.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
			st.setDouble(4, seller.getIncome());
			st.setInt(5, seller.getDepartment().getId());
			
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
	public void update(Seller seller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteId(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller getId(int id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
	    try {
			st = conn.prepareStatement("SELECT * FROM jdbc_project.Seller INNER JOIN Department ON Seller.depidSeller=Department.idDepartment WHERE idSeller = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				//Find department
				Department department = new Department();
				department.setId(rs.getInt("idDepartment"));
				department.setName(rs.getString("nameDepartment"));
				//Find Seller
				Seller seller = new Seller();
				seller.setId(rs.getInt("idSeller"));
				seller.setName(rs.getString("nameSeller"));
				seller.setEmail(rs.getString("emailSeller"));
				seller.setBirthDate(rs.getDate("bdateSeller"));
				seller.setIncome(rs.getDouble("incomeSeller"));
				seller.setDepartment(department);
				
				return seller;
			}
		} 
	    catch (SQLException e) {
			System.out.println("Impossible to get this information, error: " + e.getMessage());
		}
	    finally {
	    	DB.closeResultSet(rs);
	    	DB.closeStatement(st);
	    }
		
		
		
		
		return null;
	}

	@Override
	public List<Seller> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
