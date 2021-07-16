package ttps.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import ttps.spring.restful.springmvc.UsuarioDTO;

@Entity
@Table(name = "usuario_evento")
@PrimaryKeyJoinColumn(name="id")
public class UsuarioEvento extends Usuario{

	@Column(name="nombre_comercial")
	private String nombreComercial;

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	
	public UsuarioEvento() {
		super();
	}
	
	public UsuarioEvento(UsuarioDTO user) {
		super();
		this.setIdUsuario(user.getIdUsuario());
		this.setEmail(user.getEmail());
		this.setPassword(user.getPassword());
		this.setTipo(TipoUsuario.ORG_EVENTOS);
	}
}
