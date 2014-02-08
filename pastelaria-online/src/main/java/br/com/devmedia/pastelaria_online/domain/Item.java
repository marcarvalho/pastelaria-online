package br.com.devmedia.pastelaria_online.domain;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class Item implements Serializable {

	private static final long serialVersionUID = -3778397739515571369L;

	@Column(name="sabor", nullable=false, length=150)
	private String sabor;

	@Column(name="quantidade", nullable=false)
	private Integer quantidade;

	public Item() {	  
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((quantidade == null) ? 0 : quantidade.hashCode());
		result = prime * result + ((sabor == null) ? 0 : sabor.hashCode());
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
		Item other = (Item) obj;
		if (quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!quantidade.equals(other.quantidade))
			return false;
		if (sabor == null) {
			if (other.sabor != null)
				return false;
		} else if (!sabor.equals(other.sabor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [sabor=" + sabor + ", quantidade=" + quantidade + "]";
	}

}
