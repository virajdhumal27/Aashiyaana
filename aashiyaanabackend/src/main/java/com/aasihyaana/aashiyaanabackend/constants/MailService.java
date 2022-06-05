package com.aasihyaana.aashiyaanabackend.constants;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public Integer sendOtpMail(String from, String to) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        String otp = OTPGenerator.generateOtp();
        Integer otpId = OTPGenerator.addOtp(otp);

        try {
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject("[Aashiyaana] Signup Verification");
            
            String body = createBody(otp);
            
            helper.setText(body, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(mimeMessage);

        return otpId;
    }

    private String createBody(String otp) {
        String body = "<p><strong>Hello Username</strong>,</p>"
        +"<p>This message is from Aashiyaana.<br />"
        +"The OTP is sent to verify your signup at Aashiyaana.</p>"
        +"<p>Please enter the OTP to complete your signup process.</p>"
        +"<h2>Code: " + otp +"</h2>"
        +"<p><strong>The OTP will be valid for 3 minutes. Do not share it with anyone.</strong></p><br />"
        +"<p>Thank you,<br />"
        +"Team Aashiyaana</p>";

        return body;
    }
}
