package com.blk.boot.service.support;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blk.boot.data.GuestBookEntry;
import com.blk.boot.repository.GuestBookRepository;
import com.blk.boot.service.GuestBookService;

@Service
public class GuestBookServiceSupport implements GuestBookService {

	@Autowired
	private GuestBookRepository repository;

	@Override
	public GuestBookEntry create(GuestBookEntry entry) {
		Validate.notNull(entry,"Entry to be searched can not be null");
		return repository.save(entry);
	}

	@Override
	public Optional<GuestBookEntry> delete(Integer id) {
		Validate.notNull(id,"Entry id to be deleted can not be null");
		Optional<GuestBookEntry> entry = findById(id);
		if (entry != null) {
			repository.deleteById(id);
		}
		return entry;
	}

	@Override
	public List<GuestBookEntry> findAll() {
		return repository.findAll();
	}
	
	@Override
	public List<GuestBookEntry> findByClientId(String clientId) {
		Validate.notNull(clientId,"client id can not be null");
		return repository.queryByClientId(clientId);		
	}

	@Override
	public Optional<GuestBookEntry> findById(Integer id) {
		Validate.notNull(id,"Entry id to be searched can not be null");
		return repository.findById(id);
	}

	@Override
	public GuestBookEntry update(GuestBookEntry entry){
	Validate.notNull(entry,"Entry to be updated can not be null");
		return repository.save(entry);
	}

	@Override
	public List<GuestBookEntry> findByName(String name) {
		Validate.notNull(name,"Guest name to be searched can not be null");
		return repository.queryByName(name);
	}
}