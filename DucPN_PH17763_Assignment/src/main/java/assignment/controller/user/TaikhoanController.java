package assignment.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import assignment.beans.AccountModel;
import assignment.entities.Accounts;
import assignment.repository.AccountRepository;

@Controller
@RequestMapping("/user/account")
public class TaikhoanController {
	@Autowired
	private AccountRepository accountRepo;

	@GetMapping("register")
	public String register(@ModelAttribute("account") AccountModel account) {
		return "user/account/register";
	}

	@PostMapping("dangki")
	public String dangki(@ModelAttribute("account") AccountModel mod) {
		Accounts acc = new Accounts();
		acc.setFullname(mod.getFullname());
		acc.setAdmin(0);
		acc.setEmail(mod.getEmail());
		acc.setPassword(mod.getPassword());
		acc.setPhoto(mod.getPhoto());
		acc.setUsername(mod.getUsername());
		this.accountRepo.save(acc);
		return "redirect:/trangchu";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") Accounts acc, @ModelAttribute("account") AccountModel account, Model mod) {
		mod.addAttribute("account", acc);
		return "user/account/edit";
	}

	@PostMapping("update/{id}")
	public String update(AccountModel account, @PathVariable("id") Accounts accnew) {
		System.out.println("vao");
		accnew.setFullname(account.getFullname());
		accnew.setAdmin(account.getAdmin());
		accnew.setEmail(account.getEmail());
		accnew.setPassword(account.getPassword());
		accnew.setPhoto(account.getPhoto());
		accnew.setUsername(account.getUsername());
		this.accountRepo.save(accnew);
		return "redirect:account/index";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") Accounts acco) {
		this.accountRepo.delete(acco);
		return "redirect:account/index";
	}

	@GetMapping("index")
	public String index(Model mod, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Accounts> p = this.accountRepo.findAll(pageable);
		mod.addAttribute("acc", p);
		return "user/account/index";
	}
}
