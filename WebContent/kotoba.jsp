<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
	<head>
		<title>Vocabulary</title>
	</head>
	<body>
		<form action="addKotoba" method="get">
 			<fieldset>
  				<legend>Add Vocabulary</legend>
  				<table>
					<tr>
						<td>Lesson</td>
					</tr>
					<tr>
						<td><input type="text" name="lesson"></td>
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
						<td><input type="text" name="lesson"></td>
					</tr>
					<tr>
						<td><input type="submit" value="Learn"></td>
					</tr>
				</table>
 			</fieldset>
		</form>	
	</body>
</html>