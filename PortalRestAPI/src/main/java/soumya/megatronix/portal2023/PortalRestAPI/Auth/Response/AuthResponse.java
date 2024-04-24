package soumya.megatronix.portal2023.PortalRestAPI.Auth.Response;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

    private String token;
}
