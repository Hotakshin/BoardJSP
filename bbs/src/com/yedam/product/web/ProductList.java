package com.yedam.product.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.yedam.common.DbCommand;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceImpl;
import com.yedam.product.vo.ProductVO;

public class ProductList implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ProductService service = new ProductServiceImpl();
		List<ProductVO> list = service.productSelectList();
		
		String id = (String)session.getAttribute("id");
		
		ProductServiceImpl service1 = new ProductServiceImpl();
		
		int cnt = service1.getCountCart(id);
		
		request.setAttribute("cartCnt", cnt);
		request.setAttribute("list", list);
		
		
		return "product/productList.tiles";
	}

}
