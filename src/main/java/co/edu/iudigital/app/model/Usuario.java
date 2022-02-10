package co.edu.iudigital.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getRedSocial() {
		return redSocial;
	}

	public void setRedSocial(Boolean redSocial) {
		this.redSocial = redSocial;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
   
    @NotEmpty
    @NotNull
	@Column(unique = true, length = 120)
	private String Username;
	
	@Column(length = 120)
	private String password;
	
	@Column(nullable = false, length = 120)
	private String nombre;
	
	@Column(nullable = true, length = 120)
	private String apellido;
	
	@Column(name = "fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	private Boolean enabled;
	
	@Column(name = "red_social")
	private Boolean redSocial;
	
	private String imagen;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "roles_usuarios",
	joinColumns = {@JoinColumn(name = "usuarios_id")},
	inverseJoinColumns = {@JoinColumn(name = "roles_id")})
	private List<Role> roles;
}
