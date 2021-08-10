package com.test.security.service;

import com.test.security.dto.UserDto;
import com.test.security.exeptions.UserAlreadyRegisteredException;
import com.test.security.model.User;
import com.test.security.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
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
}
