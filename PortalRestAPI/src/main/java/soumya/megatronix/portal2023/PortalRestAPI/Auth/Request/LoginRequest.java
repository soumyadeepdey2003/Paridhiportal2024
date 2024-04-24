package soumya.megatronix.portal2023.PortalRestAPI.Auth.Request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    private String email;
    private String password;
}
