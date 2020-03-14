package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseOrderService;

@Controller
@RequestMapping("/po")
public class PurchaseController {
	@Autowired
	private IPurchaseOrderService service;
	
	@RequestMapping("/register")
	public String getRegPage(Model model) {
		PurchaseOrder po=new PurchaseOrder();
		po.setStatus("OPEN");
		model.addAttribute("purchaseOrder", po);
		return "PurchaseOrderRegister";
	}
}
