package cn.etspringmvc.lesson03.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * springmvc��Model��ض����Ǵ����������صĶ���
 * @ModelAttribute ������ ��������
 * Model(ModelMap|Map)�������ݵ���ͼ(request,setAttribute)
 * ModelMap�������ݵ���ͼ
 * ModelAndView�����ݵ���ͼ(ModelMap���ڴ�������View����������ת)
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
