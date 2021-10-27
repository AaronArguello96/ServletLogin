package entities;
// Generated 27 oct 2021 13:13:19 by Hibernate Tools 5.5.7.Final
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name="usuarios")
public class Usuarios implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "id_rol")
	private Integer roles;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "clave")
	private String clave;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido1")
	private String apellido1;
	
	@Column(name = "apellido2")
	private String apellido2;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "localidad")
	private String localidad;
	
	@Column(name = "provincia")
	private String provincia;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "dni")
	private String dni;

	public Usuarios() {
	}

	public Usuarios(Integer roles, String email, String clave, String nombre, String apellido1, String apellido2,
			String direccion, String localidad, String provincia, String telefono, String dni) {
		this.roles = roles;
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.telefono = telefono;
		this.dni = dni;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoles() {
		return this.roles;
	}

	public void setRoles(Integer roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
