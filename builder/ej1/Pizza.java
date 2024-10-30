package patrones.builder.ej1;

/** Producto */
class Pizza {
	private String masa = "";
	private String salsa = "";
	private String relleno = "";

	public void setMasa(String masa) {
		this.masa = masa;
	}

	public void setSalsa(String salsa) {
		this.salsa = salsa;
	}

	public void setRelleno(String relleno) {
		this.relleno = relleno;
	}

	public String toString() {
		return "Masa:" + masa + " Salsa:" + salsa + " Relleno:"
				+ relleno;
	}
}