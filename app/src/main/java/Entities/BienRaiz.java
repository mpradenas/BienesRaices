package Entities;

import java.io.Serializable;

/**
 * Created by Gamalyon on 02/06/2017.
 */

public class BienRaiz implements Serializable {

    public int tipo;
    public Proyecto elBienRaiz;
    public double uF=26646.44;

    //en esta función recibo el objeto con parte de los datos ya seteados, y hago los cálculos que serán desplegados en el activity final
    public Proyecto creaCalculos(Proyecto elProyecto, boolean dsctoVerde, boolean dsctoBco)
    {
        double desctoBco=0;
        double desctVerde=0;
        elProyecto.setDesctoEnVerde(dsctoBco==true? (elProyecto.getValorNeto()* 0.15):0);
        elProyecto.setDescuentosBco(dsctoVerde==true?(elProyecto.getValorNeto()* 0.03):0);
        elProyecto.setValorTotal(elProyecto.getValorNeto()-elProyecto.getDesctoEnVerde()-elProyecto.getDescuentosBco());
        return elProyecto;
    }

}
