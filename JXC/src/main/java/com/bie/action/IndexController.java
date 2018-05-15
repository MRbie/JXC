package com.bie.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value={"/","/index"})
	public ModelAndView index(){
		ModelAndView mov=new ModelAndView("main/index");
		
		return mov;
	}
}
