package com.example.redzones;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Holds the information of each user in the Profile class. Information such as
 * name, friends, profile picture and so forth. Keeps the data of the users.
 * 
 * @author chell22m
 * 
 */
public class UserProfile {
	// Holds the name of the user's profile
	private String id = "";

	// Holds the list of friends of user
	private ArrayList<String> friendList = new ArrayList<String>();
	
	// Holds the list of friends of user
	private ArrayList<PinObject> pinList = new ArrayList<PinObject>();

	/**
	 * Constructor - makes a new Profile with the given name
	 * 
	 * @param currentName
	 *            - name of the user
	 */
	public UserProfile(String currentid) {
		// sets the user's name field
		id = currentid;
	}

	/**
	 * returns the user's name
	 */
	public String toString() {
		// checking if the name is set
		assert (id != null || id != "");
		// gathering the list of friends
		String friends = printFriends();
		String pins = printPins();
		return id + " [" + pins + "]: " + friends;
	}

	/**
	 * Walks through the ArrayList and gathers the list of friends
	 * 
	 * @return the list of friends
	 */
	public String printFriends() {
		// prints the list of friends of user by using an iterator to walk
		// through the friendList array list
		String friends = "";
		Iterator<String> iter = friendList.iterator();
		while (iter.hasNext()) {
			friends = friends + iter.next() + "\n";
		}
		return friends;
	}
	
	public String printPins() {
		// prints the list of friends of user by using an iterator to walk
		// through the friendList array list
		String pins = "";
		Iterator<PinObject> iter = pinList.iterator();
		while (iter.hasNext()) {
			PinObject nextPin = iter.next();
			pins = pins + nextPin.getPid() + " " + nextPin.getStatus() + " " + nextPin.getTime()
					+ " " + nextPin.getLongtitude() + " " + nextPin.getLattitude() + "\n";
		}
		return pins;
	}

	/**
	 * Returns the name of user
	 * 
	 * @return name of user
	 */
	public String getId() {
		return id;
	}

	/**
	 * Adds a friend to the friend list of user
	 * 
	 * @param friend
	 *            new friend
	 */
	public void setFriends(String friend) {
		friendList.add(friend);
	}
	
	public void setPins(PinObject pin) {
		pinList.add(pin);
	}

	/**
	 * Checks if the friend is in the user's friend list. Returns the name of
	 * the friend requested from user's friend list
	 * 
	 * @param friend
	 *            requested
	 * @return the name of the friend requested
	 */
	public String getFriend(String friend) {
		// walks through the friendList arrayList and compares each array node
		// to the friend requested
		Iterator<String> iter = friendList.iterator();
		while (iter.hasNext()) {
			String nextFriend = iter.next();
			// if found then returns the name.
			if (friend.equals(nextFriend)) {
				return nextFriend;
			}
		}
		// otherwise
		return null;
	}
	
	public PinObject getPin(String pid) {
		// walks through the friendList arrayList and compares each array node
		// to the friend requested
		Iterator<PinObject> iter = pinList.iterator();
		while (iter.hasNext()) {
			PinObject nextPin = iter.next();
			// if found then returns the name.
			if (nextPin.getPid().equals(pid)) {
				return nextPin;
			}
		}
		// otherwise
		return null;
	}

	/**
	 * Removes the friend from the user's friendList
	 * 
	 * @param friend
	 *            friend user to remove
	 */
	public void removeFriend(String friend) {
		// walks through the friendList arraylist until the iterator finds the
		// friend's profile
		Iterator<String> iter = friendList.iterator();
		while (iter.hasNext()) {
			String nextFriend = iter.next();
			// when the friend's profile is found, it is removed
			if (friend.equals(nextFriend)) {
				iter.remove();
				// finishes the loop prematurely after friend is removed
				return;
			}
		}
	}
	
	public void removePin(String pid) {
		// walks through the friendList arraylist until the iterator finds the
		// friend's profile
		Iterator<PinObject> iter = pinList.iterator();
		while (iter.hasNext()) {
			PinObject nextPin = iter.next();
			// when the friend's profile is found, it is removed
			if (nextPin.getPid().equals(pid)) {
				iter.remove();
				// finishes the loop prematurely after friend is removed
				return;
			}
		}
	}

	/**
	 * Returns the friendList of user
	 * 
	 * @return friendList of user
	 */
	public ArrayList<String> getFriendsList() {
		return friendList;
	}
	
	public ArrayList<PinObject> getPinsList() {
		return pinList;
	}
}

