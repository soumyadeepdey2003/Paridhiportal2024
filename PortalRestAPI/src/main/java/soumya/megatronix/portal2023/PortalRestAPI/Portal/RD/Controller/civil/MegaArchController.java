package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Controller.civil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.civil.MegaArchModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Service.civil.MegaArchService;

import java.util.concurrent.CompletableFuture;

@RestController
@EnableAsync
@RequestMapping("/paridhi/event/civil")
public class MegaArchController {

  @Autowired
  private AsyncTaskExecutor asyncTaskExecutor;

  @Autowired
  private MegaArchService service;

  @GetMapping("/megaArch")
  @Async
  public CompletableFuture<ResponseEntity<MegaArchModel>> megaArchForm() {
    CompletableFuture<MegaArchModel> future = CompletableFuture.supplyAsync(() -> {
      // Here you can perform any necessary processing to prepare your data
      MegaArchModel user = new MegaArchModel();
      return user;
    }, asyncTaskExecutor);
    return future.thenApply(result -> ResponseEntity.ok().body(result))
        .exceptionally(ex-> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
  }

  @PostMapping("/megaArch")
  @Async
  public CompletableFuture<ResponseEntity<?>> megaArchMember(@RequestBody MegaArchModel member) {
    return service.MegaArchRd(member).thenApply(savedMember -> {
      if (savedMember != null && savedMember.getTid() != null) {
        return ResponseEntity.ok().body(savedMember.getTid());
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      }
    }).exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
  }

  @GetMapping("/megaArch/{gid}")
  @Async
  public CompletableFuture<ResponseEntity<?>> validateMegaArch(@RequestParam("gid") String gid) {
    return service.checkgid(gid).thenApply(savedMember -> {
      if (savedMember != null && savedMember.getGid() != null) {
        return ResponseEntity.ok().body(savedMember.getName());
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      }
    }) .exceptionally(ex -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
  }
}