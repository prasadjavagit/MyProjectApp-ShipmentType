package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;

	/**
	 * 1 This method is used to display ShipmentType Register page on URL:/register,
	 * method:GET
	 */
	/*
	 * Method format: public String <anyMethodName>(){ return "pageName";
	 */
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveShipment(@ModelAttribute ShipmentType shipmentType, Model model) {
		Integer id = service.saveShipmentType(shipmentType);
		String message = "Shipment Type " + id + " saved";
		model.addAttribute("msg", message);
		model.addAttribute("shipmentType", new ShipmentType());
		return "ShipmentTypeRegister";
	}

	@RequestMapping("/all")
	public String getAllShipmentTypes(Model model) {
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	@RequestMapping("/delete")
	public String deleteShipment(@RequestParam("sid") Integer id, Model model) {
		service.deleteShipmentType(id);
		String message = "Shipment " + id + " Deleted";
		model.addAttribute("msg", message);
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	@RequestMapping("/edit")
	public String getOneShipmentType(@RequestParam("sid") Integer id, Model model) {
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("shipmentType", st);
		return "ShipmentTypeEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType, Model model) {
		service.updateShipmentType(shipmentType);
		String message = "ShipmentType " + shipmentType.getShipId() + " updated";
		model.addAttribute("msg", message);
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list", list);
		return "ShipmentTypeData";
	}

	@RequestMapping("/view")
	public String showOnShipment(@RequestParam("sid") Integer id, Model model) {
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("ob", st);
		return "ShipmentTypeView";
	}

	/*
	 * @RequestMapping("/pdf") public ModelAndView showPdf() { ModelAndView m = new
	 * ModelAndView(); m.setView(new ShipmentTypePdfView()); List<ShipmentType> list
	 * = service.getAllShipmentTypes(); // send data to pdf file m.addObject("list",
	 * list); return m; }
	 */
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value = "id", required = false) Integer id) {
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypePdfView());
		if (id == null) {
			List<ShipmentType> list = service.getAllShipmentTypes();
			m.addObject("list", list);
		} else {
			ShipmentType st = service.getOneShipmentType(id);
			m.addObject("list", Arrays.asList(st));
		}
		return m;
	}

	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		ModelAndView m = new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		// fetching data from DB
		List<ShipmentType> list = service.getAllShipmentTypes();
		m.addObject("list", list);
		return m;
	}
}
