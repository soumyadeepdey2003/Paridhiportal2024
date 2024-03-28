package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.robotics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.robotics.LFRModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface LFRRepository extends JpaRepository<LFRModel, Long> {


    Optional<LFRModel> findByGid1(String gid);

    Optional<LFRModel> findByGid2(String gid);

    Optional<LFRModel> findByGid3(String gid);

    Optional<LFRModel> findByGid4(String gid);

    Optional<LFRModel> findByGid5(String gid);
}
