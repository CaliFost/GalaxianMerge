package Estados;

public abstract class State {
	protected int velocidad;
	protected int direccion;

	public abstract void activar();

	public void setDireccion(int d) {
		direccion = d;
	}
}
