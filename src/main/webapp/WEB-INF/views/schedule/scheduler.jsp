<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
<h1>야호~ 입력이 됐다네요~~~</h1>
<h1>달력 만들어주실분</h1>
<h2>구합니다</h2>
<c:set var="now" value="<%=new java.util.Date() %>"/>
	<fmt:formatDate value="${now }" pattern="yyyy-MM-dd" var="nowdate"/>
	<h1>${nowdate }</h1>
	<!-- 
	<table border="1">
		<c:set var="title" value=""/>
		<c:forEach var="vo" items="${list }">
			 <c:set var="title1" value="${vo.FILMNAME }"/>
			<fmt:formatDate value="${vo.MSTARTTIME }" pattern="yyyy-MM-dd" var="startdate"/>
		
			<c:if test="${nowdate==startdate}">
			   <tr>
				<c:if test="${title!=title1 }">
					
							<td>${vo.FILMNAME }</td>
					
				</c:if>
				</tr>
				<tr>
				<fmt:formatDate value="${vo.MSTARTTIME }" pattern="HH:mm" var="startdate"/>
					<td>${startdate }</td>
					
				<c:set var="title" value="${title1 }"/>	
				</tr>
			</c:if>
			
		</c:forEach>
	</table>-->
	<div>
		<c:set var="title" value=""/>
		<c:forEach var="vo" items="${list }">
			 <c:set var="title1" value="${vo.FILMNAME }"/>
			<fmt:formatDate value="${vo.MSTARTTIME }" pattern="yyyy-MM-dd" var="startdate"/>
		
			<c:if test="${nowdate==startdate}">
			  
				<c:if test="${title!=title1 }">
					<div style="clear:both"></div>
					 <div style="float:left;width:300px;background-color: yellow;">
						${vo.FILMNAME }
						
					</div>
					<div style="clear:both"></div>
				</c:if>
				
				<div style="float:left;margin-left:5px">
				<fmt:formatDate value="${vo.MSTARTTIME }" pattern="HH:mm" var="startdate"/>
					${startdate }
					
				<c:set var="title" value="${title1 }"/>	
				</div>
			</c:if>
			
		</c:forEach>
	</div>
</div>