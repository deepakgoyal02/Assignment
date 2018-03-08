package com.blk.boot.service.support;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.stereotype.Service;

import com.blk.boot.repository.GuestBookRepository;

@Service
public class GuestBookServiceSupportTest {// TODO: need to write positive test cases , some strange problem 
	// with mockito lib and committed due to time limit  .

	@InjectMocks
	private GuestBookServiceSupport onTest;

	@Mock
	private GuestBookRepository repository;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_fails_creating_entry_if_input_arg_is_null() {
		onTest.create(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_fails_deleting_entry_if_input_arg_is_null() {
		onTest.delete(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_fails_finding_entry_by_clinet_id_if_input_arg_is_null() {
		onTest.findByClientId(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_fails_finding_entry_by_idif_input_arg_is_null() {
		onTest.findById(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_fails_updating_entry_if_input_arg_is_null() {
		onTest.update(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_fails_finding_entry_by_name_if_input_arg_is_null() {
		onTest.findByName(null);
	}
/*
 * 
const config = {
  issuer: 'https://dev-266647.oktapreview.com/oauth2/default',
  redirectUri: 'http://localhost:4200/implicit/callback',
  clientId: '0oae7yjo10umRN2Vs0h7'
};*/
 */
}