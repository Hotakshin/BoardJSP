package com.yedam.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.notice.Impl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class NoticeInsert implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String title = request.getParameter("title");
		String Content = request.getParameter("contents");
		
		NoticeServiceImpl service = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		vo.setTitle(title);
		vo.setContent(Content);
		
		service.insertNotice(vo);
		
		request.setAttribute("notice", vo);
		return "noticeListPaging.do";
	}

}
