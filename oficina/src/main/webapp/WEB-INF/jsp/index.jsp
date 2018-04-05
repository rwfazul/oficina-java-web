<%-- 
    Document   : index
    Created on : Apr 5, 2018, 7:01:58 PM
    Author     : rhau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="recursos/_bootstrap/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h1 class="text-center">Sistema de Login</h1>
                    
                    <form action="usuarioLogar" method="post">
                        <div class="form-group">
                            <label>Login</label>
                            <input type="text" id="login" name="login" class="form-control" required> 
                        </div>
                        <div class="form-group">
                            <label>Senha</label>
                            <input type="password" id="senha" name="senha" class="form-control" required> 
                        </div>
                        <button type="submit" class="btn btn-primary btn-submit">
                            Fazer login
                        </button>
                    </form>
                    <c:if test="${not empty msg}">
                        <div class="alert alert-danger alert-dismissable fade in">
                            <button class="close" data-dismiss="alert">
                                &times;
                            </button>
                            <p>${msg}</p>
                        </div>
                            <c:remove var="msg"/>
                    </c:if>    
                    
                </div>
            </div>
        </div>
    </body>
</html>
