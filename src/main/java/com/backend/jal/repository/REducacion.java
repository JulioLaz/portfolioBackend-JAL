
package com.backend.jal.repository;

import com.backend.jal.entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducacion extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findBySchoolE(String schoolE);
    public boolean existsBySchoolE(String schoolE);
}
