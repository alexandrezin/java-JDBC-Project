package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Department department = departmentDao.getId(1);
		System.out.println(department);
		
		Seller seller = sellerDao.getId(1);
		System.out.println(seller);
	}

}
