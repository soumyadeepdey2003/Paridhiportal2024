package soumya.megatronix.portal2023.PortalRestAPI.Portal.Profile.mainprofile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Profile.mainprofile.model.profileModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Profile.mainprofile.service.ProfileService;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/megatronix/paridhi/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;
    @GetMapping("/{gid}")
    public CompletableFuture<ResponseEntity<profileModel>> getprofilebygid(@PathVariable("gid") String gid) throws Exception {
        return profileService.findProfile(gid).thenApply(ResponseEntity::ok)
                .exceptionally(completableFuture -> ResponseEntity.notFound().build());
    }
}
