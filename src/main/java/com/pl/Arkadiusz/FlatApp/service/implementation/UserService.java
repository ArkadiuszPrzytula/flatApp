package com.pl.Arkadiusz.FlatApp.service.implementation;

import com.pl.Arkadiusz.FlatApp.dto.LoggedUserDto;
import com.pl.Arkadiusz.FlatApp.dto.RegisterUSerDto;

public interface UserService {
     void saveUser( RegisterUSerDto registerUSerDto) throws Exception;
     public LoggedUserDto getUser(String username);



}
