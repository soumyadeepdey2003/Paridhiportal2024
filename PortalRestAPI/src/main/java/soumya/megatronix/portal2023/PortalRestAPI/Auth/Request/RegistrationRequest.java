package soumya.megatronix.portal2023.PortalRestAPI.Auth.Request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {

    private String name;
    private String year;
    private String email;
    private String password;
}
