package ttps.spring.restful.springmvc;

import ttps.spring.model.FoodTruck;

public class FoodTruckDTO {

	private String id;
	private String nombre;
	private String tipoServicio;
	private String tipoServicioNombre;
	private String descripcion;
	private String url;
	private String whatsapp;
	private String twitter;
	private String instagram;
	
	public FoodTruckDTO() {
		super();
	}
	
	public FoodTruckDTO(FoodTruck foodtruck) {
		super();
		this.setId(Long.toString(foodtruck.getId()));
		this.setNombre(foodtruck.getNombre());
		this.setDescripcion(foodtruck.getDescripcion());
		this.setTipoServicio(Long.toString(foodtruck.getTipoServicio().getId()));
		this.setTipoServicioNombre(foodtruck.getTipoServicio().getNombre());
		this.setUrl(foodtruck.getUrl());
		this.setWhatsapp(foodtruck.getWhatsapp());
		this.setTwitter(foodtruck.getTwitter());
		this.setInstagram(foodtruck.getInstagram());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
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

	public String getTipoServicioNombre() {
		return tipoServicioNombre;
	}

	public void setTipoServicioNombre(String tipoServicioNombre) {
		this.tipoServicioNombre = tipoServicioNombre;
	}
	
	
}
