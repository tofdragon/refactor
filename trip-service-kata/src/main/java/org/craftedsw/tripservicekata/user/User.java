package org.craftedsw.tripservicekata.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.craftedsw.tripservicekata.trip.Trip;

public class User {

	private List<Trip> trips = new ArrayList<Trip>();
	private List<User> friends = new ArrayList<User>();
	
	public List<User> getFriends() {
		return friends;
	}

	public List<Trip> tripsIfFriend(User friendUser) {
		User friendUserOfCurrentUser =
				friends.stream().filter(friend -> friend.equals(friendUser)).findAny().orElse(null);
        return friendUserOfCurrentUser == null ? Collections.emptyList() : trips();
	}
	
	public void addFriend(User user) {
		friends.add(user);
	}

	public void addTrip(Trip trip) {
		trips.add(trip);
	}
	
	public List<Trip> trips() {
		return trips;
	}

}
