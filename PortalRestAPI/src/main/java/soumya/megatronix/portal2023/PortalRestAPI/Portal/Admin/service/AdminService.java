package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.model.Admin;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.repository.AdminRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.repository.ValidationRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.request.ValidationRequest;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.response.AuthResponse;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.security.JwtService;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;


//    @Override
//    public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
//        Optional<ValidationRequest> admin = validationRepository.findByUsername(username);
//        if ( admin.isPresent() ) {
//            ValidationRequest user = admin.get();
//            return User.builder()
//                    .username(user.getUsername())
//                    .password(user.getPassword())
//                    .roles(getRoles(user))
//                    .build();
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//    }

    @Async
    public CompletableFuture<AuthResponse> register (
            ValidationRequest admin
    ) {
        if(admin.isEmailVerified()) {
            Optional<Admin> adminOptional = adminRepository.findByUsername(admin.getUsername());
            if(adminOptional.isPresent()) {
                Optional<ValidationRequest> userOptional = validationRepository.findByUsername(admin.getUsername());
                if(userOptional.isPresent()) {
                    throw new RuntimeException("Email already exists");
                }
                ValidationRequest user = new ValidationRequest();
                user.setUsername(admin.getUsername());
                user.setPassword(passwordEncoder.encode(admin.getPassword()));
                user.setRole(admin.getRole());
                user.setEmailVerified(true);

                validationRepository.save(user);
                return CompletableFuture.completedFuture(new AuthResponse(jwtService.generateToken(user)));
            } else {
                throw new RuntimeException("Admin not found");
            }
        } else {
            throw new RuntimeException("Email not verified");
        }
    }

    @Async
    public CompletableFuture<AuthResponse> login (
            ValidationRequest admin
    ) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        admin.getUsername(),
                        admin.getPassword()
                )
        );

        ValidationRequest user = validationRepository
                .findByUsername(admin.getUsername())
                .orElseThrow( () -> new UsernameNotFoundException("User not found"));

        return CompletableFuture.completedFuture(new AuthResponse(jwtService.generateToken(user)));
    }
}
