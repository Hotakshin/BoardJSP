package com.yedam.common;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.product.serviceImpl.ProductServiceImpl;

public class IndexPage implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ProductServiceImpl service1 = new ProductServiceImpl();
		int cartCnt = service1.getCountCart(id);
		
		request.setAttribute("id", id);
		request.setAttribute("cartCnt", cartCnt);
		
		return "common/section.tiles";
	}

}
