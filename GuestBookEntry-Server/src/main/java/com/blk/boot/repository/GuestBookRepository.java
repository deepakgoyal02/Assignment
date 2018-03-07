package com.blk.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.blk.boot.data.GuestBookEntry;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface GuestBookRepository extends JpaRepository<GuestBookEntry, Integer> {
	@Query("SELECT p FROM GuestBookEntry p WHERE LOWER(p.clientId) = LOWER(:clientId)")
    public List<GuestBookEntry> queryByClientId(@Param("clientId") String clientId);
	
	@Query("SELECT p FROM GuestBookEntry p WHERE LOWER(p.name) = LOWER(:name)")
    public List<GuestBookEntry> queryByName(@Param("name") String name);

}
