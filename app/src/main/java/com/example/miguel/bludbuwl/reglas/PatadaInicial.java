package com.example.miguel.bludbuwl.reglas;

public enum PatadaInicial {

    APORELARBITRO("A por el árbitro","Los hinchas se vengan del árbitro por una decisión dudosa  tomada  indistintamente durante el  partido  o  en  un  pasado.  Su  sustituto  está demasiado  intimidado, así que durante el  resto de  la parte  no  expulsará  a  ningún  jugador  de  ambos equipos por realizar faltas o usar armas secretas."),
    DISTURBIOS("Disturbios","Una  discusión  entre  dos  jugadores degenera  rápidamente en una pelea,  involucrando al resto de jugadores. Tira un D6. Con un 1-3, el árbitro ha conseguido controlar el  tiempo perdido durante  la pelea;  el  marcador  del  turno  de  ambos  jugadores tendrá  que  desplazarse  hacia  delante  tantos  turnos como haya indicado el dado. Si así se llega al turno 8 o más de ambos jugadores, la parte concluye. Con un 4-6,  el  árbitro  retrasa  el  reloj  hasta  antes  de  que comenzase la pelea, así que ambos jugadores deben mover su marcador de  turno un  turno hacia atrás. El marcador  del  turno no podrá moverse más  atrás  del turno  1;  si  esto  sucediera,  no  se  debe  mover  el marcador."),
    DEFENSAPERFECTA("Defensa  perfecta","El  entrenador  del  equipo  lanzador puede reorganizar el despliegue de sus jugadores. Es decir,  puede  situarlos  de  nuevo  sobre  el  terreno  de juego, siempre que el nuevo despliegue sea legal. Los jugadores  del equipo  receptor  deben  permanecer en la posición en que estaban."),
    PATADAALTA("Patada  alta","El  balón  ha  sido  pateado  muy  alto, permitiendo a un jugador del equipo receptor moverse a  la  posición  perfecta  para  recibirlo.  Un  jugador cualquiera del equipo receptor que no esté en la zona de defensa de un jugador contrario podrá situarse en la  casilla  donde  vaya  a  aterrizar  el  balón, independientemente  de  su  MO,  siempre  que  esta casilla esté vacía."),
    LOSHINCHASANIMAN("Los  Hinchas  Animan:","Cada  entrenador  tira  un D3  y  añade  su  FAMA  y  el  número  de Animadoras  de  su  equipo al resultado. El equipo con mayor  resultado  recibe una  segunda  oportunidad adicional  durante  esta parte  animado  por  los vítores de sus hinchas. Si ambos jugadores obtienen el  mismo  resultado, ambos  reciben  una segunda oportunidad."),
    TIEMPOVARIABLE("Tiempo  variable","Vuelve  a  tirar  en  la  Tabla  de tiempo.  Aplica  el  nuevo  resultado.  Si  el nuevo  resultado  es  “Día  perfecto”,  entonces  una suave brisa hace que la pelota se desvíe una casilla adicional  en  una  dirección  aleatoria  antes  de aterrizar."),
    TACTICABRILLANTE("Táctica brillante","Cada entrenador tira un D3, añade su  FAMA y  el  número  de  ayudantes  de entrenador al  resultado. El equipo con el  total más alto recibe una segunda oportunidad adicional para esta  parte  gracias  a  las  brillantes  instrucciones dadas por su equipo técnico. Si el total es el mismo, ambos equipos reciben una segunda oportunidad."),
    ANTICIPACION("Anticipación","El equipo receptor empieza a avanzar una  fracción  de  segundo  antes  de  que  el  equipo lanzador  esté  preparado.  Todos  los  jugadores  del equipo  receptor  pueden  mover  una  casilla.  Este movimiento  es  gratuito  e  ignora  las  zonas  de defensa. Puede emplearse para entrar  en  la mitad del campo contrario.  "),
    PENETRACION("¡Penetración!","El  equipo  lanzador  comienza  a avanzar  una  fracción  de  segundo  antes  de  que  el equipo  receptor  esté  preparado,  cogiendo desprevenido al equipo receptor. El equipo lanzador recibe un  turno  “adicional” de manera gratuita. Sin embargo,  los  jugadores que se encuentren en una zona  de  defensa  contraria  al  inicio  de  este  turno adicional  no  podrán  realizar  ninguna  acción.  El equipo  lanzador  puede  utilizar  segundas oportunidades de equipo durante la Penetración. Si cualquier jugador provoca un cambio de turno, este turno adicional terminará inmediatamente."),
    PEDRADA("Pedrada","Un enfurecido hincha lanza una gran roca a uno de  los  jugadores del equipo contrario. Cada entrenador tira un D6 y añade su FAMA al resultado.  Los  hinchas  del  equipo  que  obtenga  el total  más  alto  serán  los  que  lancen  la  roca.  ¡En caso  de  empate  lanzarán  una  roca  contra  cada equipo!  Decide  aleatoriamente  a  qué  jugador  del equipo  contrario  tiran  la  piedra  (sólo  pueden  ser atacados  los  jugadores que estén  sobre el  terreno de  juego)  y  resuelve  directamente  la  herida  que sufre. No es necesario tirar contra armadura."),
    INVASIONDELCAMPO("Invasión  del  campo","Ambos  entrenadores  tiran  un D6 por cada  jugador contrario que se encuentre en el campo y añade su FAMA al  resultado. Si el total es 6 o más tras la bonificación, el jugador resultará  Aturdido  (los  jugadores  con  la  habilidad Bola  con  Cadena  quedan  Inconscientes).  Un resultado de uno antes de añadir la FAMA no tendrá efecto alguno.");

    private String descripcionEvento;
    private String nombreEvento;

    PatadaInicial(String nombreEvento, String descripcionEvento) {
        this.nombreEvento = nombreEvento;
        this.descripcionEvento = descripcionEvento;
    }

    public String getNombreEvento() { return nombreEvento; }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }
}
