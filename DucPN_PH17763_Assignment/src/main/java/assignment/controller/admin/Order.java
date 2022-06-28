package assignment.controller.admin;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import assignment.beans.OrderDetailModel;
import assignment.beans.OrderModel;
import assignment.entities.Accounts;
import assignment.entities.OrderDetails;
import assignment.entities.Orders;
import assignment.entities.Products;
import assignment.repository.OrderDetailRepository;
import assignment.repository.OrderRepository;
import assignment.repository.ProductRepository;

@Controller
public class Order {
	@Autowired
	private OrderRepository odRepo;

	@Autowired
	private OrderDetailRepository oddRepo;
	@Autowired
	private ProductRepository proRepo;
	@Autowired
	private HttpSession sess;

	@GetMapping("trangchu/giohang/create/{id}")
	public String add(@PathVariable("id") Products pro, Model mod, @ModelAttribute("giohang") OrderModel order) {
		int a = 0;
		List<Orders> list = this.odRepo.findAll();
		for (Orders or : list) {
			if (or.getStatus() == 0) {
				a++;
			}
		}
		if (a == 0) {
			System.out.println("1");
			Orders od = new Orders();
			Accounts acc = (Accounts) sess.getAttribute("acc");
			od.setAccount(acc);
			od.setAddress("a");
			od.setCreateDate(LocalDate.now());
			this.odRepo.save(od);

			OrderDetails odd = new OrderDetails();
			odd.setProduct(pro);
			odd.setQuantity(1);
			odd.setPrice(pro.getPrice() * odd.getQuantity());
			odd.setOrder(this.odRepo.findBystatusEquals(0));
			this.oddRepo.save(odd);
			mod.addAttribute("sp", odd);
			return "redirect:/giohang";
		} else {
			int i = 0;
			Orders ord = this.odRepo.findBystatusEquals(0);
			List<OrderDetails> ordd = ord.getOrderDetails();
			for (OrderDetails sp : ordd) {
				if (pro.getId() == sp.getProduct().getId()) {
					System.out.println("2");
					sp.setQuantity(sp.getQuantity() + 1);
					sp.setPrice(pro.getPrice() * sp.getQuantity());
					this.oddRepo.save(sp);
					i++;
					System.out.println("i=" + i);
					return "redirect:/giohang";
				}
				System.out.println("Vao" + sp.getId() + " " + pro.getId());
			}
			System.out.println("i=" + i);
			if (i != 1) {
				System.out.println("3");
				OrderDetails odd = new OrderDetails();
				odd.setProduct(pro);
				odd.setQuantity(odd.getQuantity() + 1);
				odd.setPrice(pro.getPrice() * odd.getQuantity());
				odd.setOrder(this.odRepo.findBystatusEquals(0));
				this.oddRepo.save(odd);
				return "redirect:/giohang";
			}
		}
		return "redirect:/giohang";
	}

	@GetMapping("giohang")
	public String giohang(Model mod) {
		if (this.odRepo.findBystatusEquals(0) == null) {
			mod.addAttribute("od", null);
			return "trangchu";
		} else {
			List<OrderDetails> list = this.odRepo.findBystatusEquals(0).getOrderDetails();
			List<Products> listp = this.proRepo.findAll();
			mod.addAttribute("odd", list).addAttribute("od", this.odRepo.findBystatusEquals(0)).addAttribute("pro",
					listp);
			return "gioHang";
		}

	}

	@GetMapping("giohang/mua")
	public String mua(Model mod) {
		Orders ord = this.odRepo.findBystatusEquals(0);
		ord.setStatus(1);
		this.odRepo.save(ord);
		return "redirect:/trangchu";
	}

	@GetMapping("giohang/xoa/{id}")
	public String xoa(@PathVariable("id") OrderDetails odd) {
		this.oddRepo.delete(odd);
		return "redirect:/giohang";
	}

	@GetMapping("giohang/edit/{id}")
	public String edit(@PathVariable("id") OrderDetails odd, Model mod) {
		mod.addAttribute("ord", odd);
		return "suagio";
	}

	@PostMapping("giohang/sua/{id}")
	public String sua(@PathVariable("id") OrderDetails odd, @ModelAttribute("ord") OrderDetailModel ord) {
		odd.setQuantity(ord.getQuantity());
		this.oddRepo.save(odd);
		return "redirect:/giohang";
	}

}
