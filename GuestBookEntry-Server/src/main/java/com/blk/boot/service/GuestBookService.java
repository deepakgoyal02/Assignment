package com.blk.boot.service;

import java.util.List;
import java.util.Optional;

import com.blk.boot.data.GuestBookEntry;

public interface GuestBookService {

	GuestBookEntry create(GuestBookEntry user);

	Optional<GuestBookEntry> delete(Integer id);

    List<GuestBookEntry> findAll();

    Optional<GuestBookEntry> findById(Integer id);

    GuestBookEntry update(GuestBookEntry entry);

  //TODO: better way to use searchCriteria to query on different
  	// criteria
	List<GuestBookEntry> findByClientId(String clientId);
	
	List<GuestBookEntry> findByName(String Name);
	
}
