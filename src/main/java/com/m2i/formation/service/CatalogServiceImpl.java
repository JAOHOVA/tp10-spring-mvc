package com.m2i.formation.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.m2i.formation.dao.ICatalogDAO;
import com.m2i.formation.dao.entity.Product;

@Service("catalogService")
public class CatalogServiceImpl implements ICatalogService {

	@Resource(name="catalogDAO")
	ICatalogDAO catalogDAO;

	@Override
	public void addProduct(Product p) {
		catalogDAO.addProduct(p);
	}

	@Override
	public boolean removeProduct(Product p) {
		return catalogDAO.removeProduct(p);
	}

	@Override
	public void updateProduct(Product p) {
		catalogDAO.updateProduct(p);
	}

	@Override
	public Product findProductByRef(String ref) {
		return catalogDAO.findProductByRef(ref);
	}

	@Override
	public List<Product> findProductByCriteria(String criteria) {
		return catalogDAO.findProductByCriteria(criteria);
	}

	@Override
	public List<Product> findAllProducts() {
		return catalogDAO.findAllProducts();
	}

}
