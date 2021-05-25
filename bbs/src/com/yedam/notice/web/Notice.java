package com.yedam.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.notice.Impl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class Notice implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 한건 조회 -- > notice.jsp
		// serviceImpl 구현.
		String id = request.getParameter("id");
		
		NoticeServiceImpl service = new NoticeServiceImpl();
		NoticeVO vo = service.noticeSelect(Integer.parseInt(id));
	
		
		request.setAttribute("notice", vo);
		
		return "notice/notice.tiles";
	}

}
