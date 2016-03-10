<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">
<%@page import="core.com.ptk.entity.Typeword"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
	<head>
		<title>Vocabulary</title>
	</head>
	<%
		ArrayList<Typeword> typewords = (ArrayList<Typeword>) request.getAttribute("typeword");
	%>
	<body>
		<form action="addKotoba" method="get">
 			<fieldset>
  				<legend>Add Vocabulary</legend>
  				<table>
					<tr>
						<td>Lesson</td>
					</tr>
					<tr>
						<td><input type="text" name="lesson" required></td>
					</tr>
					<tr>
						<td><input type="submit" value="Add"></td>
					</tr>
				</table>
 			</fieldset>
		</form>	
		<form action="learnKotoba" method="get">
 			<fieldset>
  				<legend>Learn Vocabulary</legend>
  				<table>
					<tr>
						<td>Lesson(EX: 1,2,5,7)</td>
					</tr>
					<tr>
						<td><input type="text" name="lesson" required></td>
					</tr>
					<tr>
						<td><input type="submit" value="Learn"></td>
					</tr>
				</table>
 			</fieldset>
		</form>	
		<form action="learnKotobaWithTypeWord" method="get">
 			<fieldset>
  				<legend>Learn Vocabulary</legend>
  				<table>
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
						<td><input type="submit" value="Learn"></td>
					</tr>
				</table>
 			</fieldset>
		</form>	
	</body>
</html>