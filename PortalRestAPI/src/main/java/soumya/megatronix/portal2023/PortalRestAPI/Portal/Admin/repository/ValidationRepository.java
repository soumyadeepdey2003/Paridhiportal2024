package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.response.ValidationResponse;

import java.util.Optional;

@Repository
public interface ValidationRepository extends JpaRepository< ValidationResponse, Long > {

    Optional< ValidationResponse > findByUsername( String username);

}
