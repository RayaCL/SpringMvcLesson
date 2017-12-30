package cn.etspringmvc.lesson05.controller;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.etspringmvc.lesson05.dao.MoneyDaoImpl;


@Controller
public class InterController {
	@RequestMapping(value="/inter",method=RequestMethod.GET)
	public String reg(OutputStream out) throws IOException{
		out.write("hello".getBytes());
		return null;
	}
	@Autowired
	MoneyDaoImpl dao;
	@RequestMapping(value="/tm",method=RequestMethod.GET)
	public String reg(Integer money,OutputStream out) throws IOException{
		dao.trasnateMoney(money);
		out.write(("lostedmoney is:"+dao.selectMoney()).getBytes());
		return null;
	}
	
}
