<!DOCTYPE html>
<html>
<head>
<title>PredictPok 0.1</title>
<meta charset="utf-8" />
<link rel="stylesheet" type="text/css" href="styles.css">
<script src="http://maps.googleapis.com/maps/api/js"></script>
<script type="text/javascript" src="maps.js"></script>
<script type="text/javascript" src="validaAjax.js"></script>
</head>

<body>
  <div id="wrapper">

    <header><!--****************************Cabecera*************************************-->
      <div id="logo">
        <img src="images/PredictPok.png" alt="Logotipo de PredictPok" />   
      </div>
      <!--<div id="cabecera">
        <h1>Seguimiento de jugadores Poker Texas Holdem</h1>
        <p>Sistema de Predicción PredictPok</p>
      </div>-->
      <div class="clearfix"></div>
    </header>
    

    <div id="explicacion"><!--****************Explicacion*******************************-->
      <div class="explicacion_seccion">
        <h2>Explicación</h2>
        <p>
              PredictPok es un sistema de seguimiento personalizado de jugadores de Poker Texas Holdem.
              Mediante este seguimiento se intentará crear un perfil de juego para posteriormente realizar
              predicciones en tiempo real de las posibles jugadas. Si no sabes jugar puedes mirar este
              <a class="aviso" href="http://www.manualpoker.net">manual</a>.
        </p>
      </div>
      <div class="explicacion_seccion">
        <h2>Datos a facilitar:</h2>
        <p>
             Para cada tipo de jugada se deben proporcionar una serie de datos que el sistema guardará en un base
             de datos para su posterior análisis. Para que éstos datos sean fiables se deberían insertar respecto de 
             un jugador real en una partida real, a partir de sus movimientos.
        </p>
      </div>
      <div class="explicacion_seccion">
        <h2>Sistema de predicción:</h2>
        <p>
              El sistema analiza los datos de cada jugador en concreto mediante un algoritmo de predicción. 
              Este algoritmo es más fiable y predice mejor a medida que el número de datos que se obtienen 
              de un jugador aumenta. 

        </p>
      </div>
      <div class="clearfix"></div>
    </div><!--explicacion-->


    <form id="formulario" action="insertarDatos.php" method="POST">
        <div id="jugador" class="textcenter">
            <label for="jugador">JUGADOR</label><br /><br />
            <input type="text" name="jugador" id="formJugador" />
        </div>
        <div id="preflop"><!--*****************************preflop*******************************-->
          <h1 class="textcenter">PREFLOP</h1><hr/>
          <p>Estos son los datos del juego antes de salir el flop.</p>
          <div id="datosPreflop">
            
          </div>
          <div id="previsionPreflop">
            
          </div>
        </div><!--preflop-->
        <div class="clearfix"></div>
        <div id="flop"><!--*****************************flop*******************************-->
          <h1 class="textcenter">FLOP</h1><hr/>
          <p>Estos son los datos del juego tras salir el flop.</p>
          <div id="datosFlop">
            
          </div>
          <div id="previsionFlop">
            
          </div>
        </div><!--flop-->
        <div class="clearfix"></div>
        <div id="turn"><!--*****************************turn*******************************-->
          <h1 class="textcenter">TURN</h1><hr/>
          <p>Estos son los datos del juego tras salir el turn.</p>
          <div id="datosTurn">
            
          </div>
          <div id="previsionTurn">
            
          </div>
        </div><!--turn-->
        <div class="clearfix"></div>
        <div id="river"><!--*****************************river*******************************-->
          <h1 class="textcenter">RIVER</h1><hr/>
          <p>Estos son los datos del juego tras salir el river.</p>
          <div id="datosRiver">
            
          </div>
          <div id="previsionRiver">
            
          </div>
        </div><!--river-->
        <div class="clearfix"></div>
    </form>

    <footer><!--*****************************footer*******************************-->
      <p>Development by Carlos J. Casares Barrio - Álvaro Gutiérrez Ollé</p>
      <p>Asignatura de Ingeniería del Software 2 - Grado en Ingeniería Informática.</p>
      <p>Universidad de León</p>
    </footer>
</div><!-- wrapper-->
</body>

</html>