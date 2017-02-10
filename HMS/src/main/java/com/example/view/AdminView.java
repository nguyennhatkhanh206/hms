package com.example.view;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminView {
	
		@RequestMapping("/")
		public String home(Model model){
			model.addAttribute("date",new Date());
			return "index";
		}
		
		@RequestMapping("/AdminManager")
		public String adminhome(Model model){
			model.addAttribute("date",new Date());
			return "AdminManager";
		}
		

		@RequestMapping("/NhanVien")
		public String admintable(Model model){
			model.addAttribute("date",new Date());
			return "NhanVien";
		}
		

		@RequestMapping("/Prices")
		public String prices(){
			
			return "Prices";
		}
		
		@RequestMapping("/Phong")
		public String room(){
			
			return "Phong";
		}
		
		

		@RequestMapping("/LoaiPhong")
		public String table(){
			
			return "LoaiPhong";
		}

		@RequestMapping("/k")
		public String test(){
			
			return "k";
		}
	

}
