package com.huongxinhdep;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewControl {

@RequestMapping("/")
public String index(Model model)
{
	model.addAttribute("datetime",new Date());
	model.addAttribute("username","Tran Thi Quoc Huong");
	model.addAttribute("mode","production");
	return "index";
}
}
