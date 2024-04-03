package soumya.megatronix.portal2023.PortalRestAPI.Verification.Email.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public CompletableFuture<Void> sendEmail(String email, String subject, String message) {
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(message, true);
            javaMailSender.send(mimeMessage);

            completableFuture.complete(null);
        } catch (MessagingException ex) {
            System.out.println(ex.getMessage());
            completableFuture.completeExceptionally(ex);
        }

        return completableFuture;
    }
}
