package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Update.Tid.electrical.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Update.Tid.electrical.Service.ElectricalTidService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/admin/checkTid/")
public class ElectricalTidController {

    @Autowired
    private ElectricalTidService service;

    @Async
    @PutMapping("/electrical/electri-quest/{tid}/{paid}")
    public CompletableFuture<ResponseEntity<?>> checkElectriQuestTid (
            @PathVariable("tid") String tid,
            @PathVariable("paid") Boolean paid
    ) {
        return CompletableFuture.completedFuture(service.checkElectriQeustTid(tid, paid))
                .thenApply(savedMember -> {
                    if (savedMember != null) {
                        return ResponseEntity.ok().body(savedMember);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

    @Async
    @PutMapping("/electrical/electrical2/{tid}/{paid}")
    public CompletableFuture<ResponseEntity<?>> checkElectrical2Tid(
            @PathVariable("tid") String tid,
            @PathVariable("paid") Boolean paid
    ) {
        return CompletableFuture.completedFuture(service.checkElectrical2Tid(tid, paid))
                .thenApply(savedMember -> {
                    if (savedMember != null) {
                        return ResponseEntity.ok().body(savedMember);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                }).exceptionally(ex -> ResponseEntity.badRequest().body(ex.getMessage()));
    }

}
