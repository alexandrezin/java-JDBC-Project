package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.openConnection());
	}

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.openConnection());
	}
}
