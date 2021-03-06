<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<title>Haberler</title>
</head>
<body>
<div class="container">
	<h1>Haber Listesi</h1>
	
	<div class="row">
	<a href='<s:url value="/detail/1"></s:url>'>
		<img src='<s:url value="resources/1.jpg"></s:url>'  class="img-thumbnail">
		<br>Haber Detay -1
	</a>
	<a href='<s:url value="/detail/2"></s:url>'>
		<img src='<s:url value="resources/2.jpg"></s:url>'  class="img-thumbnail">
		<br>Haber Detay -2
	</a><a href='<s:url value="/detail/3"></s:url>'>
		<img src='<s:url value="resources/3.jpg"></s:url>'  class="img-thumbnail">
		<br>Haber Detay -3
	</a>
	</div>
</div>
</body>
</html>