package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller Seller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller Seller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteId(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller getId(int id) {
		PreparedStatement ps;
		ResultSet rs;
		
	    try {
			ps = conn.prepareStatement("SELECT * FROM jdbc_project.Seller INNER JOIN Department ON Seller.depidSeller=Department.idDepartment WHERE idSeller = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return null;
	}

	@Override
	public List<Seller> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
