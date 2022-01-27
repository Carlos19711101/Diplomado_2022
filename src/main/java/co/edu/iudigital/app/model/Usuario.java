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

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	
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
