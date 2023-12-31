package com.example.Transport.schedule.service;

import com.example.Transport.schedule.Exceptions.InvalidPasswordException;
import com.example.Transport.schedule.Exceptions.InvalidTokenException;
import com.example.Transport.schedule.Exceptions.UnkownIdentifierException;
import com.example.Transport.schedule.Exceptions.UserAlreadyExistException;
import com.example.Transport.schedule.models.ApplicationUser;
import com.example.Transport.schedule.models.ApplicationUserRole;
import com.example.Transport.schedule.models.PasswordConstraintValidator;
import com.example.Transport.schedule.models.UserData;
import com.example.Transport.schedule.repository.UserRepository;

import com.example.Transport.schedule.repository.UserService;
import jakarta.validation.ClockProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import jakarta.validation.ConstraintValidatorContext;


@Service("userService")
@RequiredArgsConstructor
public class UserRegistrationService  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public void register(@Valid @NotNull UserData user) throws UserAlreadyExistException, InvalidPasswordException {

        //Let's check if user already registered with us
        if(checkIfUserExist(user.getEmail())){
            throw new UserAlreadyExistException("User already exists for this email");
        }
        ApplicationUser applicationUser = new ApplicationUser();
        BeanUtils.copyProperties(user, applicationUser);

//      Проверка сложности пароля
        PasswordConstraintValidator passwordValidator = new PasswordConstraintValidator();
        if (!passwordValidator.isValid(user.getPassword(), null)) {
            throw new InvalidPasswordException("Password does not meet complexity requirements");
        }
//
        encodePassword(applicationUser, user);
        applicationUser.setRole(ApplicationUserRole.USER);
        userRepository.save(applicationUser);
    }


    @Override
    public boolean checkIfUserExist(String email) {
        var user = userRepository.findByEmail(email).isPresent();
        return user;
    }

    @Override
    public void sendRegistrationConfirmationEmail(ApplicationUser user) {

    }

    @Override
    public boolean verifyUser(String token) throws InvalidTokenException {
        return false;
    }

    @Override
    public ApplicationUser getUserById(String id) throws UnkownIdentifierException {
        return null;
    }

    private void encodePassword( ApplicationUser applicationUser, UserData user){
        applicationUser.setPassword(passwordEncoder.encode(user.getPassword()));
    }
}