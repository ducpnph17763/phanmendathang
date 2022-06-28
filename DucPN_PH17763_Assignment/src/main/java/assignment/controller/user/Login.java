package assignment.controller.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import assignment.beans.AccountModel;
import assignment.entities.Accounts;
import assignment.repository.AccountRepository;

@Controller
public class Login {
	@Autowired
	private HttpSession sess;

	@Autowired
	private AccountRepository accRepo;
 
	@GetMapping("login")
	public String login(@ModelAttribute("acc") AccountModel account) {
		return "login";
	}

	@PostMapping("dangnhap")
	public String dangnhap(@ModelAttribute("acc") AccountModel account) {
		List<Accounts> list = this.accRepo.findAll();
		for (Accounts acc : list) {
			if (acc.getEmail().equals(account.getEmail()) && acc.getPassword().equals(account.getPassword())) {
				sess.setAttribute("acc", acc);
				return "redirect:trangchu";
			}
		}
		return "login";
	}

	@GetMapping("logout")
	public String logout() {
		sess.removeAttribute("acc");
		return "redirect:trangchu";
	}

	@GetMapping("capnhat")
	public String capnhat(@ModelAttribute("acc") AccountModel account, Model mod) {
		Accounts acc = (Accounts) this.sess.getAttribute("acc");
		mod.addAttribute("taikhoan", acc);
		return "user/account/edit";
	}

	@PostMapping("luu")
	public String luu(@ModelAttribute("acc") AccountModel account) {
		Accounts acc = (Accounts) this.sess.getAttribute("acc");
		acc.setFullname(account.getFullname());
		acc.setEmail(account.getEmail());
		acc.setPhoto(account.getPhoto());
		acc.setUsername(account.getUsername());
		this.accRepo.save(acc);
		return "redirect:trangchu";
	}

	@GetMapping("doimatkhau")
	public String doimatkhau(@ModelAttribute("acc") AccountModel account, Model mod) {
		return "user/account/doimk";
	}

	@PostMapping("doi")
	public String luumk(@ModelAttribute("acc") AccountModel account) {
		Accounts acc = (Accounts) this.sess.getAttribute("acc");
		acc.setFullname(account.getFullname());
		acc.setEmail(account.getEmail());
		acc.setPhoto(account.getPhoto());
		acc.setUsername(account.getUsername());
		this.accRepo.save(acc);
		return "redirect:trangchu";
	}
}
