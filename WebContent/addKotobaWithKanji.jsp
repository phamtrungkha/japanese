<%@page import="core.com.ptk.entity.Typeword"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<%
		String kanjiRoot = (String) request.getAttribute("kanjiRoot"); 
		String kj = (String) request.getAttribute("kj"); 
		String jp = (String) request.getAttribute("jp"); 
		int level = (Integer) request.getAttribute("level"); 
		ArrayList<Typeword> typewords = (ArrayList<Typeword>) request.getAttribute("typewords");
	%>
	<body>
		<h3>Add Vocabulary</h3>
		<h3>Lesson <%=0 %></h3>
		<form action="addKotoba" method="post" accept-charset="UTF-8">
			<input type="hidden" name="lesson" value=<%=0 %>>
			<input type="hidden" name="kj" value=<%=kj%>>
			<input type="hidden" name="kanjiRoot" value=<%=kanjiRoot %>>
			<input type="hidden" name="level" value=<%=level %>>
			<table>
				<tr>
					<td>Japanese</td>
					<td><input type="text" name="jp" value="<%= jp%>"></td>
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