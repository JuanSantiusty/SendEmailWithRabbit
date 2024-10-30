package patrones.builder.ej1;

/** ConcreteBuilder */
class PicantePizzaBuilder extends PizzaBuilder {
	public void buildMasa() {
		pizza.setMasa("cocida");
	}

	public void buildSalsa() {
		pizza.setSalsa("picante");
	}

	public void buildRelleno() {
		pizza.setRelleno("pimienta+salchichón");
	}
}
