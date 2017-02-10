package com.example.view;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaffView {
	@RequestMapping("/StaffManager")
	public String adminhome(Model model){
		model.addAttribute("date",new Date());
		return "StaffManager";
	}
	
	@RequestMapping("/PhieuThuePhong")
	public String thuephong(){
		return "PhieuThuePhong";
	}
}
