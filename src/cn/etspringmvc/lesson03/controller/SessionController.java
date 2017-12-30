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
 * springmvc��Model��ض����Ǵ����������صĶ���
 * @ModelAttribute ������ ��������
 * Model(ModelMap|Map)�������ݵ���ͼ(request,setAttribute)
 * ModelMap�������ݵ���ͼ
 * ModelAndView�����ݵ���ͼ(ModelMap���ڴ�������View����������ת)
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
	 * ����ת�� forward ����Ҫ�κδ��� 
	 * �����ض��� redirect:ʹ��SesionAttribute��ʽ �������ض����д�ֵ 
	 * ��ֵ�洢��session������ǵ����
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
