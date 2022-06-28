//package assignment.controller.user;
//
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import assignment.entities.Accounts;
//import assignment.entities.Orders;
//import assignment.repository.OrderRepository;
//
//@Controller
//public class LichSuDonHang {
//	@Autowired
//	private OrderRepository ordRepo;
//
//	@Autowired
//	private HttpSession sess;
//
//	@GetMapping("lichsu")
//	public String lichsu(Model mod) {
//		Accounts acc = (Accounts) this.sess.getAttribute("acc");
////		List<Orders> list = this.ordRepo.findLS(acc.getUsername(), 1);
////		mod.addAttribute("lichsu", list);
//		return "user/lichsu";
//	}
//}
