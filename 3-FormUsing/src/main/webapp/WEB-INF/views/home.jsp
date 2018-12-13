<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>Form Using</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-sm-6">
			<h1>User Insert</h1>
			
			<c:if test="${ not empty hata }">
				<div class="alert alert-danger alert-dismissible fade show" role="alert">
				  <strong>Hata !</strong> ${hata }
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>
			</c:if>
			
			<form action='<s:url value="/userInsert"></s:url>' method="post">
			<div class="form-group">
			    <input name="name" type="text" class="form-control"  placeholder="Enter name">
			  </div>
			  <div class="form-group">
			    <input name="surname" type="text" class="form-control"  placeholder="Enter surname">
			  </div>
			  <div class="form-group">
			    <input name="mail" type="email" class="form-control"  placeholder="Enter email">
			  </div>
			  <div class="form-group">
			    <input name="pass" type="password" class="form-control" placeholder="Enter pass">
			  </div>
			  
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
		<div class="col-sm-6">
			<h1>User List</h1>
			<table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">name</th>
			      <th scope="col">surname</th>
			      <th scope="col">mail</th>
			      <th scope="col">pass</th>
			    </tr>
			  </thead>
			  <tbody>
			  
			  <c:if test="${ not empty data }">
			  	<c:forEach var="item" items="${data }">
			  
			    <tr>
			      <th>${ item.name }</th>
			      <td>${ item.surname }</td>
			      <td>${ item.mail }</td>
			      <td>${ item.pass }</td>
			    </tr>
			    
			    </c:forEach>
			  </c:if>
			    
			    
			    
			  </tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>