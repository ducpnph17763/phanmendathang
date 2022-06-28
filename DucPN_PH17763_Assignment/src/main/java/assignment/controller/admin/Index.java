package assignment.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import assignment.beans.AccountModel;
import assignment.entities.Accounts;
import assignment.entities.Categories;
import assignment.entities.Products;
import assignment.repository.AccountRepository;
import assignment.repository.CategoryRepository;
import assignment.repository.ProductRepository;

@Controller
public class Index {
	@Autowired
	ProductRepository proRepo;

	@Autowired
	CategoryRepository cateRepo;

	@Autowired
	AccountRepository accRepo;
	
	@GetMapping("trangchu")
	public String index(Model mod, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Products> p = this.proRepo.findAll(pageable);
		Page<Categories> c = this.cateRepo.findAll(pageable);
		mod.addAttribute("dsPro", p).addAttribute("dsCate", c).addAttribute("title", "Ban Nhieu Nhat");
		return "trangchu";
	}

	@GetMapping("trangchu/{id}")
	public String locTheoCate(@PathVariable("id") Integer id, Model mod,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "6") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Products> p = this.proRepo.findBycategory_idEquals(id, pageable);
		Page<Categories> c = this.cateRepo.findAll(pageable);
		mod.addAttribute("dsPro", p).addAttribute("dsCate", c).addAttribute("title",
				this.cateRepo.findById(id).get().getName());
		return "trangchu";
	}

}
