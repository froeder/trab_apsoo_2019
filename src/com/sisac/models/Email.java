package com.sisac.models;

import java.util.Properties;


public class Email {

    public Session setSession() {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
    }

}
