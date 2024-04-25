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
        String message = "Hello " + name + ", \n" +
                "\n" +
                "Congratulations on registering for Paridhi 2024, your GID is " + gid + ".\n" +
                "\n" +
                "We're thrilled to have you on board and look forward to your participation in our upcoming events.\n" +
                "\n" +
                "Best Regards,\n" +
                "Team Megatronix.";

        return sendEmail(email, subject, message)
                .thenApplyAsync(result -> true)
                .exceptionally(ex -> {
                    System.out.println(ex.getMessage());
                    return false;
                });
    }

    @Async
    public void sendEventRegistrationEmail(String tid, String eventName, String teamName, String... emails) {
        String subject = "Welcome to Paridhi!";
        String message = "Hello " + teamName + ", \n" +
                "\n" +
                "Congratulations on registering for " + eventName + " in Paridhi 2024, your TID is " + tid + ".\n" +
                "\n" +
                "We're thrilled to have you on board and look forward to your participation in our upcoming events.\n" +
                "\n" +
                "Best Regards,\n" +
                "Team Megatronix.";

        sendEmail(subject, message, emails);
    }
}
