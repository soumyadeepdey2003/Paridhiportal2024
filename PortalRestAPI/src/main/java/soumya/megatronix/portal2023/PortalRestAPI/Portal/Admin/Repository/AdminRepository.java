package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.Model.AdminModel;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel, Integer> {

    Optional<AdminModel> findByEmail (String email);

}
