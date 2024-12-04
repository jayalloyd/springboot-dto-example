package com.meenus.springboot_dto.service;

import com.meenus.springboot_dto.dto.UserLocationDTO;
import com.meenus.springboot_dto.model.User;
import com.meenus.springboot_dto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepo;
public List<UserLocationDTO>getAllUsersLocation(){
return userrepo.findAll()
        .stream()
        .map(this::convertEntityToDto)
        .collect(Collectors.toList());

}
//user location entity to userlocationdto
private UserLocationDTO convertEntityToDto(User user){
    UserLocationDTO userLocationDTO=new UserLocationDTO();
    userLocationDTO.setUserId(user.getUserId());
    userLocationDTO.setEmail(user.getEmail());
    userLocationDTO.setPlace(user.getLocation().getPlace());
    userLocationDTO.setLatitude(user.getLocation().getLatitude());
    userLocationDTO.setLongitude(user.getLocation().getLongitude());
    return userLocationDTO;



}

}
