package com.example.Transport.schedule.repository;

import com.example.Transport.schedule.Exceptions.InvalidTokenException;
import com.example.Transport.schedule.Exceptions.UnkownIdentifierException;
import com.example.Transport.schedule.Exceptions.UserAlreadyExistException;
import com.example.Transport.schedule.models.ApplicationUser;
import com.example.Transport.schedule.models.UserData;


public interface UserService {

    void register(final UserData user) throws UserAlreadyExistException;
    boolean checkIfUserExist(final String email);
    void sendRegistrationConfirmationEmail(final ApplicationUser user);
    boolean verifyUser(final String token) throws InvalidTokenException;
    ApplicationUser getUserById(final String id) throws UnkownIdentifierException;

}
