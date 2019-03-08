import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


public class sample {
public static void main(String[] args) throws EmailException {
	 Email email = new SimpleEmail();
     email.setSmtpPort(587);
     email.setAuthenticator(new DefaultAuthenticator("chainsys97@gmail.com",
             "googlechrome"));
     email.setDebug(false);
     email.setHostName("smtp.gmail.com");
     email.setFrom("chainsys97@gmail.com");
     email.setSubject("Hi");
     email.setMsg("This is a test mail ... :-)");
     email.addTo("karthikeyan.devaraj@chainsys.com");
     email.setStartTLSEnabled(true);
     email.send();
     System.out.println("Mail sent!");
}
}
