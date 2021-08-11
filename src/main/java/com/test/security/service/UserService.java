package com.test.security.service;

import com.test.security.dto.UserDto;
import com.test.security.enums.Status;
import com.test.security.exeptions.UserAlreadyRegisteredException;
import com.test.security.model.User;
import com.test.security.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@Data
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void creatUser(UserDto userDto){
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()){
            throw new UserAlreadyRegisteredException("USER WITH "+ userDto.getEmail() + " IS EXISTED");
        }else{
            User user = new User();
            user.setEmail(userDto.getEmail());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setUserName(userDto.getUserName());
            user.setSurName(userDto.getSurName());

            userRepository.save(user);
        }

    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new UsernameNotFoundException("User not found "));
        if(user!=null){
            userRepository.delete(user);
        }
    }

    public User getUser(String email) {
        return userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User"+ email+ "not found "));
    }

    public User makeStatusBan(Long id) {
             User user=  userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("User"+ id+ "not found "));
             user.setStatus(Status.BANNED);
             userRepository.save(user);
        return user;
    }
    public User makeStatusActive(Long id) {
             User user=  userRepository.findById(id).orElseThrow(()-> new UsernameNotFoundException("User"+ id+ "not found "));
             user.setStatus(Status.ACTIVE);
             userRepository.save(user);
        return user;
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
