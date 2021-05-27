package com.yedam.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.product.serviceImpl.ProductServiceImpl;

public class CartList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 장바구니 카트 리스트 출력 
		String id = request.getParameter("uid");
		System.out.println(id);
		ProductServiceImpl service = new ProductServiceImpl();
		List<CartVO> vo = service.CartList(id);
		
		request.setAttribute("cartlist", vo);
		System.out.println(vo);
		return "product/cartList.tiles" ;
	}

}
