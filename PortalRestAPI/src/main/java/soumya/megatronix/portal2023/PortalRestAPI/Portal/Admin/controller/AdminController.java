package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.model.Admin;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.repository.AdminRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.repository.ValidationRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.response.ValidationResponse;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.service.AdminService;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("megatronix/paridhi/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ValidationRepository validateRepository;
    @Qualifier("asyncExecutor")
    @Autowired
    private AsyncTaskExecutor asyncTaskExecutor;
    @Autowired
    private AdminRepository adminRepository;

    @Async
    @GetMapping("/registration")
    public CompletableFuture<ResponseEntity< ValidationResponse >> registrationForm() {
        CompletableFuture< ValidationResponse > future = CompletableFuture.supplyAsync(() -> {
            ValidationResponse user = new ValidationResponse();
            return user;
        }, asyncTaskExecutor);

        return future.thenApply(result -> ResponseEntity.ok().body(result))
                .exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }

    @Async
    @PostMapping("/registration")
    public CompletableFuture< ResponseEntity <?> > handleAdminRegistration(
            @RequestBody ValidationResponse admin
    ) {
        if(admin.isEmailVerified()){
            Optional< Admin > adminOptional = adminRepository.findByUsername(admin.getUsername());
            if ( adminOptional.isPresent() ) {
                admin.setPassword(passwordEncoder.encode(admin.getPassword()));
                return CompletableFuture.completedFuture(validateRepository.save(admin))
                        .thenApply(savedAdmin -> {
                            if ( savedAdmin != null ) {
                                return ResponseEntity.ok().body(savedAdmin);
                            } else {
                                return ResponseEntity.notFound().build();
                            }
                        }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
            }
        }
        return CompletableFuture.completedFuture(ResponseEntity.badRequest().body("Email not verified"));
    }
}
