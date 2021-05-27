package com.yedam.product.service;

import java.util.List;
import com.yedam.product.vo.ProductVO;

public interface ProductService {
   //전체조회, 한건조회, 입력, 수정, 삭제
   List<ProductVO> productSelectList();
   ProductVO selectProduct();
   int insertProduct(ProductVO vo);
   int updateProduct(ProductVO vo);
   int deleteProduct(ProductVO vo);
}