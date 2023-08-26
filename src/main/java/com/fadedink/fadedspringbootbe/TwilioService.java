package com.fadedink.fadedspringbootbe;

import org.springframework.beans.factory.annotation.Value;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {
    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String twilioPhoneNumber;

    @Value("${twilio.whatsappNumber}")
    private String twilioWhatsappNumber;

    public void sendSMS(String toPhoneNumber, String messageBody) {
        Twilio.init(accountSid, authToken);
        Message message = Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(twilioPhoneNumber),
                messageBody
        ).create();

        System.out.println("Message SID: " + message.getSid());
    }

    public void sendWhatsAppMessage(String toPhoneNumber, String messageBody) {
        Twilio.init(accountSid, authToken);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + toPhoneNumber),
                new com.twilio.type.PhoneNumber("whatsapp:" + twilioWhatsappNumber),
                messageBody
        ).create();

        System.out.println("Message SID: " + message.getSid());
    }
}
