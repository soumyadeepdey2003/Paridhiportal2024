package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.civil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.civil.TrackOTeasureModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrackOTeasureRepository extends JpaRepository<TrackOTeasureModel, Long> {

    Optional<TrackOTeasureModel> findByGid(String gid);
}
