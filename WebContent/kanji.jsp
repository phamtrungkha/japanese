<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
	<head>
		<title>Kanji</title>
	</head>
	<body>
		<form action="addKanji" method="get">
 			<fieldset>
  				<legend>Add Kanji</legend>
  				<table>
					<tr>
						<td>Kanji</td>
					</tr>
					<tr>
						<td><input type="text" name="kanjiRoot"></td>
					</tr>
					<tr>
						<td><input type="text" name="level"></td>
					</tr>
					<tr>
						<td><input type="submit" value="Add"></td>
					</tr>
				</table>
 			</fieldset>
		</form>	
		<form action="learnKanji" method="get">
 			<fieldset>
  				<legend>Learn Kanji</legend>
  				<table>
					<tr>
						<td>Level(EX: 1,2,5,7)</td>
					</tr>
					<tr>
						<td><input type="text" name="level"></td>
					</tr>
					<tr>
						<td><input type="submit" value="Learn"></td>
					</tr>
				</table>
 			</fieldset>
		</form>	
	</body>
</html>