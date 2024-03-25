package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.robotics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.robotics.War15KgModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface War15KgRepository extends JpaRepository<War15KgModel, Long> {
    Optional<War15KgModel> findByGid(String gid);
}
