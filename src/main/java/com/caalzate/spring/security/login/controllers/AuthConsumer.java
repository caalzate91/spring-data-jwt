package com.caalzate.spring.security.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;

import com.caalzate.spring.security.login.models.Mensaje;

@Controller
public class AuthConsumer {

    @Autowired
    private JmsTemplate jmsTemplate;
    
    @JmsListener(destination = "${caalzate.app.queueAuth}")
    public void consume(String message) {

        Mensaje msg = (Mensaje) jmsTemplate.receiveAndConvert(message);

        System.out.println("Received message: " + msg.toString());
    }

}
