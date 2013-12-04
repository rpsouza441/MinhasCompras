package br.com.minhascompras.entidades;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import br.com.minhascompras.annotation.RequiredField;

@SuppressWarnings("serial")
@Entity(name="mercado_produto")
public class MercadoProduto implements java.io.Serializable{
	
	@EmbeddedId
	private MercadoProdutoId id;
	
	@NotNull
	@RequiredField
	@Column(name = "preco", nullable = false, length = 128)
	private double preco;
	

}
