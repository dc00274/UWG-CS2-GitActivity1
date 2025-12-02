package TestMainWindowViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.viewmodel.MainWindowViewModel;

class testAddContact {
      private MainWindowViewModel vm;
      
	 @Test
	    void testAddValidContact() {
		 vm = new MainWindowViewModel();
	     vm.getName().set("Dillan");
	     vm.getPhoneNumber().set("773-4317");
	     vm.addContact();
	     assertEquals(1, vm.getContacts().size());
	     assertEquals("Dillan, 773-4317", vm.getContacts().get(0).toString());
	}
	 @Test
	    void tesInvalidName() {
	        vm.getName().set("4627"); 
	        vm.getPhoneNumber().set("777-7777");
	        Exception ex = assertThrows(IllegalArgumentException.class, () -> 
	           vm.addContact());
	        assertEquals("Name is not valid", ex.getMessage());
	    }
	 @Test
	  void  testInvalidPhoneNumber() {
		 vm.getName().set("Mike"); 
	        vm.getPhoneNumber().set("chicken-man");
	        Exception ex = assertThrows(IllegalArgumentException.class, () -> 
	           vm.addContact());
	        assertEquals("PhoneNumber is not valid", ex.getMessage());
	 }
	 @Test
	 void testDuplicateName() {
		 vm.getName().set("Timmy");
	        vm.getPhoneNumber().set("123-1234");
	        vm.addContact();
            vm.getName().set("Timmy"); 
	        vm.getPhoneNumber().set("321-4321");
            Exception ex = assertThrows(IllegalArgumentException.class, () -> 
                  vm.addContact());
	        assertEquals("Name is already taken", ex.getMessage());
	 }
	 @Test
	 void testDuplicatePhoneNumber() {
		 vm.getName().set("Timmy");
	        vm.getPhoneNumber().set("123-1234");
	        vm.addContact();
            vm.getName().set("Johnny"); 
	        vm.getPhoneNumber().set("123-1234");
            Exception ex = assertThrows(IllegalArgumentException.class, () -> 
                  vm.addContact());
	        assertEquals("Name is already taken", ex.getMessage());
	 }
}
