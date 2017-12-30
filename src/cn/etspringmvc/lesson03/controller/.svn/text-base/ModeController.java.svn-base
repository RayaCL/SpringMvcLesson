package cn.etspringmvc.lesson03.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * springmvc中Model相关对象是处理和数据相关的对象
 * @ModelAttribute 重命名 参数数据
 * Model(ModelMap|Map)传递数据到视图(request,setAttribute)
 * ModelMap传递数据到视图
 * ModelAndView绑定数据到视图(ModelMap用于传递数据View对象用于跳转)
 * @author Administrator
 *
 */
@Controller
public class ModeController {
	@RequestMapping(value="/case",method=RequestMethod.GET)
	public String case1(Map map){
		map.put("hell", "model");
		return "lesson03/res.jsp";
	}
	
	@RequestMapping(value="/case2",method=RequestMethod.GET)
	public ModelAndView case2(){
		ModelAndView model=new ModelAndView();
		model.setViewName("lesson03/res.jsp");
		model.addObject("sex","boy");
		return model;
	}
}
