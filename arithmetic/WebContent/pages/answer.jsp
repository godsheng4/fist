<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>开始答题</title>
		<link type="text/css" rel="stylesheet" href="static/css/myAnswer.css">
		 
		<script type="text/javascript"></script>
		<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
		
		<!-- <script>
		$(function () {
			 $("#sub").click(function () {
				 location.href = "http://localhost:8080/arithmetic/mycalculationServlet?action=compare";
			});  
		});
		</script> -->
		
		
	</head>
	<body>
		<div class="answer">
			<div id="" class="antop">
				 <img src ="static/img/1646829643642.png" />
			</div>
			
			<form action="http://localhost:8080/arithmetic/mycalculationServlet">
			
			
			
			
			<div id="" class="left">
				<input type="hidden" name="action" value="compare">
				<c:forEach items="${requestScope.answers}" var="answer">
					<input type="hidden" name="answer" value="${answer}">
				</c:forEach>
				
				
				
				
				
				<c:forEach items="${requestScope.list}" var="question" varStatus="status" begin="0" end="9">
					<ul style="list-style:none" >
    					<li class="li">
    					(${status.index+1})
    					<c:out value="${question}"/> 
    					<input class="input" type="text" name="inputanswer"> 
    					<input type="hidden" name="questions" value="${question}">
    					</li>	
					</ul>
				</c:forEach>
				
				
				<c:if test="${not empty requestScope.result}">
    						
    				<c:forEach items="${requestScope.result}" var="answer" varStatus="status" begin="0" end="9">
						<ul style="list-style:none" >
    					<li class="li">
    					(${status.index+1})
    					<c:out value="${answer}"/> 
    					</li>	
						</ul>
    								
					</c:forEach>
    							
    			</c:if>
				
				
				
				
				
			</div>
			
			<div id="" class="right">
					<c:forEach items="${requestScope.list}" var="question" varStatus="status" begin="10" end="19">
					<ul style="list-style:none" >
    					<li class="li">
    					(${status.index+1})
    					<c:out value="${question}"/> 
    					<input class="input" type="text" name="inputanswer">
    					<input type="hidden" name="questions" value="${question}">
    					</li>	
					</ul>
				</c:forEach>
				
				<c:if test="${not empty requestScope.result}">
				
					<script type="text/javascript">
					
						alert("您本次得分"+${score});
					</script>
    				
    				<c:forEach items="${requestScope.result}" var="answer" varStatus="status" begin="10" end="19">
						<ul style="list-style:none" >
    					<li class="li">
   						(${status.index+1})
    					<c:out value="${answer}"/> 
    					</li>	
						</ul>
    								
					</c:forEach>
    							
    			</c:if>
			</div>
			
			<div id="" class="anbelow">
				<c:if test="${empty requestScope.result}">
					<input id="sub" type="submit" value="提交">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
				</c:if>
				<a href="http://localhost:8080/arithmetic/pages/newindex.jsp">返回首页</a>
			</div>
			
		</form>
			<hr >
			
			
		</div>
		
		
		
	</body>
</html>