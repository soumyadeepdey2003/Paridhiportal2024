package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.repository.ValidationRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.request.ValidationRequest;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.response.AuthResponse;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.service.AdminService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("megatronix/paridhi/admin")
public class AdminController {

    @Qualifier("asyncExecutor")
    @Autowired
    private AsyncTaskExecutor asyncTaskExecutor;
    @Autowired
    private AdminService adminService;

    @Async
    @GetMapping("/registration")
    public CompletableFuture<ResponseEntity<ValidationRequest>> registrationForm() {
        CompletableFuture<ValidationRequest> future = CompletableFuture.supplyAsync(() -> {
            ValidationRequest user = new ValidationRequest();
            return user;
        }, asyncTaskExecutor);

        return future.thenApply(result -> ResponseEntity.ok().body(result))
                .exceptionally(ex -> {
                    System.out.println(ex.getMessage());
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
                });
    }

    @Async
    @PostMapping("/registration")
    public CompletableFuture<ResponseEntity<AuthResponse>> handleAdminRegistration (
            @RequestBody ValidationRequest admin
    ) {
        return adminService.register(admin)
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex -> {
                    Throwable cause = ex.getCause();
                    String errorMessage = cause != null ? cause.getMessage() : "Unknown error occurred";
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthResponse(errorMessage));
                });
    }

    @Async
    @PostMapping("/login")
    public CompletableFuture<ResponseEntity<AuthResponse>> handleLogin (
            @RequestBody ValidationRequest admin
    ) {
        return adminService.login(admin)
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex -> {
                    Throwable cause = ex.getCause();
                    String errorMessage = cause != null ? cause.getMessage() : "Unknown error occurred";
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthResponse(errorMessage));
                });
    }
}
