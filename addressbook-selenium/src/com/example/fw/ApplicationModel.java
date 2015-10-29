package com.example.fw;

import java.util.List;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class ApplicationModel {

	private  SortedListOf<GroupData> groups;
	private SortedListOf<ContactData> contacts;
	
	public SortedListOf<GroupData> getGroups () {
		return new SortedListOf<GroupData>(groups);
	}
	

	public void setGroups(List<GroupData> listGroups) {
		this.groups = new SortedListOf<GroupData>(listGroups);
	}
	
	public  	SortedListOf<ContactData> getContacts () {
		return contacts;
	}
	
	public void setContacts(List<ContactData> contacts) {
		this.contacts = new SortedListOf<ContactData>(contacts);
	}

	public ApplicationModel addGroup(GroupData group) {
		groups.add(group);
		return this;
	}

	public ApplicationModel removeGroup(int index) {
		groups.remove(index);
		return this;
	}
	public ApplicationModel addContact(ContactData contact) {
		contacts.add(contact);
		return this;
	}
}
