package alkemy.disney.auth.controller;

import alkemy.disney.auth.dto.AuthenticationRequest;
import alkemy.disney.auth.dto.AuthenticationResponse;
import alkemy.disney.auth.dto.UserDTO;
import alkemy.disney.auth.service.JwtUtils;
import alkemy.disney.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserAuthController{

    @Autowired
    private UserDetailsCustomService userDetailsCustomService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;

        @PostMapping("/singup")
            public ResponseEntity<AuthenticationResponse> singUp(@Valid @RequestBody UserDTO user) throws Exception {
            this.userDetailsCustomService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        @PostMapping("/login")
        public ResponseEntity<AuthenticationResponse> singin(@Valid @RequestBody AuthenticationRequest authenticationRequest) throws Exception{
            UserDetails userDetails;
            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
                );
                userDetails =(UserDetails) authentication.getPrincipal();
            }
            catch (BadCredentialsException e){
                throw new Exception("Incorrect username or password, e");
            }
            final String jwt = jwtUtils.generateToken(userDetails);
            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        }
}