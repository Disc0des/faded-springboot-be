package com.fadedink.fadedspringbootbe.controllers;

import com.fadedink.fadedspringbootbe.TwilioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwilioController {
    public final TwilioService twilioService;

    public TwilioController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }


    @GetMapping("/send-sms")
    public void sendSMS() {
        twilioService.sendSMS("+447787422141", "Hello from Twilio!");
    }

    @GetMapping("/send-whatsapp")
    public void sendWhatsapp() {
        twilioService.sendWhatsAppMessage("+447747114461", "Hi Lloyd, please can you confirm you will be attending your appointment tomorrow, reply \"Y\" or \"N\"");
    }
}
