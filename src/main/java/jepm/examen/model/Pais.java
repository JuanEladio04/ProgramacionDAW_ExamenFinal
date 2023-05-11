package jepm.examen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name="pais")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Marca
	@OneToMany(mappedBy="pai")
	private List<Marca> marcas;

	//bi-directional many-to-one association to Continente
	@ManyToOne
	@JoinColumn(name="idContinente")
	private Continente continente;

	public Pais() {
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

	public List<Marca> getMarcas() {
		return this.marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public Marca addMarca(Marca marca) {
		getMarcas().add(marca);
		marca.setPai(this);

		return marca;
	}

	public Marca removeMarca(Marca marca) {
		getMarcas().remove(marca);
		marca.setPai(null);

		return marca;
	}

	public Continente getContinente() {
		return this.continente;
	}

	public void setContinente(Continente continente) {
		this.continente = continente;
	}

	@Override
	public String toString() {
		return descripcion;
	}
	
	

}