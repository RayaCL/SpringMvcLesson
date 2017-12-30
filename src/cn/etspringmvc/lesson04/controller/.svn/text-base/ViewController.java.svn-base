package cn.etspringmvc.lesson04.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.etspringmvc.lesson04.entity.UserInfo;




/**
 * 后台验证步骤
 * 	1.javabeen添加验证注解
 * 	2.action中使用@valid表示javabean 使用Errors或者BindingResult判断是否检验失败
 * 	3.出现jar包冲突4.3.2版本
 * @author Administrator
 *
 */
@Controller
public class ViewController {
	@RequestMapping(value="/viewResover",method=RequestMethod.GET)
	public String reg(@ModelAttribute("user") @Valid UserInfo user,BindingResult error){
		
		return "lesson04/result";
	}
	@Autowired
	MessageSource ms;
	@RequestMapping(value="/nation",method=RequestMethod.GET)
	public String reg(HttpServletResponse response,OutputStream out,Locale locale) throws NoSuchMessageException, IOException{
		response.setContentType("text/html;UTF-8");
		out.write(ms.getMessage("key", null, locale).getBytes("UTF-8"));
		return null;
	}
	@RequestMapping(value="/mid",method=RequestMethod.GET)
	public String mid(){
		
		return "/lesson04/reg.jsp";
	}
	@RequestMapping(value="/myreg",method=RequestMethod.POST)
	public String mid(@ModelAttribute("user") @Valid UserInfo user,BindingResult result,BindingResult error,Locale locale){
		if(!user.getPass().equals(user.getRepass())){
			error.addError(new FieldError("user", "repass", ms.getMessage("passandrepass", null, locale)));
		}
		if(result.hasErrors()){
			return "/lesson04/reg.jsp";
		}
		return null;
	}
}
