package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Controller.electrical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.electrical.Electrical1;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.electrical.Electrical1Service;

import java.util.concurrent.CompletableFuture;

@RestController
@EnableAsync
@RequestMapping("/paridhi/event/electrical")
public class Electrical1Controller {

  @Autowired
  private AsyncTaskExecutor asyncTaskExecutor;

  @Autowired
  private Electrical1Service service;

  @GetMapping("/electrical1")
  @Async
  public CompletableFuture<ResponseEntity<Electrical1>> electrical1Form() {
    CompletableFuture<Electrical1> future = CompletableFuture.supplyAsync(() -> {
      // Here you can perform any necessary processing to prepare your data
      Electrical1 user = new Electrical1();
      return user;
    }, asyncTaskExecutor);
    return future.thenApply(result -> ResponseEntity.ok().body(result))
        .exceptionally(ex-> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
  }

  @PostMapping("/electrical1")
  @Async
  public CompletableFuture<ResponseEntity<?>> electrical1Member(@RequestBody Electrical1 member) {
    return service.Electrical1Rd(member).thenApply(savedMember -> {
      if (savedMember != null && savedMember.getTid() != null) {
        return ResponseEntity.ok().body(savedMember.getTid());
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      }
    }).exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
  }

  @GetMapping("/electrical1/{gid}")
  @Async
  public CompletableFuture<ResponseEntity<?>> validateelectrical1(@PathVariable("gid") String gid) {
    return service.checkgid(gid).thenApply(savedMember -> {
      if (savedMember != null && savedMember.getGid() != null) {
        return ResponseEntity.ok().body(savedMember.getName());
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      }
    }) .exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage()));
  }
}