package com.example.miguel.bludbuwl;

public enum Habilidad {

    ATRAPAR("Atrapar","Un jugador con la habilidad Atrapar puede repetir la tirada para atrapar el balón si ha fallado la primera. También permite al jugador repetir la tirada si el balón cae al entregarlo a la mano o no consigue interceptar."),
    ESQUIVAR("Esquivar","Un jugador con la habilidad Esquivar está acostumbrado a zafarse de oponentes y podrá repetir la tirada de esquivar al intentar salir de la zona de defensa de un jugador contrario. Sin embargo, el jugador sólo podrá repetir una tirada de esquivar por turno de equipo. Además, la habilidad Esquivar, si se emplea, afecta al resultado de los dados de Placaje, tal y como se describe en la Reglas de Placaje."),
    MANOSSEGURAS("Manos Seguras","Un jugador con la habilidad Manos Seguras puede repetir el D6 si falla un intento de recoger el balón del suelo. Además, si un jugador contrario tiene la habilidad Robar Balón, no podrá usarla contra un jugador con la habilidad Manos Seguras."),
    PASAR("Pasar","Un jugador con la habilidad Pasar puede repetir la tirada de D6 si realiza un pase fallido o impreciso."),
    PLARCAR("Placar","Un jugador con la habilidad Placar es diestro a la hora de derribar jugadores contrarios. La habilidad de Placar, si se usa, afecta a los resultados obtenidos en los dados de Placaje, tal y como se explica en las Reglas de Placaje."),
    SOLITARIO("Solitario","Los solitarios, debido a la inexperiencia, arrogancia, ferocidad animal o simple estupidez, no juegan bien con el resto del equipo. Como resultado, los Solitarios no pueden emplear segundas oportunidades de equipo a menos que primero obtengan un 4+ en un D6. Con un resultado de 1-3 el resultado original se mantiene y la segunda oportunidad se pierde (se usa)."),
    CABEZAHUECA("Cabeza Hueca","El jugador no sobresale por su inteligencia. Por ello, se debe tirar 1D6 después de declarar la acción que realizará el jugador, pero antes de realizarla. Con un resultado de 1 el jugador se quedará parado sin hacer nada, intentando recordar qué debía hacer. El jugador no podrá hacer nada durante el resto del turno y el equipo de ese jugador perderá la acción declarada este turno. (Así, si un jugador con Cabeza Hueca declara un movimiento de Penetración y saca un 1, el equipo no podrá declarar otra Penetración este turno). El jugador pierde su zona de defensa y no podrá atrapar el balón, asistir a ningún jugador en una falta o placaje, o moverse voluntariamente hasta que consiga obtener 2+ al principio de una acción futura o hasta que termine la entrada."),
    GOLPEMORTIFERO("Golpe Mortifero","Suma 1 a los chequeos contra Armadura o para determinar las Heridas causadas por un jugador con esta habilidad cuándo un oponente sea Derribado por este jugador durante un Placaje. Tan sólo puede ser utilizada para modificar una de las tiradas, así que si decides emplear Golpe Mortífero para modificar la tirada de Armadura no podrás modificar la tirada de Heridas."),
    CABEZADURA("Cabeza Dura","Este jugador trata las tiradas de 8 en la Tabla de heridas, después de que se hayan aplicado los modificadores, como un resultado de Aturdido en lugar de Inconsciente. Esta habilidad puede utilizarse incluso si el jugador está Tumbado o Aturdido."),
    LANZARCOMPAÑERO("Lanzar Compañero de Equipo","Un jugador con esta habilidad tiene la capacidad de lanzar a uno de sus compañeros de equipo en lugar del balón. (¡Esto incluye el balón si el jugador lanzado lo tiene en su posesión!). El jugador lanzador debe terminar el movimiento de la Acción de Pase adyacente al compañero de equipo que desea lanzar, el cual deberá tener Agilidad Felina y encontrarse de pie. El pase se resuelve exactamente igual que si el jugador lanzador hiciese un pase, salvo que el jugador debe restar 1 al D6 cuándo pase al jugador y las distancias “Bomba Larga” y “Pase Largo” no son posibles. Además los pases precisos cuentan como pases imprecisos, por esto desvía al jugador tres casillas, ya que los jugadores son más pesados y más difíciles de lanzar que el balón. El jugador lanzado no puede ser interceptado. Un compañero de equipo que resulte “Balón Perdido” caerá en la casilla que ocupaba originalmente. Si el jugador lanzado cae fuera del campo será golpeado por el público de la misma manera que un jugador que es empujado al público. Si la casilla final sobre la que se desvía está ocupada por otro jugador, trata al jugador que se encontraba en ella como Derribado y tira su Armadura (incluso si ya estaba Tumbado o Aturdido) y entonces se desviará una casilla más. Si el jugador lanzado vuelve a caer sobre otro jugador, continúa desviándolo hasta que caiga en una casilla vacía o fuera del campo (es decir, no puede aterrizar sobre más de un jugador). Mira la descripción de Agilidad Felina para ver si el jugador aterriza sobre sus pies ¡o cabeza abajo sobre sus maltrechos huesos!"),
    NINGUNA(" "," ");

    private String nombreHabilidad;
    private String descripcion;

    Habilidad(String nombreHabilidad, String descripcionHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
        this.descripcion = descripcionHabilidad;
    }

    public String getNombre() {
        return nombreHabilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
