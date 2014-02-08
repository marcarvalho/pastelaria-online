package br.com.devmedia.pastelaria_online.domain;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
@Entity
@Table(name="pedido")
@NamedQueries(value={@NamedQuery(name="Pedido.buscarNovosEemAtendimento", query= "Select p From Pedido p inner join fetch p.itens Where p.status = :novo or p.status = :atendimento Order By p.id desc, p.status desc")})
public class Pedido implements Serializable {

	private static final long serialVersionUID = 2753252136140066761L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_pedido", nullable=false)
	private Date dataPedido = new Date();

	@Column(name="nome_cliente", nullable=false, length=150)
	private String cliente;

	@ElementCollection
	@CollectionTable(name="item", joinColumns=@JoinColumn(name="item_id"))
	private List<Item> itens;

	@Column(name="email", nullable=false, length=150)
	private String email;

	@Column(name="telefone", nullable=false, length=18)
	private String telefone;

	@Column(name="atendente", nullable=true, length=50)
	private String atendente;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_hora_atendimento", nullable=true)
	private Date dataAtendimento;

	@Enumerated(EnumType.STRING)
	@Column(name="status", length=1)
	private Status status = Status.N;

	public Pedido() {		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getAtendente() {
		return atendente;
	}

	public void setAtendente(String atendente) {
		this.atendente = atendente;
	}

	public Date getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Date dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", dataPedido=" + dataPedido + ", cliente="
				+ cliente + ", itens=" + itens + ", email=" + email
				+ ", telefone=" + telefone + ", atendente=" + atendente
				+ ", dataAtendimento=" + dataAtendimento + ", status=" + status
				+ "]";
	}
	
	
}

