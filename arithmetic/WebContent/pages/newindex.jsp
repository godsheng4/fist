<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
	<head>
		<meta charset="UTF-8">
		<title>首页</title>
		<link type="text/css" rel="stylesheet" href="../static/css/newindex.css" >
		<script type="text/javascript" src="../static/script/jquery-1.7.2.js"></script>
		<script type="text/javascript">
	    //百以内整数试题
	    
	    $(function () { 
			$("button.test").click(function () {
				    location.href = "http://localhost:8080/arithmetic/mycalculationServlet?action=integerTest";
			});
		});
	    
	    
	    
		
		$(function () { 
			$("button.test2").click(function () {
				location.href = "http://localhost:8080/arithmetic/mycalculationServlet?action=bracketTest";	    
			});
		});
		</script>
	</head>
	<body>
		<div class="top">
			<div class="left">
				四则运算练习
			</div>
		</div>
			<div class="center">
					<table class="center">
				<tr>
				  <td> 数目 </td>
				  <td> 20 </td>
				</tr>
				<tr>
					<td>类型</td>
					<td>
							<button class="test" >百以内整数算式</button>
					</td>
					<td>
					<button class="test2" >带括号算式练习</button>
					</td>
				</tr>
				</table>
			</div>
	</body>
</html>