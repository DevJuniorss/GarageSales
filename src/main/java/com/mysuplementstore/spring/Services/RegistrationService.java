package com.mysuplementstore.spring.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.mysuplementstore.spring.Models.AppUserRole;
import com.mysuplementstore.spring.Models.ApplicationUser;
import com.mysuplementstore.spring.Models.RegistrationRequest;
import com.mysuplementstore.spring.auth.AppUserService;

import java.util.Locale;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;


    public String register(RegistrationRequest request){
        ApplicationUser.Gender gender = ApplicationUser.Gender.MALE;
        if ( request.getGender().toUpperCase(Locale.ROOT).equals("MALE")){
            gender = ApplicationUser.Gender.MALE;
        }
        else if ( request.getGender().toUpperCase(Locale.ROOT).equals("FEMALE")){
            gender = ApplicationUser.Gender.FEMALE;
        }
        else{
            throw new IllegalStateException("GENDER SHOULD BE ONE OF MALE/FEMALE. There are only two genders!!");
        }


        return appUserService.signupUser( new ApplicationUser(
                request.getFirstName(),
                request.getLastName(),
                request.getUserName(),
                request.getPassword(),
                request.getEmail(),
                AppUserRole.USER,
                gender
        ));


    }



}
