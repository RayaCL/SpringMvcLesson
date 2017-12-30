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
 * ��̨��֤����
 * 	1.javabeen�����֤ע��
 * 	2.action��ʹ��@valid��ʾjavabean ʹ��Errors����BindingResult�ж��Ƿ����ʧ��
 * 	3.����jar����ͻ4.3.2�汾
 * @author Administrator
 *
 */
@Controller
public class RegController {
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public String reg(@ModelAttribute("user") @Valid UserInfo user,BindingResult error){
		if(!user.getPass().equals(user.getRepass())){
			error.addError(new FieldError("user", "repass", "���벻һ��"));
		}
		/*if(user.getAge()==null || user.getAge().equals("")){
			error.addError(new FieldError("userInfo", "age", "���䲻��Ϊ��"));

		}else{
			try {
				Integer age=Integer.parseInt(user.getAge());
				if(age<1||age>100){
					error.addError(new FieldError("userInfo", "age", "��������Ӱ�1~100֮��"));
				}
			} catch (Exception e) {
				error.addError(new FieldError("userInfo", "age", "�������������"));
			}
		}*/
		
//		if(error.hasErrors()){
//			return "/lesson03/fail.jsp";
//		}
		return "/lesson03/reg.jsp";
	}
}
