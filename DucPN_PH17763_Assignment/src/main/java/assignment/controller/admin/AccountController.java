package assignment.controller.admin;

import java.nio.file.Path;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import assignment.UploadFile;
import assignment.beans.AccountModel;
import assignment.entities.Accounts;
import assignment.repository.AccountRepository;

@Controller
@RequestMapping("/admin/account")
public class AccountController {
	@Autowired
	private AccountRepository accountRepo;

	@Autowired
	UploadFile upLoadUl;

	@GetMapping("create")
	public String create(@ModelAttribute("account") AccountModel account) {
		return "admin/account/create";
	}

	@PostMapping("store")
	public String store(@Valid @ModelAttribute("account") AccountModel mod, BindingResult result) {
		if (result.hasErrors() == true) {
			System.out.println("Lỗi");
		} else {
			Accounts acc = new Accounts();
			acc.setPhoto(mod.getPhoto());
			acc.setFullname(mod.getFullname());
			acc.setAdmin(mod.getAdmin());
			acc.setEmail(mod.getEmail());
			acc.setPassword(mod.getPassword());
			acc.setUsername(mod.getUsername());
			this.accountRepo.save(acc);
			return "redirect:admin/account/index";
		}
		return "admin/account/create";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Accounts acc, @ModelAttribute("account") AccountModel account, Model mod) {
		mod.addAttribute("account", acc);
		return "admin/account/edit";
	}

	@PostMapping("update/{id}")
	public String update(AccountModel account, @PathVariable("id") Accounts accnew) {
		System.out.println("vao");
		accnew.setFullname(account.getFullname());
		accnew.setAdmin(account.getAdmin());
		accnew.setEmail(account.getEmail());
		accnew.setPassword(account.getPassword());
//		accnew.setPhoto(account.getPhoto());
		accnew.setUsername(account.getUsername());
		this.accountRepo.save(accnew);
		return "redirect:/admin/account/index";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Accounts acco) {
		this.accountRepo.delete(acco);
		return "redirect:/admin/account/index";
	}

	@GetMapping("index")
	public String index(Model mod, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Accounts> a = this.accountRepo.findAll(pageable);
		mod.addAttribute("acc", a);
		return "admin/account/index";
	}

}
