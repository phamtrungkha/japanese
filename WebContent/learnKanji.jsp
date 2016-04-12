<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">
<%@page import="core.com.util.Function"%>
<%@page import="java.util.Random"%>
<%@page import="core.com.ptk.entity.Kanji"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
	<%
		//String level = (String) request.getAttribute("level"); 
		final int BLOCK = 50;
		ArrayList<Kanji> kanjis = (ArrayList<Kanji>) request.getAttribute("kanjis");
		String kanjisStr = (new Function()).toJSONKanji(kanjis);
		int size = kanjis.size();
		Random random = new Random();
		int index = 0;
		boolean isView = true;		
	%>

	<head>
		<title>Learn Kanji</title>
		<style>
		body {
		    background-color: #d0e4fe;
		    font-size: 20px;
		}
		
		h3 {
		    color: orange;
		    text-align: center;
		}
		
		#vietnamese {
		    font-family: "Times New Roman";
		    font-size: 20px;
			padding-left: 20px;
		}
		
		#japanese {
		    font-family: "Times New Roman";
		    font-size: 20px;
			padding-left: 20px;
		}
		
		#ignorethisword {
		    font-family: "Times New Roman";
		    font-size: 10px;
			padding-left: 20px;
		}
		#option {
			padding-left: 20px;
		}
		#fromLG {
			font-size: 50px;
		}
		</style>
		<script type="text/javascript">
			var kanjis = "<%=kanjisStr%>";
			obj = JSON.parse(kanjis);
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
			var index = Math.floor((Math.random() * obj.kanjis.length));
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
						obj.kanjis[i].ignore = "false";
					}
					if (scope == <%=size%>){
						start = 0;
						end = scope-1;
						remainWord = <%=size%>;
					}
					else if (scope == <%=size/BLOCK%>){
						start = scope*<%=BLOCK%>;
						end = <%=size%>-1;
						remainWord = <%=size%> - scope*<%=BLOCK%>;
					}
					else {
						start = scope*<%=BLOCK%>;
						end = start + <%=BLOCK-1%>;
						remainWord = <%=BLOCK%>;
					}
					$("#remainWord").text(remainWord);
			    });
			  });
			
			
		    $("#next").click(function(e){
		    	
		    	if (!$('#typing').is(":checked")){
		    		nextWord();
			        $("#toLG").toggle();
			        $("#toLG2").toggle();
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
	            	$("#toLG2").hide();
	            	$("#next").hide();
		    		done = true;
		    		nextWord();
	            }
	            else{
	            	$("#toLGInput").hide();
		    		$("#ketqua").hide();
	            	$("#toLG").show();
	            	$("#toLG2").show();
	            	$("#next").show();
	            }
	        });
	    	
	    	function nextWord(){
		    	if ($('#ignorethisword').is(":checked")){
	    			obj.kanjis[index].ignore = "true";
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
		    						obj.kanjis[i].ignore = "false";
		    					}
		    					remainWord = end-start+1;
		    				}
		    				else if (obj.kanjis[index].ignore.localeCompare("true") == 0)
		    					index = start + Math.floor((Math.random() * (end - start +1)));
		    				else
		    					k = false;
		    			}
		    		}
		    		if ($("#from option:selected").val().localeCompare("kanji") == 0){
		    			$("#fromLG").text(obj.kanjis[index].kanji);
			    		$("#toLG").text(obj.kanjis[index].jp);
			    		$("#toLG2").text(obj.kanjis[index].vn);
		    		}
		    		else {
		    			$("#fromLG").text(obj.kanjis[index].jp);
			    		$("#toLG").text(obj.kanjis[index].kanji);
			    		$("#toLG2").text(obj.kanjis[index].vn);
		    		}
		    		
		    	}
		    	$("#toLGInput").val("");
			    $("#remainWord").text(remainWord);
		        done = !done;
		    }
		});
		</script>
		<script>
		
	    
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
				  				for (int i = 0; i < size/BLOCK; i++){%>
				  					<option value="<%=i%>"><%=i*BLOCK %> - <%=i*BLOCK+(BLOCK-1) %></option>
				  			<%	}%>
				  				<option value="<%=size/BLOCK%>"><%=size/BLOCK*BLOCK %> - <%=size-1 %></option>
							</select><br/>
						</td>
					</tr>
					<tr>
					  	<td>From: </td>
					  	<td>
						  	<select id="from">
						  		<option value="kanji" selected="selected">Kanji</option>
						  		<option value="jp">Japanese</option>
							</select><br/>
						</td>
					</tr>
					<tr>
					  	<td>To: </td>
					  	<td>
						  	<select id="to">
						  		<option value="jp" selected="selected">Japanese</option>
						  		<option value="kanji">Kanji</option>
							</select><br/>
						</td>
					</tr>
				</table>
			  	Remain word: <label id="remainWord"><%=size %></label><br/>
			  	<button id="next">Next</button><input type="checkbox" id="ignorethisword" /> <label for="ignorethisword">Ignore this word.</label>
  				<br/><br/><div id="fromLG">From languge
		  		</div>
		  		<div >
			  		<p id="toLG" >To languge</p>
			  	</div>
		  		<div>
			  		<p id="toLG2" >To languge2</p><br/>
			  	</div>
			  	<div>
			  		<input type="text" id="toLGInput"/><button id="answer">Answer</button>			  		
			  	</div>
			  	<p id="ketqua"></p>
	</body>
</html>