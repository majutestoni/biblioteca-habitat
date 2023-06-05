package br.furb.inf.furbot.enuns;

public enum PerfilJWT {

	ADMIN(1, "ROLE_ADMIN"), CLIENTE(2, "ROLE_CLIENTE");

	private int cod;
	private String descricao;

	private PerfilJWT(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static PerfilJWT toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (PerfilJWT x : PerfilJWT.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
