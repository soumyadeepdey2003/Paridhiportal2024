package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.robotics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.robotics.RoboSoccerModel;

@Repository
public interface RoboSoccerRepository extends JpaRepository<RoboSoccerModel, Long> {
}
