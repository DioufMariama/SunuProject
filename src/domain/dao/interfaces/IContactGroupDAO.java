package domain.dao.interfaces;

import domain.metier.ContactGroup;

public interface IContactGroupDAO {

	ContactGroup createContactGroup(String groupName);

	void updateContactGroup(long id, String groupName);

}