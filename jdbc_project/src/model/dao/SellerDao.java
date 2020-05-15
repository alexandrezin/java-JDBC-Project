package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {
	
	void insert(Seller Seller);
	void update(Seller Seller);
	void deleteId(int id);
	Seller getId (int id);
	List<Seller> getAll();
}
