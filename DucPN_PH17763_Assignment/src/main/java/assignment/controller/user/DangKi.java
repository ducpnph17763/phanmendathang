package assignment.controller.user;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import assignment.beans.AccountModel;
import assignment.beans.MailModel;
import assignment.entities.Accounts;
import assignment.repository.AccountRepository;

@Controller
public class DangKi {
	@Autowired
	private AccountRepository accRepo;

	@Autowired
	JavaMailSender sender;

	@GetMapping("register")
	public String regis(Model mod, @ModelAttribute("acc") AccountModel acc) {
		return "register";
	}

	@PostMapping("dangki")
	public String dangki(@ModelAttribute("acc") AccountModel mod, @ModelAttribute("mail") MailModel mail)
			throws MessagingException {
		Accounts acc = new Accounts();
		acc.setPhoto(mod.getPhoto());
		acc.setFullname(mod.getFullname());
		acc.setAdmin(0);
		acc.setEmail(mod.getEmail());
		acc.setPassword(mod.getPassword());
		acc.setUsername(mod.getUsername());
		this.accRepo.save(acc);

		MimeMessage mess = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mess, true, "utf-8");
		helper.setFrom(mail.getFrom());
		helper.setTo(mail.getFrom());
		helper.setText(mail.getBody(), true);
		sender.send(mess);
		return "redirect:/xacnhan";
	}
}
