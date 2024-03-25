package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.electrical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.electrical.Electrical1;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.electrical.Electrical2;

import java.util.List;
import java.util.Optional;

@Repository
public interface Electrical1Repository extends JpaRepository<Electrical1, Long> {


    Optional<Electrical1> findByGid(String gid);
}
