<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Library Automation System</title>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<!-- stylesheets -->
		<link rel="stylesheet" type="text/css" href="../css/reset.css" />
		<link rel="stylesheet" type="text/css" href="../css/style.css" media="screen" />
		<link id="color" rel="stylesheet" type="text/css" href="../css/colors/blue.css" />
		<!-- scripts (jquery) -->
		<script src="../js/jquery-1.6.4.min.js" type="text/javascript"></script>
		<script src="../js/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
		<script src="../js/smooth.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(document).ready(function () {
				style_path = "resources/css/colors";
	
				$("input.focus").focus(function () {
					if (this.value == this.defaultValue) {
						this.value = "";
					}
					else {
						this.select();
					}
				});

				$("input.focus").blur(function () {
					if ($.trim(this.value) == "") {
						this.value = (this.defaultValue ? this.defaultValue : "");
					}
				});

				$("input:submit, input:reset").button();
			});
		</script>
	</head>
	<body>
		<div id="login">
			<!-- login -->
			<div class="title">
				<h5>Sign In to Library Automation System</h5>
				<div class="corner tl"></div>
				<div class="corner tr"></div>
			</div>
			
			<div class="inner">
				<form action="" method="get">
				<div class="form">
					<!-- fields -->
					<div class="fields">
						<div class="field">
							<div class="labelSelectOptions">
								<label for="username">Please Select Options</label>
							</div>
							<br></br>
							<div class="Adminbuttons">
								<a href="Login.jsp"><input type="button" value="Administrator" style="margin: 0px 0px 0px 143px"/></a>
							</div>		
							<br></br>
							<br/>
							<br />
							<div class="readerbuttons">
								<a href="readerLogin.jsp"><input type="button" value="Reader" style="margin: 0px 0px 0px 157px"/></a>
							</div>
						</div>
					</div>
					<!-- end fields -->
				</div>
				</form>
			</div>
			<!-- end login -->
			
		</div>
	</body>
</html>