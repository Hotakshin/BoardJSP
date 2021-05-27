package com.yedam.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.product.serviceImpl.ProductServiceImpl;
import com.yedam.product.vo.ProductVO;

public class AddCart implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// cart 테이블에 한건 추가(회원아이디, 상품정보, 수량(=1))
		String id = request.getParameter("id");
		String itemCode = request.getParameter("itemCode");
		int qty = 1;
		
		ProductServiceImpl service = new ProductServiceImpl();
		int cartCnt = service.getCountCart(id);
		
		service = new ProductServiceImpl();
		
		service.addCart(id, itemCode, qty);
		
		request.setAttribute("cartCnt", cartCnt);
		
		
		return "/productList.do";
	}

}
