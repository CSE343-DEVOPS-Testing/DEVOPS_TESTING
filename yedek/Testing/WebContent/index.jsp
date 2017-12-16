<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testing</title>

<%
	List<String> classNames = (List<String> )request.getAttribute("mymessage");
	

%>

<script type="text/javascript"> 
	function getSelectedClass(){
		
		var selectedValue = document.getElementById("class").value;
		
		if(selectedValue == '1'){
			document.getElementById("func").style.display = "block";
			document.getElementById("label2").style.display = "block";
			var optionArray = "<option value='0'> </option>";
			optionArray += "<option value='1'> class1-func1 </option>";
			optionArray += "<option value='2'> class1-func2 </option>";
			optionArray += "<option value='3'> class1-func3 </option>";
			
			document.getElementById('func').innerHTML = optionArray
		}
		else if(selectedValue == '2'){
			document.getElementById("func").style.display = "block";
			document.getElementById("label2").style.display = "block";
			var optionArray = "<option value='0'> </option>";
			optionArray += "<option value='1'> class2-fucn1 </option>";
			optionArray += "<option value='2'> class2-fucn2 </option>";
			optionArray += "<option value='3'> class3-fucn3 </option>";
			
			document.getElementById('func').innerHTML = optionArray
		}
		else if(selectedValue == '3'){
			document.getElementById("func").style.display = "block";
			document.getElementById("label2").style.display = "block";
			var optionArray = "<option value='0'> </option>";
			optionArray += "<option value='1'> class3-func1 </option>";
			optionArray += "<option value='2'> class3-fucn2 </option>";
			optionArray += "<option value='3'> class3-fucn3 </option>";
			
			document.getElementById('func').innerHTML = optionArray
		}
		return selectedValue;
	}
	function getSelectedFunc(){
		document.getElementById("table").style.display = "block";
	}
</script>

</head>
<body style ="background: LightSkyBlue" >
	<form action="TestServlet" method="post">
		<fieldset>
			<h2> Testing Group </h2 >
			<hr />
			<label  style = "margin-right:162px" >Class Name : </label><br><select id="class" name = "className" onchange="getSelectedClass();" style="width:125px;">
				<option value="0"> </option>
				<%
        			for(int i=0;i<classNames.size();++i){
         				 %>
           					 <option value="<%=i+1%>"><%=classNames.get(i) %></option>          
         				 <% 
        			}
      			%>
			</select>
			
			<hr />
			<label  style="width:250px; display:none;" id="label2">Function Name:</label>
			<select id="func"  name = "funcName"  style="display:none" onchange="getSelectedFunc();">
 
			</select>
			<hr />
			<table style = "display:none;"  id="table" align ="center">
			<tbody>
				<tr>
					<td >Parameters:</td>
					<td><input type ="text" name="parameters" value = "" size=50/></td>
					<td >Delimiter:</td>
					<td	><input type ="text" name="separator" value = "" size=10/></td>
				</tr>
				<tr>
					<td>Expected Value:</td>
					<td><input type ="text" name="expectedValue" value = "" size=50/></td>
				</tr>
				<tr>
					<td>
						<input style = "margin-right:135px;display:block;" type ="submit" name="test" value = "Test!" id="TestButton"/>
					</td>
					<td>
						<input style = "margin-left:0px;display:block;" type ="submit" name="clear" value = "Clear!" id ="ClearButton"/>
					</td>
				</tr>
			</tbody>
		</table>
		
		</fieldset>
	</form>
</body>
</html>