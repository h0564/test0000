package com.hk.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.board.vo.ArticleVO;
@Repository
public class BoardDAO {
	@Autowired
	SqlSession sqlSession;
	public List<ArticleVO> selectAllList() {
		// TODO Auto-generated method stub
		List<ArticleVO> list = sqlSession.selectList("mapper.board.selectAllArticleList");
		
		return list;
	}
	
	public int addArticle(ArticleVO articleVO) {
		// TODO Auto-generated method stub
		int ret = sqlSession.insert("mapper.board.insertMember", articleVO);
		return ret;
		
	}
	
	public ArticleVO selectArticle(int articleNO) {
		//board.xml에 있는 selectOneArticle 실행
		ArticleVO articleVO = sqlSession.selectOne("mapper.board.selectOneArticle", articleNO);
		return articleVO;
	}
	
	public int updateArticle(ArticleVO articleVO) {
		int ret = sqlSession.update("mapper.board.UpdateArticle",articleVO);
		return ret;
	}

	public int deleteArticle(int articleNO) {
		int ret = sqlSession.delete("mapper.board.deleteArticle",articleNO);
		return ret;
	}

}
