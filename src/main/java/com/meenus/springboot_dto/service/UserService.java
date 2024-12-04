package com.meenus.springboot_dto.service;

import com.meenus.springboot_dto.dto.UserLocationDTO;
import com.meenus.springboot_dto.model.User;
import com.meenus.springboot_dto.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

     @Autowired
     private ModelMapper modelMapper;
    @Autowired
    private UserRepository userrepo;
public List<UserLocationDTO>getAllUsersLocation(){
return userrepo.findAll()
        .stream()
        .map(this::convertEntityToDto)
        .collect(Collectors.toList());

}
//user location entity to userlocationdto
/* private UserLocationDTO convertEntityToDto(User user){
    UserLocationDTO userLocationDTO=new UserLocationDTO();
    userLocationDTO.setUserId(user.getUserId());
    userLocationDTO.setEmail(user.getEmail());
    userLocationDTO.setPlace(user.getLocation().getPlace());
    userLocationDTO.setLatitude(user.getLocation().getLatitude());
    userLocationDTO.setLongitude(user.getLocation().getLongitude());
    return userLocationDTO;}
*/
    //using modelmapper
private UserLocationDTO convertEntityToDto(User user){
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);//since model mapper may not able to map from location
    UserLocationDTO userLocationDTO=new UserLocationDTO();
    userLocationDTO=modelMapper.map(user,UserLocationDTO.class);
        return userLocationDTO;}

    private User convertDtoToEntity(UserLocationDTO userLocationDTO){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        User user=new User();
        user=modelMapper.map(userLocationDTO,User.class);
        return user;



}}
/*The line modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE); is used to configure the behavior of the ModelMapper library when mapping properties between objects. Here's a detailed explanation:

ModelMapper Overview:
ModelMapper is a Java library that simplifies the process of mapping between objects, often used to map between DTOs (Data Transfer Objects) and entities.

MatchingStrategies:
ModelMapper provides three matching strategies:

STRICT:

Requires exact matching between the property names of source and destination objects.
Used when precision is critical, and you want to avoid accidental mappings.
STANDARD:

The default strategy.
Allows for slight deviations in property names, such as camel case differences.
LOOSE:

Allows for flexible matching by relaxing the criteria for matching property names.
Ignores case differences and minor naming discrepancies (e.g., userName could map to username or user_name).
*/
