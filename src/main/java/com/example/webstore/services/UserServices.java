package com.example.webstore.services;

import com.example.webstore.models.AccountModels;
import com.example.webstore.models.CustomerModels;
import com.example.webstore.models.VerifyCode;
import com.example.webstore.repository.AccountRepository;
import com.example.webstore.repository.CustomerRepository;
import com.example.webstore.repository.VerifyCodeRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;


@Service
public class UserServices {

//    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VerifyCodeRepository repoCode;

    @Autowired
    private AccountRepository repoAccount;

    @Autowired
    private CustomerRepository repoCustomer;

    public void register(VerifyCode verifyCode, AccountModels account,CustomerModels customer , String url) {

        String randomCode = RandomString.make(64);
        verifyCode.setCode(randomCode);
        verifyCode.setAccountModels(account);

        repoAccount.save(account);
        repoCode.save(verifyCode);
        repoCustomer.save(customer);

        sendVerificationEmail(customer, verifyCode, url);
    }

    private void sendVerificationEmail(CustomerModels customer, VerifyCode code,String url) {
        String toAddress = customer.getAccountEmail();
        String senderName = "Web shop sport";
        String fromAddress = "thng1642@gamil.com";
        String subject = "Please verify you registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "Your company name.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setFrom(fromAddress, senderName);
            helper.setTo(toAddress);
            helper.setSubject(subject);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        content = content.replace("[[name]]", customer.getLastname());
        String verifyUrl = url + "/verify?code=" + code.getCode();
        content = content.replace("[[URL]]", verifyUrl);

        try {
            helper.setText(content,true);
        } catch (MessagingException e1) {
            e1.printStackTrace();
        }

        mailSender.send(message);
    }
}
