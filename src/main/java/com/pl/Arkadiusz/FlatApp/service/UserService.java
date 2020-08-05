package com.pl.Arkadiusz.FlatApp.service;

import com.pl.Arkadiusz.FlatApp.dto.LoggedUserDto;
import com.pl.Arkadiusz.FlatApp.dto.RegisterUSerDto;
import com.pl.Arkadiusz.FlatApp.model.entities.User;

public interface UserService {
     void saveUser( RegisterUSerDto registerUSerDto) throws Exception;
     LoggedUserDto getUser(String username);

     User getRawUser(String username);
}
