package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//SellerDao sellerDao = DaoFactory.createSellerDao();
		
		departmentDao.update(new Department(3, "Jardim"));
	}

}
