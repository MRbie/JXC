package com.bie.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author 别先生
 * 1:action提取的公共的方法
 * 2:适合将页面加到WEB-INF下面调用的工具方法
 */
@Controller
@RequestMapping("/base")
public class BaseAction {

	@Resource
	ServletContext application;
	
	//两层目录调用的方法
	//方法参数folder通过@PathVariable指定其值可以从@RequestMapping的{folder}获取，同理file也一样
	/*@RequestMapping("/goURL/{folder}/{file}")
	public String goURLTwoLayer(@PathVariable String folder,@PathVariable String file) {
		System.out.println("goURL.folder|file===" + folder+"/"+file);
		return "forward:/WEB-INF/"+folder+"/"+file+".jsp";
	}*/
	
	
	//三层目录调用的方法
	//方法参数folder通过@PathVariable指定其值可以从@RequestMapping的{folder}获取，同理file也一样
	/*@RequestMapping("/goURL/{folder1}/{folder1}/{file}")
	public String goURLThreeLayer(@PathVariable String folder1,@PathVariable String folder2,@PathVariable String file) {
		System.out.println("goURL.folder1|file===" + folder1+ "/" + folder2 + "/" + file);
		return "forward:/WEB-INF/" + folder1 + "/" + folder2 + "/" + file + ".jsp";
	}*/
	
	
	//三层目录调用的方法
	//方法参数folder通过@PathVariable指定其值可以从@RequestMapping的{folder}获取，同理file也一样
	@RequestMapping("/goURL/{folder1}/{folder1}/{file}")
	public ModelAndView goURLThreeLayer(@PathVariable String folder1,@PathVariable String folder2,@PathVariable String file) {
		ModelAndView mv = new ModelAndView();
		//System.out.println("goURL.folder1|file===" + folder1+ "/" + folder2 + "/" + file);
		mv.setViewName(folder1 + "/" + folder2 + "/" + file);
		return mv;
	}
	
	//方法参数folder通过@PathVariable指定其值可以从@RequestMapping的{folder}获取，同理file也一样
	@RequestMapping("/goURL/{folder}/{file}")
	public ModelAndView goURLTwoLayer(@PathVariable String folder,@PathVariable String file) {
		ModelAndView mv = new ModelAndView();
		//System.out.println("goURL.folder|file = " + folder+"/"+file);
		mv.setViewName(folder+"/"+file);
		return mv;
	}
	
	
}
