package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Check.Gid.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Check.Gid.Service.CheckGidService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/admin/checkGid")
public class CheckGidController {

    @Autowired
    private CheckGidService service;

    @Async
    @GetMapping("/{gid}")
    public CompletableFuture<ResponseEntity<?>> checkGid(
            @PathVariable("gid") String gid
    ) {
        return CompletableFuture.completedFuture(service.checkGidAdmin(gid))
                .thenApply(sucess -> {
                    if(sucess != null)
                        return ResponseEntity.ok(sucess);
                    else
                        return ResponseEntity.notFound().build();
                }).exceptionally(ex ->ResponseEntity.badRequest().body(ex.getMessage()));
    }
}
