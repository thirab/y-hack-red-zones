package com.example.redzones;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A local database that can manage personal profiles.
 * 
 * @author chell22m
 * 
 */
public class Database {

	// Holds all the profiles of the FacePamphlet
	private ArrayList<UserProfile> profileList = new ArrayList<UserProfile>();

	/**
	 * Constructor
	 */
	public Database() {

	}

	
	/**
	 * Adds a profile to the database.
	 * @param newProfile the profile to add.  There should not be a profile
	 *   under this name already.  newProfile should not be null.
	 */
	public void addProfile(UserProfile newProfile) {
		profileList.add(newProfile);
	}

	/**
	 * Remove a profile from the database.  
	 * @param name the name of the profile to remove.  There should be 
	 *   a profile with this name.  name should not be null.
	 */
	public void deleteProfile(String id) {
		// the profile to be deleted
		UserProfile delete = getProfile(id);
		// the iterator walks through the friendList of the deleted user to find
		// it's friends
		Iterator<String> iter = (delete.getFriendsList()).iterator();
		while (iter.hasNext()) {
			// obtaining the profiles of the friends of the deleted user and
			// removing the deleted user
			UserProfile nextFriend = getProfile(iter.next());
			nextFriend.removeFriend(id);
		}
		// deleting the user from the database
		Iterator<UserProfile> iter2 = profileList.iterator();
		while (iter2.hasNext()) {
			UserProfile nextProfile = iter2.next();
			// if the iterator finds the user then it is removed
			if (id.equals(nextProfile.getId())) {
				iter2.remove();
				// ends the loop prematurely as the user is deleted
				return;
			}
		}

	}

	/**
	 * Retrieve a profile from the database
	 * @param name the name of the profile to retrieve.  Should not be null.
	 * @return the profile for the given name.  Returns null if there
	 *   is no profile for that name.
	 */
	public UserProfile getProfile(String name) {
		// walks through the database arrayList and finds the requested user's
		// profile
		Iterator<UserProfile> iter = profileList.iterator();
		while (iter.hasNext()) {
			UserProfile nextProfile = iter.next();
			// when profile is found then it is returned
			if (name.equals(nextProfile.getId())) {
				return nextProfile;
			}
		}
		// if not found in database, then return null
		return null;
	}

	/**
	 * Returns true if there is a profile for the given name
	 * @param name the name of the profile to retrieve.  Should not be null.
	 * @return true if there is a profile for the given name
	 */
	public boolean containsProfile(String id) {
		// if the requested user is in the database and not null
		if (getProfile(id) != null) {
			return true;
		}
		// otherwise the user isn't in the database
		return false;
	}

}

