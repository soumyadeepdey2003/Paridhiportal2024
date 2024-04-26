package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.repository.AdminRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.repository.ValidationRepository;
import soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.response.ValidationResponse;

import java.util.Optional;

@Service
public class AdminService implements UserDetailsService {

    @Autowired
    private ValidationRepository validationRepository;
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
        Optional< ValidationResponse > admin = validationRepository.findByUsername(username);
        if ( admin.isPresent() ) {
            ValidationResponse user = admin.get();
            return User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles(getRoles(user))
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    private String[] getRoles(ValidationResponse admin) {
        if (admin.getRole() == null) {
            return new String[]{"USER"};
        }
        return admin.getRole().split(",");
    }
}
