package assignment.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import assignment.beans.CategoryModel;
import assignment.entities.Categories;
import assignment.repository.CategoryRepository;

@Controller
@RequestMapping("/admin/category")
public class CategoriesController {
	@Autowired
	private CategoryRepository cateRepo;

	@GetMapping("create")
	public String create(@ModelAttribute("category") CategoryModel cate) {
		return "admin/category/create";
	}

	@PostMapping("store")
	public String store(CategoryModel mod) {
		Categories cate = new Categories();
		cate.setName(mod.getName());
		this.cateRepo.save(cate);
		return "redirect:index";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Categories cate, @ModelAttribute("category") CategoryModel category,
			Model mod) {
		mod.addAttribute("cate", cate);
		return "admin/category/edit";
	}

	@PostMapping("update/{id}")
	public String update(CategoryModel category, @PathVariable("id") Categories catenew) {
		catenew.setName(category.getName());
		this.cateRepo.save(catenew);
		return "redirect:/admin/category/index";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Categories cate) {
		this.cateRepo.delete(cate);
		return "redirect:/admin/category/index";
	}

	@GetMapping("index")
	public String index(Model mod, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Categories> c = this.cateRepo.findAll(pageable);
		mod.addAttribute("cate", c);
		return "admin/category/index";
	}
}
