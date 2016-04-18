package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_evento")
@NamedQuery(name = "Evento.gelAll", query = " from Evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_evento")
	private Integer id;
	
	@Column(name = "nome_evento")
	private String nomeEvento;
	
	@Column(name = "local_evento")
	private String local;
	
	@Column(name = "endereco_evento")
	private String endereco;
	
	public Evento(Integer id, String nomeEvento, String local, String endereco){
		
		this.id = id;
		this.nomeEvento = nomeEvento;
		this.local = local;
		this.endereco = endereco;
		
	}
	
	public Evento(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
