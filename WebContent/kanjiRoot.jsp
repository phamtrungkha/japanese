<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
	<head>
		<title>KanjiRoot</title>
	</head>
	<body>
		<form action="kanjiRoot" method="post">
 			<fieldset>
  				<legend>Add KanjiRoot</legend>
  				<table>
					<tr>
						<td>KanjiRoot Root:</td>
					</tr>
					<tr>
						<td><input type="text" name="kanjiRootRoot" required></td>
					</tr>
					<tr>
						<td>Level:</td>
					</tr>
					<tr>
						<td><input type="text" name="level" required></td>
					</tr>
					<tr>
						<td><input type="submit" value="Add"></td>
					</tr>
				</table>
 			</fieldset>
		</form>	
		<form action="learnKanjiRoot" method="get">
 			<fieldset>
  				<legend>Learn KanjiRoot</legend>
  				<table>
					<tr>
						<td>Level JLPT(EX: 1,2,3,4,5)</td>
					</tr>
					<tr>
						<td><input type="text" name="level" required></td>
					</tr>
					<tr>
						<td><input type="submit" value="Learn"></td>
					</tr>
				</table>
 			</fieldset>
		</form>	
	</body>
</html>