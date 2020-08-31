package com.elisa.procat.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.elisa.procat.models.Category;
import com.elisa.procat.repos.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository catRepo;

	public CategoryService(CategoryRepository catRepo) {
		this.catRepo = catRepo;
	}
	public List<Category> allCategories() {
        return catRepo.findAll();
    }
public Category saveCategory(Category cat) {
    return catRepo.save(cat);
}
public Category findCategory(Long id) {
    Optional<Category> temp = catRepo.findById(id);
    if(temp.isPresent()) {
        return temp.get();
    } else {
        return null;
    }
}
public void deleteCategory(Long id) {
   catRepo.deleteById(id);
   }

}
