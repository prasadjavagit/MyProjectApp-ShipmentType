package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nit.model.UomType;
import in.nit.service.IUomTypeService;

@Controller
@RequestMapping("/uom")
public class UomTypeController {
	@Autowired
	private IUomTypeService service;

	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("uomType", new UomType());
		return "UomTypeRegister";
	}

	@RequestMapping("/save")
	public String saveUom(@ModelAttribute UomType uomType, Model model) {
		Integer id = service.saveUomType(uomType);
		String message = "Uom Type '" + id + "' saved";
		model.addAttribute("msg", message);
		return "UomTypeRegister";
	}

	@RequestMapping("/all")
	public String getAllUomTypes(Model model) {
		List<UomType> list = service.getAllUomTypes();
		model.addAttribute("li", list);
		return "UomTypeData";
	}
}
