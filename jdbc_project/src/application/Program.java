package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		List<Seller> sellerList = new ArrayList<Seller>();
		sellerList = sellerDao.getAll();
		
		for (Seller x : sellerList) {
			System.out.println(x);
		}
		
		List<Department> departmentList = new ArrayList<Department>();
		departmentList = departmentDao.getAll();
		
		for (Department x : departmentList) {
			System.out.println(x);
		}
	
	}

}
