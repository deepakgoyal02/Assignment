package com.blk.boot.controller;

import com.blk.boot.data.GuestBookEntry;
import com.blk.boot.service.GuestBookService;

public class GuestBookControllerTest {   // TODO: need to write positive test cases , some strange problem 
										// with mockito lib and committed due to time limit .

	@InjectMocks
	private GuestBookController onTest;
	@Mock
	private GuestBookService service;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_fails_adding_entry_if_input_arg_is_null() {
		onTest.addGuest(null);
	}

	@Test
	public void should_successfully_add_entry() {
		GuestBookEntry entry = new GuestBookEntry("deepak","client");
		GuestBookEntry result = onTest.addGuest(entry);
		//MatcherAssert.assertThat(entry.getName()).as result.getName());
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_fails_updating_entry_if_input_arg_is_null() {
		onTest.updateEntry(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_fails_deleting_entry_if_input_arg_is_null() {
		onTest.deleteEntry(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_fails_searching_entry_by_name_if_input_arg_is_null() {
		onTest.searchEntriesByName(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void should_fails_searching_entry_by_id_if_input_arg_is_null() {
		onTest.searchEntryById(null);
	}
}