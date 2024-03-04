package soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.MRD.Model.MrdModel;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.coding.Cp1styearModel;

@Repository
public interface MrdRepository  extends JpaRepository<MrdModel,Long> {

    MrdModel getModelByGid(String gid);
}
