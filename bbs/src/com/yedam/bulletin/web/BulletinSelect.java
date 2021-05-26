package com.yedam.bulletin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DbCommand;

public class BulletinSelect implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 한건을 조회해서 bulletin.jsp 로 전송
		
		String id = request.getParameter("id");
		
		BulletinServiceImpl service = new BulletinServiceImpl();
		BulletinVO vo = new BulletinVO();
		
		vo.setId(Integer.parseInt(id));
		
		service.bulletinSelect(vo);
		
		request.setAttribute("bulletin", vo);		
		return "bulletin/bulletin.tiles";
	}

}
