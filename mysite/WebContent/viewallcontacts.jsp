<%@include file="header.html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>View by Group</title>
</head>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">

	<center>
		<h2>View by Group</h2>
	</center>
	<!--Body: view by group information-->
	<center>
		<form method="post">

			<table cellpadding="0" cellspacing="0" width="50%"">
				<th>Email</th>
				<th>FN</th>
				<th>MN</th>
				<th>LN</th>
				<th>Home</th>
				<th>Work</th>
				<th>Mobile</th>
				<th>GroupId</th>

				<c:forEach var="email" items="${emailList}">
					<tr>
						<td>${email.eMailID}</td>&nbsp;&nbsp;&nbsp;&nbsp;
						<td>${email.fName}</td>&nbsp;&nbsp;&nbsp;&nbsp;
						<td>${email.mName}</td>&nbsp;&nbsp;&nbsp;&nbsp;
						<td>${email.lName}</td>&nbsp;&nbsp;&nbsp;&nbsp;
						<td>${email.hPhone}</td>&nbsp;&nbsp;&nbsp;&nbsp;
						<td>${email.wPhone}</td>&nbsp;&nbsp;&nbsp;&nbsp;
						<td>${email.mPhone}</td>&nbsp;&nbsp;&nbsp;&nbsp;
						<td>${email.groupID}</td>&nbsp;

					</tr>

				</c:forEach>
			</table>
		</form>
	</center>
</body>



</html>
<%@include file="footer.html"%>
</body>