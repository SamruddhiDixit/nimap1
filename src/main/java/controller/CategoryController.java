package controller;




import com.example.CategoryCRUD.model.Category;
import com.example.CategoryCRUD.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	
	
	 @Autowired
	    private CategoryService categoryService;

	    // 1. GET all categories with pagination
	    @GetMapping
	    public ResponseEntity<Page<Category>> getAllCategories(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        return new ResponseEntity<>(categoryService.getAllCategories(page, size), HttpStatus.OK);
	    }

	    // 2. POST - create a new category
	    @PostMapping
	    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
	        return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.CREATED);
	    }

	    // 3. GET category by Id
	    @GetMapping("/{id}")
	    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
	        Optional<Category> category = categoryService.getCategoryById(id);
	        return category.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
	                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    // 4. PUT - update category by id
	    @PutMapping("/{id}")
	    public ResponseEntity<Category> updateCategory(
	            @PathVariable Long id, @RequestBody Category categoryDetails) {
	        return new ResponseEntity<>(categoryService.updateCategory(id, categoryDetails), HttpStatus.OK);
	    }

	    // 5. DELETE category by id
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
	        categoryService.deleteCategory(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	
}
