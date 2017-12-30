package cn.etspringmvc.lesson03.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import cn.etspringmvc.lesson01.holle.User;
import cn.etspringmvc.lesson03.entity.UserInfo;
/**
 * springmvc中Model相关对象是处理和数据相关的对象
 * @ModelAttribute 重命名 参数数据
 * Model(ModelMap|Map)传递数据到视图(request,setAttribute)
 * ModelMap传递数据到视图
 * ModelAndView绑定数据到视图(ModelMap用于传递数据View对象用于跳转)
 * @author Administrator
 *
 */
@SessionAttributes("user")
@Controller
public class SessionController {
	
	@ModelAttribute("user")
	public User getUser(){
		User user=new User();
		return user;
	}
	/**
	 * 请求转发 forward 不需要任何处理 
	 * 请求重定向 redirect:使用SesionAttribute方式 用于在重定向中传值 
	 * 将值存储在session中用完记得清除
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/s1",method=RequestMethod.GET)
	public String case1(@ModelAttribute("user") User user){
		
		return "redirect:/s2";
	}
	
	@RequestMapping(value="/s2",method=RequestMethod.GET)
	public String case2(String id,Map map,HttpServletResponse response,SessionStatus status) throws IOException{
		User user=(User)map.get("user");
		response.getWriter().println(user.getId());
		status.setComplete();
		return null;
	}
}
