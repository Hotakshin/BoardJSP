<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:forEach items="${cartlist }" var="vo">
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Sale badge-->
						<c:if test="${vo.sale eq 'Y' }">
							<div class="badge bg-dark text-white position-absolute"
								style="top: 0.5rem; right: 0.5rem">Sale</div>
						</c:if>


						<!-- Product image-->
						<img class="card-img-top" style="width: 268px; height: 160px;"
							src="upload/${vo.itemImage }" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">${vo.itemName }</h5>
								<!-- Product reviews-->
								<div
									class="d-flex justify-content-center small text-warning mb-2">
									<c:forEach begin="1" end="${vo.likeIt }">

										<div class="bi-star-fill"></div>
									</c:forEach>

								</div>

								<!-- Product price-->
								<c:choose>
									<c:when test="${vo.sale eq 'Y' }">
										<span class="text-muted text-decoration-line-through">
											<fmt:formatNumber type="currency" value="${vo.price }"></fmt:formatNumber>
										</span>
										<fmt:formatNumber type="currency" value="${vo.salePrice }"></fmt:formatNumber>
									</c:when>
									<c:otherwise>
										<fmt:formatNumber type="currency" value="${vo.price }"></fmt:formatNumber>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" id="addCart"
									onclick="addCart('${vo.itemCode }')">Add to cart</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>