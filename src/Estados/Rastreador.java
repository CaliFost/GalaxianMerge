package Estados;

import Entidades.*;

public class Rastreador extends State {

	private Entidad seguidor;
	private Entidad buscado;

	public Rastreador(Entidad seguidor, Entidad buscado) {
		this.seguidor = seguidor;
		velocidad = 1;
		this.buscado = buscado;
	}

	public void activar() {
		int cordXBuscado = buscado.getPos().x;
		int cordXSeguidor = seguidor.getPos().x;
		int cordYSeguidor = seguidor.getPos().y;
		if(cordXSeguidor>cordXBuscado)
			seguidor.setPos(seguidor.getPos().x-1, seguidor.getPos().y+5);
		else if(cordXSeguidor<cordXBuscado)
				seguidor.setPos(seguidor.getPos().x+1, seguidor.getPos().y+5);
			else
				seguidor.setPos(seguidor.getPos().x, seguidor.getPos().y+5);
		if (cordYSeguidor > 500) {
			seguidor.setPos(seguidor.getPos().x, 0);
		}
	}

}
