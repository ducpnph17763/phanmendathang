package assignment.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import assignment.entities.Orders;
import assignment.repository.OrderRepository;

@Controller
public class OrderController {
	@Autowired
	OrderRepository orRepo;

	@GetMapping("admin/quanlygiohang")
	public String name(Model mod, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Orders> a = this.orRepo.findBystatusEquals(1, pageable);
		mod.addAttribute("donhang", a);
		return "admin/order/index";
	}

	@GetMapping("admin/giohang/xacnhan/{id}")
	public String xacNhan(@PathVariable("id") Orders order) {
		order.setStatus(2);
		this.orRepo.save(order);
		return "redirect:/admin/quanlygiohang";
	}
}
