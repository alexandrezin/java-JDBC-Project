package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
	
	void insert(Department department);
	void update(Department department);
	void deleteId(int id);
	Department getId (int id);
	List<Department> getAll();
}
