package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    List<Mail> mailList;
    List<Mail> trashList;
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;

        mailList = new ArrayList<>();
        trashList = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        Mail mail = new Mail(date, sender, message);

        if(inboxCapacity==mailList.size()) {
            trashList.add(mailList.get(0));
            mailList.remove(0);

            mailList.add(mail);
        }
        else {
            mailList.add(mail);
        }
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(int i=0; i<mailList.size(); i++) {
            if(mailList.get(i).getMessage().equals(message)) {
                trashList.add(mailList.get(i));
                mailList.remove(i);
                return;
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(mailList.size()>0) {
            return mailList.get(mailList.size()-1).getMessage();
        }
        return null;

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(mailList.size()>0) {
            return mailList.get(0).getMessage();
        }
        return null;
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int counter = 0;
        for(Mail mail : mailList) {
            if(mail.getDate().compareTo(start)>=0 && mail.getDate().compareTo(end)<=0) {
                counter++;
            }
        }
        return counter;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return mailList.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trashList.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trashList.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}

