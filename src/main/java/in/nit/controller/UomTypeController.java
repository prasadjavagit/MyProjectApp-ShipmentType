package in.nit.controller;

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
		model.addAttribute("uomType",new UomType());
		return "UomTypeRegister";
	}
	@RequestMapping("/save")
	public String saveUom(@ModelAttribute UomType uomType, Model model) {
		Integer id = service.saveUomType(uomType);
		String message="Uom Type '"+id+"' saved";
		model.addAttribute("msg",message);
		return "UomTypeRegister";
	}
}
