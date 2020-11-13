<%@ page import="java.util.*" %>
<%! @SuppressWarnings("rawtypes") %>
<html>
<head>
	<style>
		body {
			background-image: url("eshop.jpg");
			background-repeat: no-repeat;
			background-position: center;
			background-size: cover;
		}
	</style>
</head>
<body>
	<h1 align="center">PC recommendations JSP</h1>
	<p>

	<%
		List styles = (List)request.getAttribute("styles");
		Iterator it = styles.iterator();
		while(it.hasNext()) {
			out.print("<br>try: " + it.next());
		}
	%>

</body>
</html>
