<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastrar Pais</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegacap -->
	<c:import url="Menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Incluir Pais</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="ManterPais.do" method="get">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="15" placeholder="Nome do Pais">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="fone">Area</label>
                    <input type="number" class="form-control" name="area" id="area" maxlength="15" placeholder="Digite a area total do Pais em KM">
                </div>

                <div class="form-group col-md-6">
                    <label for="email">Populacao</label>
                    <input type="number" class="form-control" name="populacao" id="populacao" required maxlength="60" placeholder="Digite o numero de habitantes">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="PaisCadastro">Salvar</button>
                    <a href="ListarPais.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>