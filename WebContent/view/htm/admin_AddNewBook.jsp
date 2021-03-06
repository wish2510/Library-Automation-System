<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="dao.branchajaxdao"%>
<%@page import="vo.branchVO"%>
<%@page import="java.util.List"%>
<%@page import="dao.publisherajaxdao"%>
<%@page import="vo.publisherVO"%>
<%@page import="dao.authorajaxdao"%>
<%@page import="vo.authorVO"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="p"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="b"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	
	<%
		authorVO authVO = new authorVO();
		authorajaxdao authorajax = new authorajaxdao();
		List authorlist = authorajax.select();
		
		publisherVO publisherVO = new publisherVO();
		publisherajaxdao publisherajaxdao = new publisherajaxdao();
		List publisherlist = publisherajaxdao.select();
		
		branchVO brchVO = new branchVO();
		branchajaxdao branajaxdao = new branchajaxdao();
		List branchlist = branajaxdao.select();
		
	%>
		<title>Admin Add Book</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<!-- stylesheets -->
		<link rel="stylesheet" type="text/css" href="../css/reset.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
		<link id="color" rel="stylesheet" type="text/css" href="../css/blue.css" />
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

		<div id="header">
			<!-- logo -->
			<div id="logo">
				<h1>Library Automation System</h1>
			</div>
			<!-- end logo -->
			<!-- user -->
			<ul id="user">
				<li class="first"><a href="">Welcome</a></li>
				<li><a href="">Logout</a></li>
			</ul>
			<!-- end user -->
			<div id="header-inner">
				<div id="home">
					<a href="AdminMainPage.jsp" title="Home"></a>
				</div>
				<!-- quick -->
				<ul id="quick">
	
					</li>
					<li>
						<a href="#" title=""><span class="icon"><img src="../images/application_double.png" alt="Add" /></span><span>Add</span></a>
						<ul>
							<li><a href="admin_AddReader.jsp">New Reader</a></li>
						<!--	<li><a href="#">Book</a></li> -->
							<li>
								<a href="#" class="childs">Book</a>
								<ul>
									<li><a href="admin_AddexiBook.jsp">Existing</a></li>
									<li><a href="admin_AddReader2.jsp">new</a></li>
								</ul>
							</li>
						</ul>
					</li>
					<li>
						<a href="admin_BranchInfo.jsp" title="Events"><span class="icon"><img src="../images/cog.png" alt="Branch Info" /></span><span>Branch Info</span></a>
						
					</li>
					<li>
						<a href="<%=request.getContextPath() %>/BranchInfocontroller?flag=frequantborrower" title="Pages"><span class="icon"><img src="../images/page_white_copy.png" alt="Frequent Borrower" /></span><span>Frequent Borrower</span></a>
						
					</li>
					<li>
						<a href="<%=request.getContextPath() %>/BranchInfocontroller?flag=mostborrowed" title="Links"><span class="icon"><img src="../images/application_double.png" alt="Most borrowed book" /></span><span>Most borrowed book</span></a>
					</li>
					<li>
						<a href="<%=request.getContextPath() %>/BranchInfocontroller?flag=averagefine" title="Settings"><span class="icon"><img src="../images/cog.png" alt="Average Fine" /></span><span>Average Fine</span></a>
						
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
			<!-- content -->
		<div id="content">
			<!-- end content / left -->
			<div id="left">
				<div id="menu">
					<h6 id="h-menu-products" class="selected"><a href="#products"><span>Add</span></a></h6>
					<ul id="menu-products" class="opened">
						
						<li class="selected"><a href="admin_AddReader.jsp">New Reader</a></li>
						<li class="collapsible">
							<a href="#" class="collapsible plus">Book</a>
							<ul id="whatever" class="collapsed">
								<li><a href="admin_AddexiBook.jsp">Existing</a></li>
								<li><a href="admin_AddReader2.jsp">New</a></li>
			
							</ul>
						</li>
					</ul>
					<h6 id="h-menu-pages"><a href="admin_BranchInfo.jsp"><span>Branch Info</span></a></h6>
					<ul id="menu-pages" class="closed">
						
					</ul>
					<h6 id="h-menu-events"><a href="<%=request.getContextPath() %>/BranchInfocontroller?flag=frequantborrower"><span>Frequent Borrower</span></a></h6>
					
					<h6 id="h-menu-links"><a href="<%=request.getContextPath() %>/BranchInfocontroller?flag=mostborrowed"><span>Most borrowed book</span></a></h6>
					
					<h6 id="h-menu-settings"><a href="<%=request.getContextPath() %>/BranchInfocontroller?flag=averagefine"><span>Average Fine</span></a></h6>
					
				</div>
				
			</div>
			<!-- end content / left -->
			<!-- content / right -->
			<div id="right">
				<!-- forms -->
				<div class="box">
					<!-- box / title -->
					<div class="title">
						<h5>Add Book</h5>
					</div>
					<!-- end box / title -->
					
					<form id="form" action="<%=request.getContextPath() %>/addnewbookcontroller" method="post">
					<input type="hidden" value="Addnewbook" name="flag">
					<div class="form">
						<div class="fields">
							<div class="field">
								<div class="label">
									<label for="input-medium">Branch:</label>
								</div>	
								<div class="input">
										<select name="branchretrived" id="branchret"  align="" class="" style="min-width:57%;height: 30px" required>
											<option value="">--select--</option>
											<b:forEach items="<%=branchlist%>" var="row2">
												<option value="${row2.branchID}" id="${row2.branchID }">(${row2.branchName}) (${row2.branchLoc}) (ID: ${row2.branchID})</option>
											</b:forEach>
										</select>
								</div>
							</div>
							
							<div class="field">
								<div class="label">
									<label for="input-medium">Book Title:</label>
								</div>	
								<div class="input">
									<input type="text" id="input-medium" name="booktitle" class="medium" />
								</div>
							</div>
							<div class="field">
								<div class="label">
									<label for="input-medium">Author:</label>
								</div>	
								<div class="input">
										<select name="authorretrived" id="authorret"  align="" class="" style="min-width:57%;height: 30px" required>
											<option value="">--select--</option>
											<c:forEach items="<%=authorlist%>" var="row">
												<option value="${row.authorID}" id="${row.authorID }">(${row.authorName})  (ID: ${row.authorID})</option>
											</c:forEach>
										</select>
								</div>
							</div>
						
							
							<div class="field">
								<div class="label">
									<label for="input-medium">Book Publisher:</label>
								</div>	
								<div class="input">
									<select name="publisherretrived" id="publishret" align="" class="" style="min-width:57%;height:30px" required>
											<option value="">--select--</option>
											<p:forEach items="<%=publisherlist%>" var="row1">
												<option value="${row1.publisherID}" id="${row1.publisherID }">(${row1.publisherName})  (ID: ${row1.publisherID})</option>
											</p:forEach>
										</select>
								</div>
							</div>
						
							<div class="field">
								<div class="label">
									<label for="input-medium">Publication Date:</label>
								</div>	
								<div class="input">
									<input type="text" id="input-medium" name="publicationdate" class="medium" />
								</div>
							</div>
							<div class="buttons">
								<input type="submit" name="submit" value="Submit" />
								<input type="reset" name="reset" value="Reset" />
							</div> 
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