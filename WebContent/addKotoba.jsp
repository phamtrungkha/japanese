<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="core.com.ptk.entity.Typeword"%>
<html>
	<head>
		<title>Add Vocabulary</title>
	</head>
	<%
		String lesson = (String) request.getAttribute("lesson"); 
		ArrayList<Typeword> typewords = (ArrayList<Typeword>) request.getAttribute("typeword");
	%>
	<body>
		<h3>Add Vocabulary</h3>
		<h3>Lesson <%=lesson %></h3>
		<form action="addKotoba" method="post" accept-charset="UTF-8">
			<input type="hidden" name="lesson" value=<%=lesson %>>
			<table>
				<tr>
					<td>Japanese</td>
					<td><input type="text" name="jp"></td>
				</tr>
				<tr>
					<td>Vietnamese</td>
					<td><input type="text" name="vn"></td>
				</tr>
				<tr>
					<td>English</td>
					<td><input type="text" name="en"></td>
				</tr>
				<tr>
					<td>Typeword</td>
					<td>
						<select name="typeword">
							<%
								for (int i = 0; i < typewords.size(); i++){
							%>
							<option value=<%=typewords.get(i).getId() %>><%=typewords.get(i).getName() %></option>
							<%} %>
						</select>
					</td>
				</tr>
				<tr>
					<td>ignore</td>
					<td><input type="checkbox" name="ignoreword" value="false"><br></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Add"></td>
				</tr>
			</table>
		</form>
	</body>
</html>