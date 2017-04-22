package zhang.fan.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import common.generic.GenericService;
import zhang.fan.entity.Member;
import zhang.fan.service.MemberService;

@Controller
@RequestMapping(value="/user")
public class LoginCtrl {
	@Autowired
	private GenericService genericService;
	@Autowired
	private MemberService memberService;
	
	
	
	@RequestMapping(value="login")
	@ResponseBody
	public Map<String ,Object> login(HttpServletRequest request, String userName,String password) throws Exception{
		Map<String,Object> data = new HashMap<String, Object>();
		Member member = memberService.getMemberByName(userName);
		if(member==null){
			throw new Exception("用户不存在");
		}
		if(password!=null){
			if(password.equals(member.getPassword())){//暂时未做MD5
				request.getSession().setAttribute("member", member.getId());
				data.put("result", "success");
				data.put("login", "true");
				data.put("detail", "登录成功");
			}else{
				throw new Exception("密码错误");
			}
		}
		
		return data;
	}
	
}
