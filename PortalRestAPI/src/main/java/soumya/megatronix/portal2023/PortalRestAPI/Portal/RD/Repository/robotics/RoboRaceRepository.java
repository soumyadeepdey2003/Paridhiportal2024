package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.robotics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.robotics.RoboRaceModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoboRaceRepository extends JpaRepository<RoboRaceModel, Long> {


    Optional<RoboRaceModel> findByGid1(String gid);

    Optional<RoboRaceModel> findByGid2(String gid);

    Optional<RoboRaceModel> findByGid3(String gid);

    Optional<RoboRaceModel> findByGid4(String gid);

    Optional<RoboRaceModel> findByGid5(String gid);
}
