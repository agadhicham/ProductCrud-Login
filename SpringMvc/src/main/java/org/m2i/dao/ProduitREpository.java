package org.m2i.dao;

import org.m2i.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitREpository extends JpaRepository<Produit, Long> {

	@Query("select p from Produit p where p.designation like :x ")
	Page<Produit>cherche(@Param("x")String mc,Pageable pageable);

}
