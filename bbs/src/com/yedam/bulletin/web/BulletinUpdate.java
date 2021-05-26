package com.yedam.bulletin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DbCommand;

public class BulletinUpdate implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터 ( id, title, content)
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println(id);
		System.out.println(title);
		System.out.println(content);
		
		BulletinServiceImpl service = new BulletinServiceImpl();
		BulletinVO vo = new BulletinVO();
		
		vo.setId(Integer.parseInt(id));
		vo.setTitle(title);
		vo.setContent(content);
		
		service.updateBulletin(vo);
		
		request.setAttribute("bulletin", vo);
		
		return "\bulletinList.do";
	}

}
