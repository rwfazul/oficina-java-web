
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
        <div class="row">
            <div class="jumbotron"><h2 class="text-center">Gerenciamento de livros</h2></div>

        </div>
        <div class="row">
            <div class="col-md-3 col-md-offset-1 well">
                <legend class="text-center">Cadastrar livro</legend>
                <form action="/inserirLivro" method="POST">
                    <div class="form-group">
                        <label class="control-label" for="nome">ISBN:</label>
                        <input type="text" name="isbn" required class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="nome">Título:</label>
                        <input type="text" name="titulo" required class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="nome">Autor:</label>
                        <input type="text" name="autor" required class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="nome">Editora:</label>
                        <input type="text" name="editora" required class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="nome">Ano:</label>
                        <input type="text" name="ano" required class="form-control"/>
                    </div>

                    <button type="submit" class="btn btn-success pull-right">Finalizar <span class="glyphicon glyphicon-ok"></span></button>
                </form>
            </div>
            <div class="col-md-6 col-md-offset-1 well">
                <legend class="text-center">Lista de livros</legend>
            </div>
        </div> 

        <!-- SCRIPT DATATABLE, PARA CONSTRUÇÃO DA TABELA DE LIVROS     
          <script>
        $(function () {
            $('#lista_livros').DataTable({
                "language": {
                    "sEmptyTable": "Nenhum livro cadastrado :(",
                    "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ eventos",
                    "sInfoEmpty": "Mostrando 0 até 0 de 0 eventos",
                    "sInfoFiltered": "(Filtrados de _MAX_ eventos)",
                    "sInfoPostFix": "",
                    "sInfoThousands": ".",
                    "sLengthMenu": "_MENU_ resultados por página",
                    "sLoadingRecords": "Carregando...",
                    "sProcessing": "Processando...",
                    "sZeroRecords": "Nenhum livro encontrado",
                    "sSearch": "Pesquisar",
                    "oPaginate": {
                        "sNext": "Próximo",
                        "sPrevious": "Anterior",
                        "sFirst": "Primeiro",
                        "sLast": "Último"
                    },
                    "oAria": {
                        "sSortAscending": ": Ordenar colunas de forma ascendente",
                        "sSortDescending": ": Ordenar colunas de forma descendente"
                    }
                }
            });
        });
    </script>  
        
        --> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="recursos/_bootstrap/js/bootstrap.min.js"></script>

    </body>
</html>
