<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="core.com.ptk.entity.Typeword"%>
<html>
	<head>
		<title>Add Kanji</title>
	</head>
	<%
		String kanjiRoot = (String) request.getAttribute("kanjiRoot"); 
		int level = (Integer) request.getAttribute("level"); 
	%>
	<body>
		<h3>Add Kanji</h3>
		<h3>Kanji <%=kanjiRoot %></h3>
		<form action="addKanjiRoot" method="post" accept-charset="UTF-8">
			<input type="hidden" name="kanjiRoot" value=<%=kanjiRoot %>>
			<input type="hidden" name="level" value=<%=level %>>
			<table>
				<tr>
					<td>Hán tự:</td>
					<td><input type="text" name="hantu" required></td>
				</tr>
				<tr>
					<td>Âm on</td>
					<td><input type="text" name="amon"></td>
				</tr>
				<tr>
					<td>Âm kun</td>
					<td><input type="text" name="amkun"></td>
				</tr>
				<tr>
					<td>Mô tả</td>
					<td><input type="text" name="mota"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Add"></td>
				</tr>
			</table>
		</form>
	</body>
</html>