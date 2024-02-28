package soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Model.MrdModel;

@Repository
public interface MrdRepository  extends JpaRepository<MrdModel,Long> {
}
