package pl.pollub.camp.Services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.pollub.camp.Models.DTO.LoginRequest;
import pl.pollub.camp.Models.DTO.RegisterRequest;
import pl.pollub.camp.Models.Users;
import pl.pollub.camp.Repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService{
    private final UserRepository userRepository;
    @Autowired
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void register(RegisterRequest registerRequest){
        ///TODO dodać unikanosc nazw uzytkownikow
        Users u = new Users(registerRequest.getUsername(),
                registerRequest.getEmail(),
                bCryptPasswordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(u);
    }

    public String login(LoginRequest loginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        Users u = userRepository.findByName(loginRequest.getUsername()).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return jwtService.generateToken(u);
    }
}
