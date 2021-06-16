<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Résultat</title>
</head>
<body>

	<h1>RESULTAT</h1>
	<br>
	<!-- resultat venant de la servlet -->
	
	
	<%
		
			String couleurChoisie = (String)session.getAttribute("couleurChoisie");
		
	%>
			<p>La couleur choisie est le : <%=couleurChoisie%></p> 
	
	<a href="<%=request.getContextPath()%>/ServletTraitement">Retour</a>

</body>
</html>