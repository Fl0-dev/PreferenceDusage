<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
</head>
<body>
	<h1>ACCUEIL</h1>
	<br>

	<%
		String couleur1 = application.getInitParameter("NOIR");
		String couleur2 = application.getInitParameter("BLEU");
		String couleur3 = application.getInitParameter("ROUGE");
		String couleur4 = application.getInitParameter("VERT");
	%>

	<form action="<%=response.encodeURL(request.getContextPath()+"/ServletTraitement")%>"
		method="POST">

		<select name="choix">
			<option value="<%=couleur1%>"><%=couleur1%></option>
			<option value="<%=couleur2%>"><%=couleur2%></option>
			<option value="<%=couleur3%>"><%=couleur3%></option>
			<option value="<%=couleur4%>"><%=couleur4%></option>
		</select> <input type="submit" value="Valider">
	</form>
	<br>


	

	<p>
		Vous êtes venu <%=request.getAttribute("compteurAcces")%> fois
	</p>
	<br>
	<a href="<%=response.encodeURL(request.getContextPath() + "/resultat") %>">Voir résultat</a>

</body>
</html>