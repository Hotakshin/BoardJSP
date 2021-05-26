package com.yedam.bulletin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DbCommand;

public class BulletinInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 입력값을 db insert 후 - > bulletinList.jsp
		String writer = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BulletinVO vo = new BulletinVO();
		vo.setContent(content);
		vo.setTitle(title);
		vo.setWriter(writer);
		
		BulletinServiceImpl service = new BulletinServiceImpl();
		int in = service.insertBulletin(vo);
		
		String path = "";
		
		if(in > 0) {
			path = "/bulletinList.do";
		} else
			path = "/main.do";
		
		request.setAttribute("bulletin", vo);
		return path;
	}

}
