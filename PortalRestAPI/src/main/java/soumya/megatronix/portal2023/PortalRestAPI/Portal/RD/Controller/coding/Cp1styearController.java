package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Controller.coding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.Cp1styearModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.coding.Cp1styearRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.coding.Cp1styearService;

import java.util.concurrent.CompletableFuture;

@RestController
@EnableAsync
@RequestMapping("/paridhi/event/coding")
public class Cp1styearController {

    @Autowired
    private AsyncTaskExecutor asyncTaskExecutor;

    @Autowired
    private Cp1styearService service;

    @GetMapping("/1styearcp")
    @Async
    public CompletableFuture<ResponseEntity<Cp1styearModel>> Cp1styearForm() {
         CompletableFuture<Cp1styearModel> future = CompletableFuture.supplyAsync(() -> {
             // Here you can perform any necessary processing to prepare your data
             Cp1styearModel user = new Cp1styearModel();
             return user;
         }, asyncTaskExecutor);
        return future.thenApply(result -> ResponseEntity.ok().body(result))
                .exceptionally(ex-> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }

    @PostMapping("/1styearcp")
    @Async
    public CompletableFuture<ResponseEntity<?>> Cp1styearMember(@RequestBody Cp1styearModel member) {
         return service.Cp1styearRd(member).thenApply(savedMember -> {
             if (savedMember != null && savedMember.getTid() != null) {
                 return ResponseEntity.ok().body(savedMember.getTid());
             } else {
                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
             }
         }).exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage()));

    }

    @GetMapping("/1styearcp/{gid}")
    @Async
<<<<<<< HEAD
    public CompletableFuture<ResponseEntity<?>> validateCp1styear(@RequestParam("gid") String gid) {
         return service.checkgid(gid).thenApply(savedMember -> {
=======
    public CompletableFuture<ResponseEntity<?>> validateCp1styear(@PathVariable("gid") String gid) {
         return service.chackgid(gid).thenApply(savedMember -> {
>>>>>>> 4c2fc980c5f75e44f7f2cf08efc591bdb1ab963b
             if (savedMember != null && savedMember.getGid() != null) {
                 return ResponseEntity.ok().body(savedMember.getName());
             } else {
                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
             }
         }) .exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }
}
