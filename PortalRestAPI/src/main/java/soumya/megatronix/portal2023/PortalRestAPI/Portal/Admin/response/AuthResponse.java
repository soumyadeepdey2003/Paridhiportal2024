package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// This class is used to send the JWT token back to the client
public class AuthResponse {
    private String jwt;
}