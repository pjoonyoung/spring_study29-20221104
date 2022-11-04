package com.joonyoung.study29.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joonyoung.study29.Dao.IDao;
import com.joonyoung.study29.Dto.ContentDto;

@Controller
public class BoardController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/")
	public String home() {
		return "redirect:list";
	}
	
	@RequestMapping(value = "writeForm")
	public String writeForm() {
		
		return "writeForm";
	}
	
	@RequestMapping(value = "write")
	public String write(HttpServletRequest request) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mwriter = request.getParameter("mwriter");
		String mcontent = request.getParameter("mcontent");
		
		dao.writeDao(mwriter, mcontent);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "list")
	public String list(Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		ArrayList<ContentDto> dtos = dao.listDao();
		
		model.addAttribute("list", dtos);
		
		return "list";
	}
	
	@RequestMapping(value = "delete")
	public String delete(HttpServletRequest request) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		
		dao.deleteDao(mid);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "mview")
	public String mview(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		ContentDto dtos = dao.mviewDao(mid);
		
		model.addAttribute("mdto", dtos);
		
		return "mview";
	}
	
	@RequestMapping(value = "modify")
	public String modify(HttpServletRequest request) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mwriter = request.getParameter("mwriter");
		String mcontent = request.getParameter("mcontent");
		String mid = request.getParameter("mid");
		
		dao.modifyDao(mwriter, mcontent, mid);
		
		return "redirect:list";
	}
	
	
}
