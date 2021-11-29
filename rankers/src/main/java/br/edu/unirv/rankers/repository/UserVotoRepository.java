package br.edu.unirv.rankers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unirv.rankers.entity.UserVoto;

@Repository
public interface UserVotoRepository extends JpaRepository<UserVoto, Long> {

}