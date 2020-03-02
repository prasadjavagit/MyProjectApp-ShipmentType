package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("uomType", new UomType());
		return "UomTypeRegister";
	}

	@RequestMapping("/all")
	public String getAllUomTypes(Model model) {
		List<UomType> list = service.getAllUomTypes();
		model.addAttribute("li", list);
		return "UomTypeData";
	}

	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("umid") Integer id, Model model) {
		service.deletUomType(id);
		String message = "Uom '" + id + "'Deleted";
		model.addAttribute("message", message);
		List<UomType> list = service.getAllUomTypes();
		model.addAttribute("li", list);
		return "UomTypeData";
	}

	@RequestMapping("/edit")
	public String getOneUomType(@RequestParam("umid") Integer id, Model model) {
		UomType ut = service.getOneUomType(id);
		model.addAttribute("uomType", ut);
		return "UomTypeEdit";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUomType(@ModelAttribute UomType uomType, Model model) {
		service.updateUomType(uomType);
		String message = "UomType '" + uomType.getUomId() + "'updated";
		model.addAttribute("message", message);
		List<UomType> list = service.getAllUomTypes();
		model.addAttribute("li", list);
		return "UomTypeData";
	}

	@RequestMapping("/view")
	public String showOneUom(@RequestParam("umid") Integer id, Model model) {
		UomType ut = service.getOneUomType(id);
		model.addAttribute("ob", ut);
		return "UomTypeView";
	}
}
