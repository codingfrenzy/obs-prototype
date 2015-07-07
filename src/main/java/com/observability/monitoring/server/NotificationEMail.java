//**************************************************************************************************//
/* Observability Project
 * Copyright 2015 Master of Software Engineering team: Laila Alhmound, Ying (Joel) Gao, Caglayan Gem, Rajat Kapoor, Prasanth Nair, Varun Saravagi
 * Copyright 2015 Institute for Software Research | School of Computer Science | Carnegie Mellon University
 * Copyright 2015 Software Engineering Institute
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses/>.
 */
//**************************************************************************************************//

package com.observability.monitoring.server;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * NotificationEMail is a class that can send emails through a predefined SMTP server.<br>
 * 1. Using Gmail as SMTP server: smtp.gmail.com<br>
 * 2. Sending account: observabilityalert@gmail.com< (Pass: obscmusei)br>
 * 3. Secure connection: TLS<p>
 *
 * @author Ying (Joel) Gao
 *         <p/>
 *         History:<br>
 *         1. Created					Jun 07 2015<br>
 */

public class NotificationEMail {

    /**
     * SMTP server for sending email
     */
    private static final String SMTP_SERVER_ADDRESS = "smtp.gmail.com";

    /**
     * Sending account
     */
    private static final String SMTP_EMAIL_ACCOUNT = "observabilityalert@gmail.com";

    private List<String> recipients = new ArrayList<String>();

    /**
     * Send email to recipients.
     * <p/>
     *
     * @param recipients list of recipients
     * @param msgsubject subject of the email
     * @param msgcontent content of the email
     * @param html       whether using HTML email or not
     * @return true/false
     */
    public boolean sendEMail(List<String> recipients, String msgsubject, String msgcontent, boolean html) {
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", SMTP_SERVER_ADDRESS);
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");

        // Get the default Session object.
        //Session session = Session.getDefaultInstance(properties);
        Session session = Session.getDefaultInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("observabilityalert", "obscmusei");
                    }
                });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(SMTP_EMAIL_ACCOUNT));

            // Set To: header field of the header.
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < recipients.size(); i++) {
                String to = recipients.get(i);
                if (to != null && !to.isEmpty()) {
                    buf.append("\n");
                    buf.append(to);
                    // add to recipient
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                }
            }

            // Set Subject: header field
            message.setSubject(msgsubject);

            // Now set the actual message
            if (html) {//HTML content
                message.setContent(msgcontent, "text/html");
            } else {//plain text
                message.setText(msgcontent);
            }
            String rcpts = buf.toString();
            if (rcpts.isEmpty()) {
                System.out.println("Sent email error: Empty recipient.");
                return false;
            }
            // Send message
            Transport.send(message);
            System.out.println("Sent email successfully to: " + rcpts);
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
    }

    /**
     * Initialize recipiencts.<br>
     * Later stages, we can read a file to get the email addresses instead of hard coding.
     */
    public List<String> initRecipients() {
        recipients.add("prst.test@gmail.com");
        recipients.add("cmunightowls@gmail.com");
        return recipients;
    }

    /**
     * Makes the body of email for Not responding.
     *
     * @param ips      Arraylist of the daemon ips
     * @param dateTime Arraylist of the time
     * @return String body
     */
    public String makeNotRespondingEmailBody(ArrayList<String> ips, ArrayList<String> dateTime) {
        String newLine = "\n";
        StringBuilder emailBody = new StringBuilder("Hi Observability observers," + newLine +
                "This email is to notify you that the following daemons are not responding. The details are: " + newLine);

        for (int i = 0; i < ips.size(); i++) {
            emailBody.append(newLine + "IP: " + ips.get(i) + " since " + dateTime.get(i));
        }

        emailBody.append(newLine + newLine + "We advice you to chcek the status of the daemon and/or the network communications. " + newLine + "Thank you.");
        return emailBody.toString();
    }

    /**
     * Makes the body of email for Not collecting.
     *
     * @param ips      Arraylist of the daemon ips
     * @param dateTime Arraylist of the time
     * @return String body
     */
    public String makeNotCollectingEmailBody(ArrayList<String> ips, ArrayList<String> dateTime) {
        String newLine = "\n";
        StringBuilder emailBody = new StringBuilder("Hi Observability observers," + newLine +
                "This email is to notify you that the following daemons are not collecting measurements as expected. The details are: " + newLine);

        for (int i = 0; i < ips.size(); i++) {
            emailBody.append(newLine + "IP: " + ips.get(i) + " since " + dateTime.get(i));
        }

        emailBody.append(newLine + newLine + "We advice you to check the status of the collectd process in these daemons. You may also find useful information in collectd logs. " + newLine +
                "Thank you.");
        return emailBody.toString();
    }
}
