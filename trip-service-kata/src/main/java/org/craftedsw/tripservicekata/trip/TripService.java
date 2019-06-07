package org.craftedsw.tripservicekata.trip;

import java.util.List;

import org.craftedsw.tripservicekata.user.User;

public class TripService {

    public List<Trip> getTripsIfIsFriend(User user, User friendUser) {
        // TODO 考虑用户已经有旅途了
        return user.tripsIfFriend(friendUser);
    }

}
