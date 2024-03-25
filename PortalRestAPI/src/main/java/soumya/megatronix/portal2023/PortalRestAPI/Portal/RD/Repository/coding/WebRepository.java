package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.coding;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.CpAllyearModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.WebModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface WebRepository extends JpaRepository<WebModel, Long> {
    List<WebModel> findBySelectedcodingevent(String selectedcodingevent);

    Optional<WebModel> findByGid(String gid);
}
