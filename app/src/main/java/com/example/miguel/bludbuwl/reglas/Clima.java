package com.example.miguel.bludbuwl.reglas;

public enum Clima {

    CALOR("Calor asfixiante","El día es tan caluroso y húmedo que algunos  jugadores  caen  desmayados  por  el  calor. Deberá  efectuarse  una  tirada  de  1D6  por  cada jugador  sobre  el  terreno  de  juego  al  final  de  cada parte o después de anotarse cada touchdown. Con un resultado de 1 el jugador se desplomará desmayado y no podrá jugar hasta la próxima patada inicial."),
    SOLEADO("Muy  soleado","Un  día  glorioso,  pero  el  sol  es  tan brillante que provoca un -1 a los pases."),
    PERFECTO("Día  perfecto","El  tiempo  es  perfecto  para  practicar Blood Bowl."),
    LLUVIOSO("Lluvioso","Llueve y el balón está resbaladizo y es difícil de coger. Esto provoca un modificador de  -1 a  todos los  intentos  de  atrapar  el  balón,  incluso  al interceptarlo, entregar el balón o recogerlo del suelo."),
    VENTISCA("Ventisca","¡Nieva y hace frío! El hielo acumulado en el terreno de juego hace que los jugadores que intenten mover una casilla adicional (APE) resbalen y  resulten Derribados al suelo si se obtiene un resultado de 1 ó 2.  Además,  la  tormenta  de  nieve  hace  que  sólo puedan intentarse pases Rápidos y Cortos.");
    private String descripcionClima;
    private String nombreClima;

    Clima(String nombreClima, String descripcionClima) {
        this.nombreClima = nombreClima;
        this.descripcionClima = descripcionClima;
    }

    public String getNombreClima() { return nombreClima; }

    public String getDescripcionClima() {
        return descripcionClima;
    }

}
