package soumya.megatronix.portal2023.PortalRestAPI.Portal.Profile.mainprofile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Profile.mainprofile.model.profileModel;

@Repository
public interface profilerepository extends JpaRepository<profileModel, Long> {

    profileModel findByGid(String gid);
}
