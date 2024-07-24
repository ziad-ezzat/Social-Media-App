package com.example.server.controllers;

import com.example.server.models.LoginRequest;
import com.example.server.models.RegisterRequest;
import com.example.server.models.User;
import com.example.server.repositories.UserRepo;
import com.example.server.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest)  {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            return new ResponseEntity<>(jwtUtil.generateToken(
                    loginRequest.getEmail(),
                    userRepository.findByEmail(loginRequest.getEmail()).map(User::getId).orElse(null),
                    userRepository.findByEmail(loginRequest.getEmail()).get().getName()+
                            " "+ userRepository.findByEmail(loginRequest.getEmail()).get().getLastName()
            )
                    , HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest){

        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()){
            return new ResponseEntity<>("Email already exist",HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setName(registerRequest.getName());
        user.setLastName(registerRequest.getLastName());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registerRequest.getEmail(), registerRequest.getPassword())
        );
        return new ResponseEntity<>(jwtUtil.generateToken(
                registerRequest.getEmail(),
                userRepository.findByEmail(registerRequest.getEmail()).map(User::getId).orElse(null),
                registerRequest.getName() +" "+registerRequest.getLastName()
        )
                ,HttpStatus.OK
        );
    }

}