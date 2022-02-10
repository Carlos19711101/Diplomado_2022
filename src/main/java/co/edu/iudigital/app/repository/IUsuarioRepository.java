package co.edu.iudigital.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.iudigital.app.model.Usuario;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByUsername(String email);
	
	@Query("SELECT u FROM Usuario u WHERE username=?1")
	public Usuario findByUsername2(String email);
}
