package org.craftedsw.tripservicekata.trip;

import java.util.Collections;

import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TripServiceTest {

    @Test
    public void should_has_same_trip_when_is_friend() {
        TripService tripService = new TripService();

        User friendUser = new User();

        User user = new User();
        user.addFriend(friendUser);
        user.addTrip(new Trip());

        assertNotNull(tripService.getTripsIfIsFriend(user, friendUser));
    }

    @Test
    public void should_has_no_trip_when_is_not_friend() {
        TripService tripService = new TripService();

        User noFriendUser = new User();
        User user = new User();
        user.addFriend(new User());

        assertEquals(Collections.emptyList(), tripService.getTripsIfIsFriend(user, noFriendUser));
    }

}
