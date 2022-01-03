import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created By Arjun Gautam
 * Date :03/01/2022
 * Time :7:36 PM
 * Project Name :JavaMailDemo
 */

public class SendMail extends Authenticator {

    static String from="arjuncodesdemo@gmail.com";
    static String pass="Generate password from gmail password generator";
    static InternetAddress to;

    public static void main(String[] args) throws MessagingException {
        //Get the session object
        Properties properties=System.getProperties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        //start TLS (transport layer security)
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.password",pass);
        Session session=Session.getDefaultInstance(properties);

        //Compose a message
        MimeMessage msg=new MimeMessage(session);
        msg.setFrom(new InternetAddress("arjuncodesdemo@gmail.com"));

        to=new InternetAddress("arjungautam5431@gmail.com");

        msg.addRecipient(Message.RecipientType.TO,to);
        msg.setSubject("Test Java Mail");
        msg.setText("Hello, This is from Arjun Codes Demo");
        //Send Message
        Transport transport=session.getTransport("smtp");
        transport.connect("smtp.gmail.com",from,pass);
        transport.sendMessage(msg,msg.getAllRecipients());
        System.out.print("Message send success...");


    }

}
