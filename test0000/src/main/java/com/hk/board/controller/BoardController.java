package com.hk.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hk.board.service.BoardService;
import com.hk.board.vo.ArticleVO;

@Controller
public class BoardController {
	//loger 설정 (각 Class별로)
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	   BoardService boardService;
	   
	   @RequestMapping(value="/list", method= {RequestMethod.GET,RequestMethod.POST})
	   public String boardList(Model model) { 
	      
	      List<ArticleVO> articlesList = boardService.selectAllList();
	      model.addAttribute("articlesList",articlesList);
	      logger.debug("----/list called");
	      return "boardList";  // boardList.jsp
	   }
	   
	   @RequestMapping(value="/add", method=RequestMethod.GET)
	   public String boardAdd() { 
	      
	     
	      return "boardAdd";  // boardList.jsp
	   }
	   
	   @RequestMapping(value="/add", method=RequestMethod.POST)
	   public String boardAddDone(Model model,@ModelAttribute ArticleVO articleVO) { 
	
	      logger.debug("title"+articleVO.getTitle());
	      logger.debug("content"+articleVO.getContent());
	    
	     
	      int ret = boardService.addArticle(articleVO);
	      model.addAttribute("ret",ret);
	      return "boardAddDone";  // boardList.jsp
	   }
	   
	   //Model model,@RequestParam("articleNO")
	   @RequestMapping(value="/update", method=RequestMethod.GET)
	   public String boardView(Model model,@RequestParam("articleNO") int articleNO) { 
		  logger.debug("articleNo = "+articleNO);
	     ArticleVO articleVO =  boardService.viewArticle(articleNO);
	     model.addAttribute("article", articleVO);
	     logger.debug("testtest123"+articleVO.toString());
	      return "boardview";  // boardList.jsp
	   }
	   
	   @RequestMapping(value="/update", method=RequestMethod.POST)
	   public String boardUpdate(Model model,@ModelAttribute ArticleVO articleVO) { 
	      logger.debug("minsu "+articleVO.toString());
	     int ret = boardService.modArticle(articleVO);
	     model.addAttribute("ret",ret); 
	     return "boardUpdateDone";  // boardList.jsp
	   }
	   
	   @RequestMapping(value="/removeArticle.do", method=RequestMethod.POST)
	   public String boardDelete(Model model,@ModelAttribute ArticleVO articleVO) { 
	      System.out.println("articleNO = "+articleVO.getArticleNO());
	      int ret = boardService.deleteArticle(articleVO.getArticleNO());
	      model.addAttribute("ret", ret);
	     return "testdelete";  
	   }
	   
	   //성주형 코드
//	   @RequestMapping(value="/update",method=RequestMethod.GET)
//	   public String boardView(Model model,int articleNO) {
//	      System.out.println("articleNO : "+articleNO);
//	      ArticleVO articleVO = boardService.viewArticle(articleNO);
//	      model.addAttribute("article", articleVO);
//	      return "boardview";
//	   }
}
