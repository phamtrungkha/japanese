<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">
<%@page import="core.com.util.Function"%>
<%@page import="java.util.Random"%>
<%@page import="core.com.ptk.entity.Kanji"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
	<%
		//String level = (String) request.getAttribute("level"); 
		ArrayList<Kanji> kanjis = (ArrayList<Kanji>) request.getAttribute("kanjis");
		String kanjisStr = (new Function()).tostringKanji(kanjis);
		int size = kanjis.size();
		Random random = new Random();
		int index = 0;
		boolean isView = true;		
	%>

	<head>
		<title>Learn Vocabulary</title>
		<style>
		body {
		    background-color: #d0e4fe;
		    font-size: 30px;
		}
		
		h3 {
		    color: orange;
		    text-align: center;
		}
		
		#vietnamese {
		    font-family: "Times New Roman";
		    font-size: 30px;
			padding-left: 20px;
		}
		
		#japanese {
		    font-family: "Times New Roman";
		    font-size: 40px;
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
			var kanji1 = "<%=kanjisStr%>";
			var kanji2 = kanji1.split(",");
			var text = '';
			var block =  4;
			var kanjis = text.concat('{"kanjis":[');
			for	(i = 0; i < kanji2.length/block; i++) {
				kanjis = kanjis.concat('{')
				
				kanjis = kanjis.concat('"id":"');
				kanjis = kanjis.concat(kanji2[i*block+0]);
				kanjis = kanjis.concat('",');
				
				kanjis = kanjis.concat('"jp":"');
				kanjis = kanjis.concat(kanji2[i*block+1]);
				kanjis = kanjis.concat('",');
				
				kanjis = kanjis.concat('"vn":"');
				kanjis = kanjis.concat(kanji2[i*block+2]);
				kanjis = kanjis.concat('",');
				
				kanjis = kanjis.concat('"ignoreword":"');
				kanjis = kanjis.concat('false');
				kanjis = kanjis.concat('"');
				
				if (i == kanji2.length/block-1)
					kanjis = kanjis.concat('}');
				else
					kanjis = kanjis.concat('},');
			}
			kanjis = kanjis.concat(']}');
			console.log("--------");
			console.log(kanjis);
			console.log("--------");
			
			obj = JSON.parse(kanjis);
			console.log("++++++++++");
			console.log(obj);
			console.log("++++++++++");
		</script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		<script>
		$(document).ready(function(){
			var done = true;
			var index = Math.floor((Math.random() * obj.kanjis.length));
		    $("#next").click(function(){
		    	if ($('#ignorethisword').is(":checked")){
	    			obj.kanjis[index].ignoreword = "true";
	    			$('#ignorethisword').prop('checked', false);
    				//alert("kkkkkkkkkkkk");
	    		}
		    	if (done){
		    		index = Math.floor((Math.random() * obj.kanjis.length));
		    		if ($('#ignore').is(":checked")){
		    			var k = true;
		    			while (k){
		    				if (obj.kanjis[index].ignoreword.localeCompare("true") == 0)
		    					index = Math.floor((Math.random() * obj.kanjis.length));
		    				else
		    					k = false;
		    			}
		    		}
		    		$("#vietnamese").text(obj.kanjis[index].vn);
		    		$("#japanese").text(obj.kanjis[index].jp);
		    	}
		        $("#jp").toggle();
		        done = !done;
		        //alert($('#ignorethisword').is(":checked"));
		    });
		});
		</script>
	</head>
	<body>
		<input type="hidden" id="isView" value=<%=(new Random()).nextInt(10) %>>
		<h3>Learn Vocabulary</h3>
		
			<fieldset>
			  	<legend>Option</legend>
			  	<table id = "option">
			  		<tr>
			  			<td>		</td>
			  			<td><input type="checkbox" id="ignore" checked="checked"/> Ignore</td>
			  			<td><input type="checkbox" name="typing"/> Typing</td>
			  		</tr>
			  		
				</table>
			</fieldset>
			<fieldset>
			  	<legend>Learning</legend>
					  	
					  	<button id="next">Next</button>
		  				<div>
				  			<p id="vietnamese">vietnamese</p>
				  		</div>
				  		<div id="jp">
					  		<p id="japanese" >japanese</p>
			  				<input type="checkbox" id="ignorethisword" /> Ignore this word.
					  	</div>

			</fieldset>
			<tr>
				<td></td>
				<td></td>
			</tr>
	</body>
</html>