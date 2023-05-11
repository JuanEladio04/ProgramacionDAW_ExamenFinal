package jepm.examen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the continente database table.
 * 
 */
@Entity
@NamedQuery(name="Continente.findAll", query="SELECT c FROM Continente c")
public class Continente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Pai
	@OneToMany(mappedBy="continente")
	private List<Pais> pais;

	public Continente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Pais> getPais() {
		return this.pais;
	}

	public void setPais(List<Pais> pais) {
		this.pais = pais;
	}

	public Pais addPai(Pais pai) {
		getPais().add(pai);
		pai.setContinente(this);

		return pai;
	}

	public Pais removePai(Pais pai) {
		getPais().remove(pai);
		pai.setContinente(null);

		return pai;
	}

	@Override
	public String toString() {
		return descripcion;
	}
	
	

}