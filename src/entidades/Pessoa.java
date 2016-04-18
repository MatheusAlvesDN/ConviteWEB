package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
@NamedQuery(name ="Pessoa.getAll", query=" from Pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "identidade")
	private String identidade;
	
	public Pessoa(Integer id, String nome, String endereco, String cpf, String identidade){
		
		this.cpf = cpf;
		this.endereco = endereco;
		this.id = id;
		this.identidade = identidade;
		this.nome = nome;
		
	}
	
	public Pessoa(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
