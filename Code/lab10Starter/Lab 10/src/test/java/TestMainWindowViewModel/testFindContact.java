package TestMainWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;

class testFindContact {
	private MainWindowViewModel vm;
	
	@Test
	void testFindContactByName() {
		vm.getName().set("Anne");
		vm.getPhoneNumber().set("123-1234");
		vm.addContact();
		vm.getSearchCriteria().set("Anne");
		assertEquals("Anne,  123-1234", vm.findContact());
	}
	
	@Test
	void testFindContactByPhoneNumber() {
		vm.getName().set("Zach");
		vm.getPhoneNumber().set("222-2222");
		vm.addContact();
		vm.getSearchCriteria().set("222-2222");
		assertEquals("Zach, 222-2222", vm.findContact());
	}
    @Test
    void  testContactFoundNoReturn() {
		vm.getSearchCriteria().set("123-1234");
		assertEquals("No return", vm.findContact());
	}
    
	@Test
	void  testContactNotFound() {
		vm.getSearchCriteria().set("nothing");
		assertThrows(IllegalArgumentException.class, () -> 
		 vm.findContact());
	}
	
	
}
