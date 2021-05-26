package com.yedam.bulletin.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.service.BulletinService;
import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DbCommand;

public class BulletinList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		BulletinService service = new BulletinServiceImpl(); // 같은객체라서 이런식으로 사용가능
		List<BulletinVO> list = service.bulletinSelectList();
		
		request.setAttribute("bulletinList", list);
		
		
		return "bulletin/bulletinList.tiles";
	}

}
