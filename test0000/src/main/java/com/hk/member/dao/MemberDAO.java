package com.hk.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.member.service.MemberService;
import com.hk.member.vo.MemberVO;

@Repository
public class MemberDAO {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	@Autowired
	SqlSession sqlSession;

	public List<MemberVO> selectAll() {
		List<MemberVO> list = sqlSession.selectList("mapper.member.selectAllMember");
		return list;
	}

	public MemberVO isExisted(MemberVO memberVO) {
		logger.debug("DAO"+memberVO.toString());
		memberVO  = sqlSession.selectOne("mapper.member.isExisted",memberVO);
		return memberVO;
	}
	public boolean check(String id) {

		MemberVO memberVO = sqlSession.selectOne("mapper.member.select",id); //익셉션 발생시 중복아님

		if(id.equals(memberVO.getId())) { // 중복
			return true;
		}

		return false; //여기까지 안오게 해야함
		

	}
//	public MemberVO dupId(String id) {
//	      // TODO Auto-generated method stub
//	      System.out.println("다오 아이디값"+id);
//	      MemberVO dupId = sqlSession.selectOne("mapper.member.dupId",id);
//	      return dupId;
//	   }
}
