package com.backend.jal.security.repository;

import com.backend.jal.security.entity.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
//    public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    Optional<Usuario> findByNombreUsuarioOrEmail(String nombreUsuario,String email);
    boolean existsByNombreUsuario(String nombreUsuario);

    boolean existsByEmail(String email);
    
@Query(
  value = "SELECT * FROM usuario WHERE nombre = :nombre",
  nativeQuery = true
)
List<Usuario> findAllActiveUsersNative(String nombre);

    public List<Usuario> findByNombre(String nombre);

    public boolean existsByNombre(String usuario);

//    public boolean existsByToken(String token);

    public Optional<Usuario> findByTokenPassword(String tokenPassword);
    
}
