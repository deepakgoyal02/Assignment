package com.blk.boot.controller;

import java.util.List;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blk.boot.data.GuestBookEntry;
import com.blk.boot.service.GuestBookService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GuestBookController {
	@Autowired
	private GuestBookService service;

	@PostMapping("/entry-add")
	public GuestBookEntry addGuest(@RequestBody GuestBookEntry entry) {
		Validate.notNull(entry, "Entry to be added can not be null");
		entry.setClientId(getClientId());
		return service.create(entry);		
	}

	@PutMapping("/entry-update")
	public GuestBookEntry updateEntry(@RequestBody GuestBookEntry entry) {
		Validate.notNull(entry, "Entry to be updated can not be null");
		entry.setClientId(getClientId());
		return service.update(entry);
	}

	@DeleteMapping("/entry-delete/{id}")
	public GuestBookEntry deleteEntry(@PathVariable("id") Integer id) {
		Validate.notNull(id, "Entry to be deleted can not be null");
		return service.delete(id).orElse(null);
		// here we should throw the exception with error code
	}

	@GetMapping("/entries-search/{name}")
	public List<GuestBookEntry> searchEntriesByName(@PathVariable("name") String name) {
		Validate.notNull(name, "Entry name to be searched can not be null");
		return service.findByName(name);
	}

	@GetMapping("/entry-get/{id}")
	public GuestBookEntry searchEntryById(@PathVariable("id") Integer id) {
		Validate.notNull(id, "Entry id to be searched can not be null");
		return service.findById(id).orElse(new GuestBookEntry());
	}

	@GetMapping("/all-entries")
	public List<GuestBookEntry> findAllEntries() {
		return service.findByClientId(getClientId());
	}

	private String getClientId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}
		String clientId = null;

		if (authentication.getClass().isAssignableFrom(OAuth2Authentication.class)) {
			clientId = ((OAuth2Authentication) authentication).getOAuth2Request().getClientId();
		}
		return clientId;
	}
}
