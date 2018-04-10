<%-- 
    Document   : index
    Created on : Sep 5, 2017, 6:17:19 PM
    Author     : rhau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Oficina</title>
        <link rel="stylesheet" href="recursos/_bootstrap/css/bootstrap.min.css">
    </head>
    <body> 
        
        <div class="container">
            <div class="row"> 
                <div class="col-md-6 col-md-offset-3">
                <h1 class="text-center">Sistema de Login</h1>

                <form action="usuarioInserir" method="post">
                    <div class="form-group">
                        <label for="login">Login</label>
                        <input type="text" id="login" name="login" placeholder="Digite o login" class="form-control" required/>
                    </div>
                    <div class="form-group">
                        <label for="senha">Senha</label>
                        <input type="password" id="senha" name="senha" placeholder="Digite a senha" class="form-control" required/>
                    </div>
                    <button type="submit" class="btn btn-default btn-primary btn-submit pull-left">Fazer login</button>
                </form>     
                <br/>
                <c:if test="${not empty msg}">
                    <div class="alert alert-danger alert-dismissible fade in">  
                        <button class="close" data-dismiss="alert">&times;</button>
                        <p>${msg}</p>
                    </div> 
                    <c:remove var="msg"/> 
                </c:if>

            </div> <!-- ./col --> 
            </div> <!-- ./row -->
        </div> <!-- ./container -->
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="recursos/_bootstrap/js/bootstrap.min.js"></script>

    </body>
</html>
