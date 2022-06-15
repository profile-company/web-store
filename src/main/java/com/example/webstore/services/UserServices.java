package com.example.webstore.services;

import com.example.webstore.models.AccountModels;
import com.example.webstore.models.CustomerModels;
import com.example.webstore.models.VerifyCode;
import com.example.webstore.repository.AccountRepository;
import com.example.webstore.repository.CustomerRepository;
import com.example.webstore.repository.VerifyCodeRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

/**
 * The UserServices class provides services for user when sign up.
 * @author Nguyen Thuan
 * @version 1.00 30 May 2022
 *
 * Modification Logs:
 *      DATE            AUTHOR          DESCRIPTION
 * -------------------------------------------------------------------------
 *      30-May-2022     Nguyen Thuan    Encoded password before save into DB
 */
@Service
public class UserServices {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private VerifyCodeRepository repoCode;

    @Autowired
    private CustomerRepository repoCustomer;

    @Autowired
    private AccountRepository repoAccount;

    public void register(AccountModels account, CustomerModels customer,
            String url) {

        String randomCode = RandomString.make(64);
        VerifyCode verifyCode = new VerifyCode();
        verifyCode.setCode(randomCode);
        verifyCode.setEmail(account.getEmail());

        /**
         * Save objects (AccountModels, VerifyCode and CustomerModels)
         * into database of system.
         */
        repoAccount.insertNewAccount(account.getEmail(), account.getPassword(),
                account.getDateCreate(), account.isEnabled());
//        repoAccount.save(account);
        repoCustomer.insertNewCustomer(customer.getFirstname(), customer.getLastname(),
                customer.getDateBorn(), customer.getSex(), customer.getAccountEmail());
        repoCode.save(verifyCode);

        /** Performing send token for e-mail which user inputted before. */
        sendVerificationEmail(customer, verifyCode, url);
    }

    /**
     * Send mail to user verify account.
     * @param customer to show information user.
     * @param code get code to attach with email.
     * @param url get url to verify.
     */
    private void sendVerificationEmail(CustomerModels customer, VerifyCode code,
            String url) {

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

    /**
     * Check code, and action something update data.
     * @param email get address email.
     * @param code get code.
     * @return return result checking.
     */
    public boolean verify(String email, String code) {

        String myCode = repoCode.findVerifyCodeByEmail(email);

        if (code.equals(myCode)) {

            repoAccount.updateEnabled(true, email);
            repoCode.deleteVerifyCodeOfAccount(email);

            return true;
        }
        else {return false;}
    }
}
