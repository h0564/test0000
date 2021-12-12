package com.hk.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hk.member.service.MemberService;
import com.hk.member.vo.MemberVO;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	MemberService memberService ;

	@RequestMapping(value="/", method= RequestMethod.GET)
	public String home() {

		return "home";
	}
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String loginDone(@ModelAttribute MemberVO memberVO,HttpSession session) {
		logger.debug("controller = "+memberVO.toString());
		System.out.println("실행1");
		memberVO = memberService.checkUser(memberVO);

		if(memberVO == null) {
			return "loginFail";
		}else {
			session.setAttribute("login", memberVO);

			return "loginDone";
		}

	}
	@RequestMapping(value="/dupId",method= { RequestMethod.GET , RequestMethod.POST },produces = "application/json; charset=utf8")
	@ResponseBody
	public Map<String, Object> dupId(@RequestParam("id")String id) { 
		// jsp 화면을 줄필요가 없으므로. 
		// 사용자 유무만 확인해주면 된다.
		// 클라이언트->서버에 요청할때는 String으로 
		// 서버->클라이언트에 답변할때는 JSON으로
		System.out.println("id = " + id);
		Map<String, Object> map = new HashMap<String, Object>();
		boolean check = memberService.check(id);
		System.out.print("check = "+check);
		map.put("id",check); // 중복이면 true, 아니면 false라는 String반환
		return map;
	}





}
