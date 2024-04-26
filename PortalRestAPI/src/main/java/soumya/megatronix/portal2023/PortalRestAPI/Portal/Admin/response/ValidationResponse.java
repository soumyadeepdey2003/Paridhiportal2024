package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.response;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.Async;

@Data
@Async
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ValidationResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String username;
    String password;
    private String role="ADMIN"; //Eg: ADMIN,USER
    private boolean isEmailVerified;
}
