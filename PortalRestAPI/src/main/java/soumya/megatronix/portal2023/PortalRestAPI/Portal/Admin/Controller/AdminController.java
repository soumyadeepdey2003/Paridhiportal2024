package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Auth.Request.LoginRequest;
import soumya.megatronix.portal2023.PortalRestAPI.Auth.Request.RegistrationRequest;
import soumya.megatronix.portal2023.PortalRestAPI.Auth.Response.AuthResponse;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Service.AdminService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/auth")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //  register the user
    @Async
    @PostMapping("/register")
    public CompletableFuture<ResponseEntity<AuthResponse>> register (
            @RequestBody RegistrationRequest request
    ) {
        return adminService
                .registerAdmin(request)
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex -> ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    //  authenticate the user, basically login route
    @Async
    @PostMapping("/login")
    public CompletableFuture<ResponseEntity<AuthResponse>> login (
            @RequestBody LoginRequest request
    ) {
        return adminService
                .loginAdmin(request)
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

}
