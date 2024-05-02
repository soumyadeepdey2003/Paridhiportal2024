package soumya.megatronix.portal2023.PortalRestAPI.Verification.Email.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
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

    @Async
    public CompletableFuture<Void> sendEmail(String subject, String message, String... emails) {
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(emails);
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

    @Async
    public CompletableFuture<Boolean> sendRegistrationMail(String email, String gid, String name) {
        String subject = "Welcome to Paridhi!";
        String message = "<html><body>" +
                "<h1>Hello " + name + ",</h1>" +
                "<p>" +
                "<br>" +
                "Congratulations on registering for <strong>Paridhi 2024</strong>, your GID is <strong>" + gid + "</strong>.<br>" +
                "<br>" +
                "We're thrilled to have you on board and look forward to your participation in our upcoming events.<br>" +
                "<br>" +
                "Best Regards,<br>" +
                "<strong>Team Megatronix</strong>." +
                "</p>" +
                "</body></html>";

        return sendEmail(email, subject, message) // specify MIME type as text/html
                .thenApplyAsync(result -> true)
                .exceptionally(ex -> {
                    System.out.println(ex.getMessage());
                    return false;
                });
    }

    @Async
    public void sendEventRegistrationEmail(String tid, String eventName, String teamName, String... emails) {
        String subject = "Welcome to Paridhi!";
        String message = "<html><body>" +
                "<h1>Hello " + teamName + ",</h1>" +
                "<p>" +
                "<br>" +
                "Congratulations on registering for <strong>" + eventName + "</strong> in Paridhi 2024, your TID is <strong>" + tid + "</strong>.<br>" +
                "<br>" +
                "We're thrilled to have you on board and look forward to your participation in our upcoming events.<br>" +
                "<br>" +
                "Best Regards,<br>" +
                "<strong>Team Megatronix</strong>." +
                "</p>" +
                "</body></html>";

        sendEmail(subject, message, emails);
    }
}
