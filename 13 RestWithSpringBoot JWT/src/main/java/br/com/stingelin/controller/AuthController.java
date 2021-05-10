package br.com.stingelin.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.stingelin.repository.UserRepository;
import br.com.stingelin.security.AccountCredentialsVo;
import br.com.stingelin.security.jwt.JwtTokenProvider;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserRepository repository;

    @ApiOperation(value = "Authenticate user by credentials")
    @PostMapping(value = "/signin", produces = { "application/json", "application/xml",
            "application/x-yaml" }, consumes = { "application/json", "application/xml", "application/x-yaml" })
    public ResponseEntity<Map<Object, Object>> signin(@RequestBody AccountCredentialsVo data) {
        try {
            var username = data.getUsername();
            var password = data.getPassword();
            var user = repository.findByUsername(username);
            var token = "";
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            if (user != null) {
                token = tokenProvider.createToken(username, user.getRoles());
            } else {
                throw new UsernameNotFoundException("Username " + username + " not found!");
            }

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied!");
        }
    }

}
