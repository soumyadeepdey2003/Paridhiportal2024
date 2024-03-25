package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.coding;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.CpAllyearModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface CpAllyearRepository extends JpaRepository<CpAllyearModel, Long> {
    List<CpAllyearModel> findBySelectedcodingevent(String selectedcodingevent);

    Optional<CpAllyearModel> findByGid(String gid);
}