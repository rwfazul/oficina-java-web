<%-- 
    Document   : index
    Created on : Apr 10, 2018, 6:17:19 PM
    Author     : Isabella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Meus livros</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/_bootstrap/css/bootstrap.min.css">
</head>
<body> 
        
    <div class="container">
        <div class="row" style="background-color: #EEE; padding: 10px; margin: 30px;">
            <h2 class="text-center">Gerenciamento de livros</h2>
        </div>
    </div>
        
    <div class="container">
    <div class="row">
    <div class="col-md-3 col-md-offset-1 well">
            
<c:choose>
    <c:when test="${not empty livroBusca}">
        <legend class="text-center">Alterar livro</legend>
        <form action="${pageContext.request.contextPath}/alterarLivro" method="POST">
    </c:when>
    <c:otherwise>
        <legend class="text-center">Cadastrar livro</legend>
        <form action="inserirLivro" method="POST">       
    </c:otherwise>        
</c:choose>
            <div class="form-group">
                <label class="control-label" for="isbn">ISBN</label>
                <input type="number" class="form-control" name="isbn" value="${livroBusca.isbn}" <c:if test="${not empty livroBusca}"> readonly="readonly"</c:if> required />
            </div>
            <div class="form-group">
                <label class="control-label" for="titulo">Título</label>
                <input type="text" class="form-control" name="titulo"  value="${livroBusca.titulo}" required />
            </div>
            <div class="form-group">
                <label class="control-label" for="autor">Autor:</label>
                <input type="text" class="form-control" name="autor" value="${livroBusca.autor}" required />
            </div>
            <div class="form-group">
                <label class="control-label" for="editora">Editora:</label>
                <input type="text" class="form-control" name="editora" value="${livroBusca.editora}" required />
            </div>
            <div class="form-group">
                <label class="control-label" for="ano">Ano:</label>
                <input type="number" class="form-control" name="ano" value="${livroBusca.ano}" required />
            </div>
            <button type="submit" class="btn btn-success pull-right">Finalizar <span class="glyphicon glyphicon-ok"></span></button>
        </form>
    </div> <!-- ./col -->
        
    <div class="col-md-6 col-md-offset-1 well">
        <legend class="text-center">Lista de livros</legend>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ISBN</th>
                        <th>Título</th>
                        <th>Autor</th>
                        <th>Editora</th>
                        <th>Ano</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="l" items="${livros}">
                        <tr>
                            <td>${l.isbn}</td>
                            <td>${l.titulo}</td>
                            <td>${l.autor}</td>
                            <td>${l.editora}</td>
                            <td>${l.ano}</td>
                            <td>
                                <a href="buscarLivro/${l.isbn}" class="btn btn-warning">Alterar</a>
                                <a href="excluirLivro/${l.isbn}" class="btn btn-danger">Excluir</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div> <!-- ./table-responsive -->
    </div> <!-- ./col -->
    
    </div> <!-- ./row -->
    </div> <!-- ./container -->   
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/recursos/_bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
