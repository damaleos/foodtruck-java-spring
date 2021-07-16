package ttps.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ttps.spring.restful.springmvc.FoodTruckDTO;

@Entity
@Table(name="food_truck")
public class FoodTruck {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nombre")
	private String nombre;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private TipoServicio tipoServicio;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "url")
	private String url;

	@Column(name = "whatsapp")
	private String whatsapp;

	@Column(name = "twitter")
	private String twitter;

	@Column(name = "instagram")
	private String instagram;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Foto> fotos;

	
	public FoodTruck(FoodTruckDTO dto) {
		super();
		//this.setId(dto.getId() != null ? Long.valueOf(dto.getId()) : null);
		this.setNombre(dto.getNombre());
		this.setDescripcion(dto.getDescripcion());
		//this.setTipoServicio(foodtruck.getTipoServicio().getNombre());
		this.setUrl(dto.getUrl());
		this.setWhatsapp(dto.getWhatsapp());
		this.setTwitter(dto.getTwitter());
		this.setInstagram(dto.getInstagram());
		this.fotos = new ArrayList<Foto>();
	}
	
	public FoodTruck() {
		super();
		this.fotos = new ArrayList<Foto>();
	}

	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}
}
