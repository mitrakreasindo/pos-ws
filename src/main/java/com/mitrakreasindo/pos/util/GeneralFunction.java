package com.mitrakreasindo.pos.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.postgresql.util.PGobject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitrakreasindo.pos.entities.MerchantRegistration;

/**
 *
 * @author Asun
 */
public class GeneralFunction {
    public static String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(password.getBytes("UTF-8"));

        return new BigInteger(1, crypt.digest()).toString(16);
    }
    
    public static String checkNullString(String input){
        if(input == null){
            return "";
        }
        else return input;
    }
    
    public static Date checkNullDate(Date input){
        if(input == null){
            return new Date();
        }
        else return input;
    }
    
    public static LocalDateTime checkNullDate(LocalDateTime input){
        if(input == null){
            return LocalDateTime.now();
        }
        else return input;
    }
    
    public static byte[] checkNullByte(byte[] input){
        if(input == null){
            return new byte[0];
        }
        else return input;
    }
    
    
  public static String randomChar(String input, int position)
  {
    Random r = new Random();
    return input.charAt(r.nextInt(position))+"";
  }
  
  //Create 8 digit password
  //  Password criteria : 
  //-	8-10 char
  //-	1 special character (character atas keyboard kecuali 9-0)
  //-	1 digit
  //-	1 lower
  //-	1 upper
  //-	No white space
  public static String generatePassword()
  {
    String huruf = "abcdefghijklmnopqrstuvwxyz";
    String spesial = "!@~-";
    String angka = "0123456789";
    
    int huruflength = huruf.length();
    int spesiallength = spesial.length();
    int angkalength = angka.length();
    
    String satudua = randomChar(huruf, huruflength).toUpperCase() + randomChar(huruf, huruflength);
    String tigaempat = randomChar(spesial, spesiallength) + randomChar(angka, angkalength);
    String limaenam = randomChar(huruf, huruflength).toUpperCase() + randomChar(huruf, huruflength);
    String tujulapan = randomChar(spesial, spesiallength) + randomChar(angka, angkalength);
    
    String password = satudua + tigaempat + limaenam + tujulapan;
    
    return password;
  }
  
  public static String emailTemplate(MerchantRegistration entity)
  {  
    String content = "Dear, "+entity.getPeople().getFullname()+" <br><br>"
            + "Selamat registrasi merchant anda berhasil.<br>"
            + "Informasi akun anda adalah sebagai berikut : <br>"
            + "<b>Merchant</b><br>"
            + "Merchant Code : "+ entity.getMerchant().getCode()+" <br>"
            + "Merchant Name : "+ entity.getMerchant().getName()+" <br>"
            + "<b>Owner<br></b>"
            + "Username : "+ entity.getPeople().getName()+" <br>"
            + "Password : "+ entity.getPeople().getApppassword()+" <br><br>"
            + "Silahkan gunakan kombinasi merchant code, username dan password anda untuk masuk ke aplikasi<br><br>"
            + "Regards,<br>"
            + "POS++ Team";
    return content;
  }
  
  //Send registration email
  public static boolean sendRegistrationMail(MerchantRegistration entity)
  {
      String from = "pos@mitrakreasindo.com";
      String todefault = "hendric@mitrakreasindo.com";
      String to = entity.getPeople().getEmail();
      String pwd = "pos54321";
      
      // Assuming you are sending email from localhost
      String host = "mail.mitrakreasindo.com";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.put("mail.smtp.host", host);
      properties.put("mail.smtp.user", from);
      properties.put("mail.smtp.password", pwd);
      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.starttls.enable", "true");
      properties.put("mail.smtp.port", "587");
      
      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(todefault));
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("MK POS Regisrasi Merchant berhasil");

         // Send the actual HTML message, as big as you like
         message.setContent(emailTemplate(entity), "text/html");

         // Send message
         Transport transport = session.getTransport("smtp");
         transport.connect(host, from, pwd);
         transport.sendMessage(message, message.getAllRecipients());
         transport.close();
         //Transport.send(message);
         System.out.println("Sent message successfully....");
         
         return true;
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
      return false;
  }
  
  //Convert object array to jsonstring
  public static String convert2Json(Object input)
  {
    boolean result = true;
    ObjectMapper mapper = new ObjectMapper();
    String jsoninString = "";
    try
    {
      //Object to JSON in String
      jsoninString = mapper.writeValueAsString(input);
      //System.out.println(jsoninString);
      PGobject jsonObject = new PGobject();
      jsonObject.setType("json");
      jsonObject.setValue(jsoninString);
    }
    catch (IOException | SQLException ex )
    {
      Logger.getLogger(GeneralFunction.class.getName()).log(Level.SEVERE, null, ex);
      result = false;
    }
    
    if(result == true)
    {
      return jsoninString;
    }
    else return "failed";
  }
  
  public static Date dateFormatter()
  {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    Date date = new Date();
    try
    {
      date = dateFormat.parse(new Date().toString());
    }
    catch (ParseException ex)
    {
      Logger.getLogger(GeneralFunction.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return date;
  }
  
  public static String date2String(Date date)
  {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String outputdate = "";
    
    outputdate = dateFormat.format(date);
    
    return outputdate;
  }
	
}
