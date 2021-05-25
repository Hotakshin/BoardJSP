package com.yedam.notice.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.notice.Impl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class NoticeUpdate implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터(id, title, content)
		// serviceImpl - > update 기능작성.
		// 공지사항 리스트로 페이지 호출.
	    
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NoticeServiceImpl service = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		
		vo.setId(Integer.parseInt(id));
		vo.setTitle(title);
		vo.setContent(content);
		
		service.updateNotice(vo);
		
		request.setAttribute("notice", vo);
		return "noticeList.do";
	}

}
