/*================================
 * AdminAskController.java
 * - 관리자>고객문의 컨트롤러 객체
================================*/


package com.haroot.mybatis;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminAskController
{
	/*===================
	 고객지원 메뉴
	===================*/

	// mybatis 객체 의존성 (자동) 주입~!!!
	@Autowired
	private SqlSession sqlSession;
	
	// 관리자 > 고객지원 페이지
	@RequestMapping(value="/adminasklist.action", method=RequestMethod.GET)
	public String adminAskList(ModelMap model) throws SQLException
	{
		// 고객문의 
		IAskDAO dao = sqlSession.getMapper(IAskDAO.class);
		
		// 전체 회원 정보 리스트 전달
		model.addAttribute("adminAskList", dao.adminAskList());
		
		return "/WEB-INF/views/AdminAskList.jsp";
	}
	
	
}