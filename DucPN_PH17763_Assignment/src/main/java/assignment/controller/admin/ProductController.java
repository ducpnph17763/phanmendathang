package assignment.controller.admin;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import assignment.UploadFile;
import assignment.beans.AccountModel;
import assignment.beans.ProductModel;
import assignment.entities.Products;
import assignment.repository.CategoryRepository;
import assignment.repository.ProductRepository;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
	@Autowired
	ProductRepository proRepo;

	@Autowired
	CategoryRepository cateRepo;

	@Autowired
	UploadFile upLoadUl;

	@GetMapping("create")
	public String create(@ModelAttribute("product") ProductModel pro, Model mod) {
		mod.addAttribute("cate", this.cateRepo.findAll());
		return "admin/product/create";
	}

	@PostMapping("store")
	public String store(@ModelAttribute("product") ProductModel mod, @RequestParam("photo") MultipartFile uploadFile) {
		Products pro = new Products();
		pro.setName(mod.getName());
		pro.setPrice(Integer.parseInt(mod.getPrice()));
		pro.setCreatedDate(LocalDate.now());
		pro.setImage(uploadFile.getOriginalFilename());
		this.upLoadUl.handleUploadFile(uploadFile);
		pro.setAvailable(Integer.parseInt(mod.getAvailable()));
		pro.setCategories(this.cateRepo.findById(mod.getCategory_id()).get());
		this.proRepo.save(pro);
		return "redirect:index";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Products pro, @ModelAttribute("product") ProductModel product, Model mod) {
		mod.addAttribute("cate", this.cateRepo.findAll());
		mod.addAttribute("pro", pro);
		return "admin/product/edit";
	}

	@PostMapping("update/{id}")
	public String update(ProductModel product, @PathVariable("id") Products pro,
			@RequestParam("photo") MultipartFile uploadFile) {
		pro.setName(product.getName());
		pro.setPrice(Integer.parseInt(product.getPrice()));
		pro.setCreatedDate(LocalDate.now());
		pro.setImage(product.getImage());
		pro.setAvailable(Integer.parseInt(product.getAvailable()));
		pro.setCategories(this.cateRepo.findById(6).get());
		this.proRepo.save(pro);
		System.out.println("vao");
		return "redirect:/admin/product/index";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Products pro) {
		this.proRepo.delete(pro);
		return "redirect:/admin/product/index";
	}

	@GetMapping("index")
	public String index(Model mod, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Products> p = this.proRepo.findAll(pageable);
		mod.addAttribute("pro", p);
		return "admin/product/index";
	}
}
