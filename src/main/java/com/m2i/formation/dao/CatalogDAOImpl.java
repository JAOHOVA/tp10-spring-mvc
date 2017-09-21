package com.m2i.formation.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.m2i.formation.dao.entity.Product;

@Repository("catalogDAO")
public class CatalogDAOImpl implements ICatalogDAO {

	@Resource(name = "jdbcTemplate")
	JdbcTemplate jdbcTemplate;

	public void addProduct(Product p) {
		final String INSERT_QUERY = "INSERT INTO product (REFERENCE, DESIGNATION, PRICE, AMOUNT, CREATED, UPDATED) VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(INSERT_QUERY, new Object[] { p.getReference(), p.getDesignation(), p.getPrice(),
				p.getAmount(), p.getCreated(), p.getUpdated() });
	}

	public void updateProduct(Product p) {
		final String UPDATE_QUERY = "UPDATE PRODUCT SET REFERENCE=?,DESIGNATION=?,PRICE=?,AMOUNT=?,UPDATED=? WHERE ID = ?";
		jdbcTemplate.update(UPDATE_QUERY, new Object[] { p.getReference(), p.getDesignation(), p.getPrice(),
				p.getAmount(), p.getUpdated(), p.getId() });
	}

	public boolean removeProduct(Product p) {
		final String DELETE_QUERY = "DELETE FROM PRODUCT WHERE REFERENCE = ? ";
		return jdbcTemplate.update(DELETE_QUERY, p.getReference()) == 1 ? true : false;
	}

	public Product findProductByRef(String ref) {
		final String SELECT_QUERY = "SELECT * FROM PRODUCT WHERE REFERENCE = ?";
		// return (Product) jdbcTemplate.queryForObject(SELECT_QUERY, new
		// Object[] { ref }, new ProductRowMapper());
		return jdbcTemplate.queryForObject(SELECT_QUERY, BeanPropertyRowMapper.newInstance(Product.class), ref);
	}

	public List<Product> findProductByCriteria(String criteria) {
		final String SELECT_QUERY_CRITERIA = "SELECT * FROM PRODUCT WHERE DESIGNATION LIKE %?%";
		List<Product> products = new ArrayList<Product>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_QUERY_CRITERIA);
		for (Map row : rows) {
			Product product = new Product();
			product.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			product.setReference((String) row.get("REFERENCE"));
			product.setDesignation((String) row.get("DESIGNATION"));
			product.setPrice(Double.parseDouble(String.valueOf(row.get("PRICE"))));
			product.setAmount(Integer.parseInt(String.valueOf(row.get("AMOUNT"))));
			product.setCreated((Date) row.get("CREATED"));
			product.setUpdated((Date) row.get("UPDATED"));
			products.add(product);
		}
		return products;

		// return jdbcTemplate.queryForList(SELECT_QUERY_CRITERIA,
		// Product.class, criteria);

	}

	public List<Product> findAllProducts() {
		final String SELECT_QUERY_ALL = "SELECT * FROM PRODUCT";
		List<Product> products = new ArrayList<Product>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_QUERY_ALL);
		for (Map row : rows) {
			Product product = new Product();
			product.setId(Integer.parseInt(String.valueOf(row.get("ID"))));
			product.setReference((String) row.get("REFERENCE"));
			product.setDesignation((String) row.get("DESIGNATION"));
			product.setPrice(Double.parseDouble(String.valueOf(row.get("PRICE"))));
			product.setAmount(Integer.parseInt(String.valueOf(row.get("AMOUNT"))));
			product.setCreated((Date) row.get("CREATED"));
			product.setUpdated((Date) row.get("UPDATED"));
			products.add(product);
		}
		return products;
		// return jdbcTemplate.queryForList(SELECT_QUERY_ALL, Product.class);
		// return jdbcTemplate.query(SELECT_QUERY_ALL,new Object [] {}, new
		// BeanPropertyRowMapper<Product>(Product.class));
	}

}
