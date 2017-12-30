package cn.etspringmvc.lesson03.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.etspringmvc.lesson03.entity.UserInfo;


/**
 * 后台验证步骤
 * 	1.javabeen添加验证注解
 * 	2.action中使用@valid表示javabean 使用Errors或者BindingResult判断是否检验失败
 * 	3.出现jar包冲突4.3.2版本
 * @author Administrator
 *
 */
@Controller
public class RegController {
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public String reg(@ModelAttribute("user") @Valid UserInfo user,BindingResult error){
		if(!user.getPass().equals(user.getRepass())){
			error.addError(new FieldError("user", "repass", "密码不一致"));
		}
		/*if(user.getAge()==null || user.getAge().equals("")){
			error.addError(new FieldError("userInfo", "age", "年龄不能为空"));

		}else{
			try {
				Integer age=Integer.parseInt(user.getAge());
				if(age<1||age>100){
					error.addError(new FieldError("userInfo", "age", "年龄必须子啊1~100之间"));
				}
			} catch (Exception e) {
				error.addError(new FieldError("userInfo", "age", "年龄必须是数字"));
			}
		}*/
		
//		if(error.hasErrors()){
//			return "/lesson03/fail.jsp";
//		}
		return "/lesson03/reg.jsp";
	}
}
