package in.nit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseOrderService;
import in.nit.service.IShipmentTypeService;
import in.nit.util.CommonUtil;

@Controller
@RequestMapping("/po")
public class PurchaseController {
	@Autowired
	private IPurchaseOrderService service;

	@Autowired
	private IShipmentTypeService shipmentService;

	private void commonUi(Model model) {
		List<Object[]> shipmentList = shipmentService.getShipmentIdAndCode();
		Map<Integer, String> shipmentMap = CommonUtil.convert(shipmentList);
		model.addAttribute("shipmentMap", shipmentMap);
	}

	@RequestMapping("/register")
	public String getRegPage(Model model) {
		commonUi(model);
		PurchaseOrder po = new PurchaseOrder();
		po.setStatus("OPEN");
		model.addAttribute("purchaseOrder", po);
		return "PurchaseOrderRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder, Model model) {
		Integer id = service.savePurchaseOrder(purchaseOrder);
		String msg = "PurchaseOrder " + id + " saved";
		model.addAttribute("msg", msg);
		commonUi(model);
		PurchaseOrder po=new PurchaseOrder();
		po.setStatus("OPEN");
		model.addAttribute("purchaseOrder", po);
		return "PurchaseOrderRegister";
	}

	@RequestMapping("/all")
	public String getAppPurchaseOrders(Model model) {
		List<PurchaseOrder> list = service.getAllPurchaseOrders();
		model.addAttribute("list", list);
		return "PurchaseOrderData";
	}
}
