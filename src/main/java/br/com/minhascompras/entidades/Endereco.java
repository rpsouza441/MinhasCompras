package br.com.minhascompras.entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	@Column(name = "rua", nullable = false)
	private String rua;
	@Column(name = "numero", nullable = false)
	private String numero;
	@Column(name = "bairro", nullable = false)
	private String bairro;
	@Column(name = "cidade", nullable = false)
	private String cidade;
	@Column(name = "refecenria", nullable = false)
	private String referencia;

	public Endereco() {
		super();
	}

	public Endereco(String rua, String numero, String bairro, String cidade,
			String referencia) {
		super();

		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.referencia = referencia;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

}
