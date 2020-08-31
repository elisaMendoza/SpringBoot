package com.elisa.procat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elisa.procat.models.Product;
import com.elisa.procat.repos.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository proRepo;

	public ProductService(ProductRepository proRepo) {
		this.proRepo = proRepo;
	}
	public List<Product> allProducts() {
        return proRepo.findAll();
    }
public Product saveProduct(Product p) {
    return proRepo.save(p);
}
public Product findProduct(Long id) {
    Optional<Product> temp = proRepo.findById(id);
    if(temp.isPresent()) {
        return temp.get();
    } else {
        return null;
    }
}
public void deleteProduct(Long id) {
   proRepo.deleteById(id);
   }
}
