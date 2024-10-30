package patrones.builder.ej1;
/**
 * Fuente: http://es.wikipedia.org/wiki/Builder_%28patr%C3%B3n_de_dise%C3%B1o%29
 * @author libardo
 *
 */

public class ClienteMain {
	public static void main(String[] args) {
		Cocina cocina = new Cocina();
		PizzaBuilder hawai_pizzabuilder = new HawaiPizzaBuilder();
		cocina.setPizzaBuilder(hawai_pizzabuilder);
		cocina.construirPizza();

		Pizza pizza = cocina.getPizza();
		System.out.println("Pizza:" + pizza);
		
		PizzaBuilder picante_pizzabuilder = new PicantePizzaBuilder();
		cocina.setPizzaBuilder(picante_pizzabuilder);
		cocina.construirPizza();
		pizza = cocina.getPizza();
		System.out.println("Pizza:" + pizza);

	}
}
