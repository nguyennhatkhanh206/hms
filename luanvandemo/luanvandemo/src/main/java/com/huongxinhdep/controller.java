package com.huongxinhdep;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value="/form")
public class controller {

	@RequestMapping(value="/them")
	public String them(Model model)
	{
		model.addAttribute("sinhVien", new SinhVien());
		return "them";
	}
	
	@RequestMapping(value="/xulithem")
	public String xulithem(@ModelAttribute SinhVien sv)
	{
		System.out.print("Sinh vien ten "+sv.getName());
		return "them";
	}
 
}
