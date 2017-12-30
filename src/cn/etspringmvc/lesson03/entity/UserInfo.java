package cn.etspringmvc.lesson03.entity;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class UserInfo {
	/**
	 * NotNull 属性名!=null
	 * NotEmpty 属性名!=null && !属性名.equals("")
	 */
	@NotEmpty(message="用户名不能为空")
	private String userName;
	@NotEmpty(message="密码不能为空")
	private String pass;
	@NotEmpty(message="确认密码不能为空")
	private String repass;
	@Pattern(message="邮箱格式错误", regexp = ".+@.+\\..+")
	private String email;
//	@Digits(integer=1,fraction=150,message="年龄必须在1~150之间")
	@NotEmpty(message="年龄不能为空")
	@Min(value=1,message="年龄必须大于1")
	@Max(value=100,message="年龄必须小于100")
	private String age;
	@Size(min=11,max=11,message="电话号码是11位哦")
	private String tle;
//	@Past (message="出生日期为过去时间")
//	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotEmpty(message="日期不能为空")
	@Pattern(message="日期不合格   格式为(yyyy-MM-dd)",regexp="^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))" )
	private String time;
	@NotEmpty(message="网址不能为空")
	@Pattern(message="网址格式不正确",regexp="(http://|ftp://|https://|www){0,1}[^\u4e00-\u9fa5\\s]*?\\.(com|net|cn|me|tw|fr)[^\u4e00-\u9fa5\\s]*")
	private String adds;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getRepass() {
		return repass;
	}
	public void setRepass(String repass) {
		this.repass = repass;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTle() {
		return tle;
	}
	public void setTle(String tle) {
		this.tle = tle;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAdds() {
		return adds;
	}
	public void setAdds(String adds) {
		this.adds = adds;
	}
	
}
