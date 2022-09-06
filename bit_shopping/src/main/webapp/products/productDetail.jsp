<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.sql.*, com.conan.vo.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- proId를 패러미터로 넘겨받아 DB에서 필요한 정보를 조회해서 결과를 product객체값으로 설정한 후 출력 -->
<%! 
Products product;
%>
<%
String url = "jdbc:mysql://localhost:3306/scottdb?useSSL=false&allowPublicKeyRetrieval=true";
String sql = null;
String user = "scott";
String password = "tiger";
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
ArrayList<Products> pList = new ArrayList<Products>();


try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, user, password);
	sql = "select * from products";
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	while(rs.next()){
		pList.add(new Products(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
	}
	for(int i = 0; i < pList.size(); i++){
		if(pList.get(i).getProId().equals(request.getParameter("proId"))){
			product = new Products(pList.get(i).getProId(), pList.get(i).getProName(), pList.get(i).getUnitPrice(), 
					pList.get(i).getDescription(), pList.get(i).getManufacturer(), pList.get(i).getCategory(), pList.get(i).getNoOfStock());
		}
	}
	
	request.setAttribute("product", product);
} catch (Exception e){
	e.printStackTrace();
}
%>
<%@include file="./menu.jsp" %>	 <!-- 헤드 배너 -->
<div class="jumbotron">	<!-- 회색배경 -->
	<div class="container">
		<h1 class="display-3">상품 상세정보</h1>		
	</div>
</div>
<c:set var="product" value="${product}"></c:set>
<div class="container">
	<div class="row">
		<div class="col-md-5">
			<img alt="해당 이미지 없음" src="${imgUrl}" width="80%">
		</div>
		<div class="col-md-6">
			<h3>${product.proName}</h3>
			<p>${product.description}</p>
			<p>
			<b>상품 코드 : </b> <span class="badge badge-danger">${product.proId}
			</span>
			</p>
			<p>
			<b>제조사 : </b> ${product.manufacturer}
			</p>
			<p>
			<b>분류 : </b> ${product.category}
			</p>
			<p>
			<b>재고 수 : </b>${product.noOfStock}
			</p>
			<h2>${product.unitPrice}원</h2>
			 <a href="#" class="btn btn-info">상품주문 &raquo;</a>
			<a
			href="./productList.do" class="btn btn-secondary">상품 목록 &raquo;</a>
		</div>
	</div>
</div> <br>
<%@include file="./footer.jsp" %>
</body>
</html>