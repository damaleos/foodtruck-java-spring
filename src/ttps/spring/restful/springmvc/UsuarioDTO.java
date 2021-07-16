package ttps.spring.restful.springmvc;

import ttps.spring.model.Usuario;

public class UsuarioDTO {
	
	private String id;
	
	private String idUsuario;
	
	private String password;
	
	private String email;
	
	private String tipo;
	
	public UsuarioDTO() {
		super();
	}
	
	public UsuarioDTO(Usuario usuario) {
		super();
		this.setId(Long.toString(usuario.getId()));
		this.setIdUsuario(usuario.getIdUsuario());
		this.setEmail(usuario.getEmail());
		this.setTipo(usuario.getTipo().name());
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
