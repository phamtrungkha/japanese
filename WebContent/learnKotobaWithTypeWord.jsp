<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">
<%@page import="core.com.util.Function"%>
<%@page import="java.util.Random"%>
<%@page import="core.com.ptk.entity.Kotoba"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
	<%
		ArrayList<Kotoba> kotobas = (ArrayList<Kotoba>) request.getAttribute("kotobas");
		String kotobasStr = (new Function()).toJSONKotoba(kotobas);
		int size = kotobas.size();
		Random random = new Random();
		int index = 0;
		boolean isView = true;		
	%>

	<head>
		<title>Learn Vocabulary</title>
		<style>
		body {
		    background-color: #d0e4fe;
		}
		</style>
		<script type="text/javascript">
			var kotobas = "<%=kotobasStr%>";
			obj = JSON.parse(kotobas);
			console.log("++++++++++");
			console.log(obj);
			console.log("++++++++++");
		</script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script>
		$(document).ready(function(){
			var scope = 0;
			var start = 0;
			var end = <%=size%>-1;
			var remainWord = <%=size%>;
			var i = 0;
			var done = true;
			var index = Math.floor((Math.random() * obj.kotobas.length));
        	$("#answer").hide();
			if (!$('#typing').is(":checked")){
	    		$("#toLGInput").hide();
	    		nextWord();
				done = true;
	    	}
			$("#group").change(function() {
				$("#group option:selected").each(function() {
					scope = $(this).val();
					for (i = 0; i < <%=size%>; i++){
						obj.kotobas[i].ignore = "false";
					}
					if (scope == <%=size%>){
						start = 0;
						end = scope-1;
						remainWord = <%=size%>;
					}
					else if (scope == <%=size/25%>){
						start = scope*25;
						end = <%=size%>-1;
						remainWord = <%=size%> - scope*25;
					}
					else {
						start = scope*25;
						end = start + 24;
						remainWord = 25;
					}
					$("#remainWord").text(remainWord);
			    });
			  });
			
			
		    $("#next").click(function(e){
		    	
		    	if (!$('#typing').is(":checked")){
		    		nextWord();
			        $("#toLG").toggle();
		    	}
	    	});

		    $('#toLGInput').bind("enterKey",function(e){
	    		$("#ketqua").show();
		    	if($("#toLGInput").val().localeCompare($("#toLG").text()) == 0){
	            	$("#answer").hide();
		    		$("#ketqua").text("True");
		    		nextWord();
		    		done = true;
		    	}
		    	else {
		    		$("#ketqua").text("False");
		    		$('#toLGInput').val("");
	            	$("#answer").show();
		    	}
		    });
	    	$('#toLGInput').keyup(function(e){
	    	    if(e.keyCode == 16)
	    	    {
	    	        $(this).trigger("enterKey");
	    	    }
	    	});
	    	
			$("#answer").click(function(e){
    			alert($("#toLG").text());
	    	});
	    	
	    	$('#typing').change(function() {
            	$("#answer").hide();
	            if($(this).is(":checked")) {
	            	$("#toLGInput").show();
		    		$("#ketqua").show();
	            	$("#toLG").hide();
	            	$("#next").hide();
		    		done = true;
		    		nextWord();
	            }
	            else{
	            	$("#toLGInput").hide();
		    		$("#ketqua").hide();
	            	$("#toLG").show();
	            	$("#next").show();
	            }
	        });
	    	
	    	function nextWord(){
		    	if ($('#ignorethisword').is(":checked")){
	    			obj.kotobas[index].ignore = "true";
	    			$('#ignorethisword').prop('checked', false);
	    			remainWord--;
	    		}
		    	if (done){
		    		index = start + Math.floor((Math.random() * (end - start +1)));
		    		if ($('#ignore').is(":checked")){
		    			var k = true;
		    			while (k){
		    				if (remainWord == 1){
		    					for (i = start; i <= end; i++){
		    						obj.kotobas[i].ignore = "false";
		    					}
		    					remainWord = end-start+1;
		    				}
		    				else if (obj.kotobas[index].ignore.localeCompare("true") == 0)
		    					index = start + Math.floor((Math.random() * (end - start +1)));
		    				else
		    					k = false;
		    			}
		    		}
		    		if ($("#from option:selected").val().localeCompare("vn") == 0){
		    			$("#fromLG").text(obj.kotobas[index].vn);
			    		$("#toLG").text(obj.kotobas[index].jp);
		    		}
		    		else {
		    			$("#fromLG").text(obj.kotobas[index].jp);
			    		$("#toLG").text(obj.kotobas[index].vn);
		    		}
		    	}
		    	$("#toLGInput").val("");
			    $("#remainWord").text(remainWord);
		        done = !done;
		    }
		});
		</script>
	</head>
	<body>
		<input type="hidden" id="isView" value=<%=(new Random()).nextInt(10) %>>
		<h3>Learn Vocabulary</h3>
				<table>
			  		<tr>
			  			<td>Option: </td>
			  			<td><input type="checkbox" id="ignore" checked="checked"/> Ignore</td>
			  		</tr>
			  		<tr>
			  			<td></td>
			  			<td><input type="checkbox" id="typing"/> Typing</td>
			  		</tr>
			  		<tr>
					  	<td>Learning:</td>
					  	<td>
						  	<select id="group" name="group">
						  		<option value="<%=size%>">all</option>
				  			<%
				  				for (int i = 0; i < size/25; i++){%>
				  					<option value="<%=i%>"><%=i*25 %> - <%=i*25+24 %></option>
				  			<%	}%>
				  				<option value="<%=size/25%>"><%=size/25*25 %> - <%=size-1 %></option>
							</select><br/>
						</td>
					</tr>
					<tr>
					  	<td>From: </td>
					  	<td>
						  	<select id="from">
						  		<option value="vn" selected="selected">Vietnamese</option>
						  		<option value="jp">Japanese</option>
							</select><br/>
						</td>
					</tr>
					<tr>
					  	<td>To: </td>
					  	<td>
						  	<select id="to">
						  		<option value="jp" selected="selected">Japanese</option>
						  		<option value="vn">Vietnamese</option>
							</select><br/>
						</td>
					</tr>
				</table>
			  	Remain word: <label id="remainWord"><%=size %></label><br/>
			  	<button id="next">Next</button><input type="checkbox" id="ignorethisword" /> <label for="ignorethisword">Ignore this word.</label>
  				<br/><br/><div id="fromLG">From languge
		  		</div>
		  		<div>
			  		<p id="toLG" >To languge</p><br/>
			  	</div>
			  	<div>
			  		<input type="text" id="toLGInput"/><button id="answer">Answer</button>			  		
			  	</div>
			  	<p id="ketqua"></p>
	</body>
</html>