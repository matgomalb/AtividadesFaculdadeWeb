<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>cerveja.biz - Cadastro de País</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
  </head>
  <body>
  	<c:import url="Menu.jsp"/>
    <!-- Barra superior com os menus de navegaÃ§Ã£o -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">País</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.html">Paises</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Cadastro de País</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="Pais.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome">País</label>
                    <input type="text" class="form-control" name="pais" id="pais" required maxlength="100" placeholder="nome pais">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="number">População</label>
                    <input type="number" class="form-control" name="populacao" id="populacao" placeholder="populacao">
                </div>

                <div class="form-group col-md-6">
                    <label for="number">Area</label>
                    <input type="number" class="form-control" name="area" id="area" required placeholder="area">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" value="Criar">Salvar</button>
                    <a href="index.html" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>