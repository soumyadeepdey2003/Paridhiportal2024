package soumya.megatronix.portal2023.PortalRestAPI.Portal.Admin.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import soumya.megatronix.portal2023.PortalRestAPI.Configuration.AppConstants;

import javax.crypto.SecretKey;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtService {

    public String extractUsername ( String token ) {
        return extractClaim(token, Claims::getSubject);
    }

    public String generateToken ( UserDetails userDetails ) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken (
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        extraClaims.put("roles", "ROLE_ADMIN");

        return Jwts.builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + AppConstants.JWT_TOKEN_VALIDITY))
                .signWith(getSecretKey())
                .compact();
    }

    public boolean validateToken ( String token, UserDetails userDetails ) {
        final String username = extractUsername(token);
        System.out.println("Username: " + username);
        System.out.println("Roles: " + userDetails.getAuthorities());
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired ( String token ) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration ( String token ) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim ( String token, Function<Claims, T> claimsResolver) {
        final Claims claim = extractAllClaims(token);
        return claimsResolver.apply(claim);
    }

    private Claims extractAllClaims ( String token ) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSecretKey () {
        String SECRET_KEY = "5c9d8e5e678a8d2f2b01ab2c2c5f0e798d8e5e234678a8d2f2b01ab2c2c5f0e798d8e5e234678a8d2f2b01ab2c2c5f0e798d8e5e234678a8d2f2b01ab2c2c5f0e798d8e5e234678a8d2f2b01ab2c2c5f0e798d8e5e234678a8d2f2b01ab2c2c5f0e798";
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
