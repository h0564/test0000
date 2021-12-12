package com.hk.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.board.dao.BoardDAO;
import com.hk.board.vo.ArticleVO;
@Service
public class BoardService {
	@Autowired
	BoardDAO boardDAO;
	public List<ArticleVO> selectAllList() {
		// TODO Auto-generated method stub
		return boardDAO.selectAllList();
	}
	public int addArticle(ArticleVO articleVO) {
		// TODO Auto-generated method stub
		return boardDAO.addArticle(articleVO);
	}
	
	public ArticleVO viewArticle(int articleNO) {
		return boardDAO.selectArticle(articleNO);
	}
	
	public int modArticle(ArticleVO articleVO) {
		return boardDAO.updateArticle(articleVO);
	}
	public int deleteArticle(int articleNO) {
		
		return boardDAO.deleteArticle(articleNO);
	}
}
