package soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Repository.civil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.RD.Model.civil.MegaArchModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface MegaArchRepository extends JpaRepository<MegaArchModel, Long> {
    List<MegaArchModel> findBySelectedcivilevent(String selectedcivilevent);

   Optional< MegaArchModel> findByGid(String gid);
}
