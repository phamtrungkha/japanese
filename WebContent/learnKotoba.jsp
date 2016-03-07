<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">
<%@page import="core.com.util.Function"%>
<%@page import="java.util.Random"%>
<%@page import="core.com.ptk.entity.Kotoba"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
	<%
		String lesson = (String) request.getAttribute("lesson"); 
		ArrayList<Kotoba> kotobas = (ArrayList<Kotoba>) request.getAttribute("kotobas");
		String kotobasStr = (new Function()).tostring(kotobas);
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
		</style>
		<script type="text/javascript">
			var i;
			var kotoba1 = "<%=kotobasStr%>";
			var kotoba2 = kotoba1.split("^");
			var text = '';
			var block =  7;
			var kotobas = text.concat('{"kotobas":[');
			for	(i = 0; i < kotoba2.length/block; i++) {
				kotobas = kotobas.concat('{')
				
				kotobas = kotobas.concat('"id":"');
				kotobas = kotobas.concat(kotoba2[i*block+0]);
				kotobas = kotobas.concat('",');
				
				kotobas = kotobas.concat('"jp":"');
				kotobas = kotobas.concat(kotoba2[i*block+1]);
				kotobas = kotobas.concat('",');
				
				kotobas = kotobas.concat('"vn":"');
				kotobas = kotobas.concat(kotoba2[i*block+2]);
				kotobas = kotobas.concat('",');
				
				kotobas = kotobas.concat('"en":"');
				kotobas = kotobas.concat(kotoba2[i*block+3]);
				kotobas = kotobas.concat('",');
				
				kotobas = kotobas.concat('"typeword":"');
				kotobas = kotobas.concat(kotoba2[i*block+4]);
				kotobas = kotobas.concat('",');
				
				kotobas = kotobas.concat('"lesson":"');
				kotobas = kotobas.concat(kotoba2[i*block+5]);
				kotobas = kotobas.concat('",');
				
				kotobas = kotobas.concat('"ignore":"');
				kotobas = kotobas.concat(kotoba2[i*block+6]);
				kotobas = kotobas.concat('"');
				
				if (i == kotoba2.length/block-1)
					kotobas = kotobas.concat('}');
				else
					kotobas = kotobas.concat('},');
			}
			kotobas = kotobas.concat(']}');
			console.log("--------");
			console.log(kotobas);
			console.log("--------");
			
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
			if (!$('#typing').is(":checked")){
	    		$("#toLGInput").hide();
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
			
			var done = true;
			var index = Math.floor((Math.random() * obj.kotobas.length));
			
		    $("#next").click(function(e){
		    	
		    	if ($('#typing').is(":checked")){
			        $("#toLG").hide();
		    		$("#toLGInput").show();
		    	}
		    	else{
		    		nextWord();
		    		$("#ketqua").hide();
		    		$("#toLGInput").hide();
			        $("#toLG").toggle();
			        if ($('#toLG').is(":visible"))
			        	$("#typing").show();
			        else
			        	$("#typing").hide();
		    	}
	    	});

		    $('#toLGInput').bind("enterKey",function(e){
	    		$("#ketqua").show();
		    
		    	if($("#toLGInput").val().localeCompare(obj.kotobas[index].jp) == 0){
		    		$("#ketqua").text("True");
		    		done = true;
		    		nextWord();
		    	}
		    	else {
	    			alert(obj.kotobas[index].jp);
		    		$("#ketqua").text("False");
		    	}
		    });
	    	$('#toLGInput').keyup(function(e){
	    	    if(e.keyCode == 13)
	    	    {
	    	        $(this).trigger("enterKey");
	    	    }
	    	});
	    	
	    	$('#checkbox1').change(function() {
	            if($(this).is(":checked")) {
	                var returnVal = confirm("Are you sure?");
	                $(this).attr("checked", returnVal);
	            }
	            $('#textbox1').val($(this).is(':checked'));        
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
			  		<input type="text" id="toLGInput"/>			  		
			  	</div>
			  	<p id="ketqua"></p>
	</body>
</html>