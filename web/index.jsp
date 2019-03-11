<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensaje = "";
    if (request.getAttribute("mensaje") != null) {
        mensaje = (String) request.getAttribute("mensaje");
    }
%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, minimun-scale=1.0"/>
    <!-- <link rel="stylesheet" href="css/estilos.css"/> -->
    <link href="./css/icons.css" rel="stylesheet"/>
    <title>Sistema</title>
  </head>
  <body class="inicio">
    <header class="main-header">
      <div class="ed-container">
        <div class="ed-item"><img src="img/logo.png" class="logo"/></div>
      </div>
    </header>
    <main class="ed-container">
      <div class="ed-item">
        <h1>Ingresar</h1>
        <form class="login-form ed-container web-40" action="Autenticar" method="post">
          <div class="ed-item form-item">
            <label for="username">Usuario</label>
            <input type="text" name="usuario" id="usuario" class="input" autofocus autocomplete="off"/>
          </div>
          <div class="ed-item form-item">
            <label for="password">Contraseña</label>
            <input type="password" name="clave" id="clave" class="input"/>
          </div>
          <div class="ed-item form-item">
            <input type="submit" value="Ingresar"/>
          </div>
        </form>
        <div class="web-40"><%=mensaje%></div>
      </div>
    </main>
    <footer class="main-footer">
      <div class="ed-container">
        <div class="ed-item">
          <p>Caso Practico curso Bases de Datos</p>
        </div>
      </div>
    </footer>
    <script src="js/efectos.js"></script>
  </body>
</html>