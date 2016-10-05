<%@page import="java.util.List"%>
<%@page import="dao.branchajaxdao"%>
<%@page import="vo.branchVO"%>
<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Admin New Reader</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<!-- stylesheets -->
		<link rel="stylesheet" type="text/css" href="../css/reset.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
		<link id="color" rel="stylesheet" type="text/css" href="../css/colors/blue.css" />
		<!-- scripts (jquery) -->
		<script src="../js/jquery-1.6.4.min.js" type="text/javascript"></script>
		<!--[if IE]><script language="javascript" type="text/javascript" src="resources/scripts/excanvas.min.js"></script><![endif]-->
		<script src="../js/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
		<script src="../js/jquery.ui.selectmenu.js" type="text/javascript"></script>
		<script src="../js/jquery.flot.min.js" type="text/javascript"></script>
		<script src="../js/tiny_mce.js" type="text/javascript"></script>
		<script src="../js/jquery.tinymce.js" type="text/javascript"></script>
		<!-- scripts (custom) -->
		<script src="../js/smooth.js" type="text/javascript"></script>
		<script src="../js/smooth.menu.js" type="text/javascript"></script>
		<script src="../js/smooth.chart.js" type="text/javascript"></script>
		<script src="../js/smooth.table.js" type="text/javascript"></script>
		<script src="../js/smooth.form.js" type="text/javascript"></script>
		<script src="../js/smooth.dialog.js" type="text/javascript"></script>
		<script src="../js/smooth.autocomplete.js" type="text/javascript"></script>
	</head>
	<body>
	<% 
			if(session.getAttribute("copyandreserve")!=null)
			{
				
				%>
				<script>
				alert("Book is reserved for you!!!");
				</script>
				<%
				session.removeAttribute("copyandreserve");
		}
			
		%>
		
		<div id="header">
			<!-- logo -->
			<div id="logo">
				<h1>Library Automation System</h1>
			</div>
			<!-- end logo -->
			<!-- user -->
			<ul id="user">
				<li class="first"><a href="">Hello (${sessionScope.readerrrriidd[0].readerName})</a></li>
				<li><a href="">Logout</a></li>
			</ul>
			<!-- end user -->
			<div id="header-inner">
				<div id="home">
					<a href="Reader_MainPage.jsp" title="Home"></a>
				</div>
				<!-- quick -->
				<ul id="quick">
					<li>
						<a href="#" title=""><span class="icon"><img src="../images/application_double.png" alt="Search a Book" /></span><span>Search a Book</span></a>
						<ul>
							<li>
									<li><a href="Reader_SearchID.jsp">ID</a></li>
									<li><a href="">Title</a></li>
									<li><a href="">Publisher</a></li>
							</li>
						</ul>
					</li>
					<li>
						<a href=""><span class="icon"><img src="../images/cog.png" alt="Reserve New Book" /></span><span>Reserve New Book</span></a>
					</li>
				</ul>
				<!-- end quick -->
				<div class="corner tl"></div>
				<div class="corner tr"></div>
			</div>
		</div>
		<!-- end header -->
		<!-- content -->
		
		<div id="content">
			<!-- end content / left -->
			<div id="left">
				<div id="menu">
					<h6 id="h-menu-products" class="selected"><a href="#products"><span>Reader</span></a></h6>
					<ul id="menu-products" class="opened">
						
						<li class="collapsible">
							<a href="#" class="collapsible plus">Search a Book</a>
							<ul id="whatever" class="collapsed">
								<li><a href="">ID</a></li>
								<li><a href="">Title</a></li>
								<li><a href="">publisher</a></li>
							</ul>
						</li>
					</ul>
					<h6 id="h-menu-pages"><a href="Reader_BookReserve.jsp?ID=${sessionScope.readerrrriidd[0].readerID}"><span>Reserve New Book</span></a></h6>
					<ul id="menu-pages" class="closed">
						
					</ul>
					
				</div>
				
			</div>
			<!-- end content / left -->
			<!-- content / right -->
			<div id="right">
				<!-- forms -->
				<div class="box">
					<!-- box / title -->
					<div class="title">
						<h5>Select a book</h5>
					</div>
					<!-- end box / title -->
					<form id="form" action="<%=request.getContextPath() %>/reservebookcontroller" method="post">
					<input type = "hidden" value="Reservenewbook" name="flag">
												<div class="table">
						<div class="table">
						<table>
							<thead>
								<tr>
									<th>Book name</th>									
									<th>No of copy of book</th>
									<th>Function</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${sessionScope.branchwisebook}" var="row">
								<tr>
									<td class="left">${row[2].bookTitle}</td>
									<td>${row[0].copy}</td>
									<td><a href="<%=request.getContextPath()%>/reservebookcontroller?readerID=${sessionScope.readerrrriidd[0].readerID}&branchID=${row[1].branchID}&bookID=${row[2].bookID}&flag=clckbookreserve">Reserve</a></td>					
								</tr>
							</c:forEach>

							</tbody>
						</table>
						<!-- pagination -->
						</div>
					</div>
					</form>
				</div>
				<!-- end forms -->
				
			</div>
			<!-- end content / right -->
		</div>
		<!-- end content -->
		
	</body>
</html>