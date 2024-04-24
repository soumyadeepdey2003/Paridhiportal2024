package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Auth.Request.LoginRequest;
import soumya.megatronix.portal2023.PortalRestAPI.Auth.Request.RegistrationRequest;
import soumya.megatronix.portal2023.PortalRestAPI.Auth.Response.AuthResponse;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Model.AdminModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Repository.AdminRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Security.JwtService;

import java.util.concurrent.CompletableFuture;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Async
    public CompletableFuture<AuthResponse> registerAdmin (RegistrationRequest registrationRequest)
    {
        AdminModel admin = new AdminModel();
        admin.setName(registrationRequest.getName());
        admin.setEmail(registrationRequest.getEmail());
        admin.setYear(registrationRequest.getYear());
        admin.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));

        adminRepository.save(admin);

        return CompletableFuture.completedFuture(response(admin));
    }

    @Async
    public CompletableFuture< AuthResponse > loginAdmin (LoginRequest loginRequest)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        AdminModel admin = adminRepository
                .findByEmail(loginRequest.getEmail())
                .orElseThrow( () -> new RuntimeException("User not found"));

        return CompletableFuture.completedFuture(response(admin));
    }

    private AuthResponse response ( AdminModel admin)
    {
        String token = jwtService.generateToken(admin);
        return AuthResponse
                .builder()
                .token(token)
                .build();
    }
}
