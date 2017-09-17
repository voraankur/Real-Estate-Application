<html>
<body>
<table>
	<tr>
		<th>Username </th> <th>Password</th>
	</tr>
	<#list users as user>
	<tr>
		<td>${user.username}</td> <td>${user.password}</td>
	</tr>
	</#list>
</table>	
</body>
</html>