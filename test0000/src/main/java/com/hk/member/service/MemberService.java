package com.hk.member.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.member.controller.MemberController;
import com.hk.member.dao.MemberDAO;
import com.hk.member.vo.MemberVO;

@Service
public class MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	@Autowired
	MemberDAO memberDAO;

	

	public MemberVO checkUser(MemberVO memberVO) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------------------------------");
		logger.debug("service"+memberVO.toString());
		return memberDAO.isExisted(memberVO);
	}
	
	public boolean check(String id) {
		try {
			 memberDAO.check(id);
		} catch (Exception e) {
			return false;
		}
		if(memberDAO.check(id)) {
			return true;
		}
		
		return false;
		
	}
	
	
	
}
