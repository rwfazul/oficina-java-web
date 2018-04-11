<%-- 
    Document   : dashboard
    Created on : Sep 6, 2017, 3:50:26 PM
    Author     : rhau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link rel="stylesheet" href="recursos/_bootstrap/css/bootstrap.min.css">
    </head>
    <body>
  
        <div class="jumbotron text-center">
            <h1>Hello World!</h1>        
            <h2>Bem vindo(a) ${usuarioLogado.login}</h2>
            <h3><a href="meus-livros">Gerenciar livros</a></h3>
        </div>
                
    </body>
</html>
