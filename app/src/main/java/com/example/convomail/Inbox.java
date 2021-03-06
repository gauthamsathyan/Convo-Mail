package com.example.convomail;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;

import javax.mail.Flags;

public class Inbox implements Serializable {
    private Mail primary;
    private Mail draft;
    private Mail spam;
    private Mail trash;
    private Mail sentMail;

    public Inbox(Mail p, Mail d, Mail s, Mail t){
        this.primary = p;
        this.draft = d;
        this.spam = s;
        this.trash = t;
    }
    public void setPrimary(javax.mail.Message[] message) {
        try{
            ArrayList<Message> m = new ArrayList<>();
            for(javax.mail.Message j:message){
                m.add(new Message(j.getFrom(), j.getReceivedDate(), j.getSubject(), j.getMessageNumber(), j.getContentType(), j.isSet(Flags.Flag.SEEN)));
            }
            this.primary = new Mail(m);
        }catch (Exception e){
            Log.d("Exception", e.toString());
        }
    }
    public void setDraft(javax.mail.Message[] message){
        try{
            ArrayList<Message> m = new ArrayList<>();
            for(javax.mail.Message j:message){
                m.add(new Message(j.getFrom(), j.getReceivedDate(), j.getSubject(), j.getMessageNumber(), j.getContentType()));
            }
            this.draft = new Mail(m);
        }catch (Exception e){
            Log.d("Exception", e.toString());
        }    }
        public void setSentMail(javax.mail.Message[] message){
            try{
                ArrayList<Message> m = new ArrayList<>();
                for(javax.mail.Message j:message){
                    m.add(new Message(j.getAllRecipients(), j.getReceivedDate(), j.getSubject(), j.getMessageNumber(), j.getContentType()));
                }
                this.sentMail = new Mail(m);
            }catch (Exception e){
                Log.d("Exception", e.toString());
            }
        }
    public void setSpam(javax.mail.Message[] message) {
        try{
            ArrayList<Message> m = new ArrayList<>();
            for(javax.mail.Message j:message){
                m.add(new Message(j.getFrom(), j.getReceivedDate(), j.getSubject(), j.getMessageNumber(), j.getContentType()));
            }
            this.spam = new Mail(m);
        }catch (Exception e){
            Log.d("Exception", e.toString());
        }    }

    public void setTrash(javax.mail.Message[] message) {
        try{
            ArrayList<Message> m = new ArrayList<>();
            for(javax.mail.Message j:message){
                m.add(new Message(j.getFrom(), j.getReceivedDate(), j.getSubject(), j.getMessageNumber(), j.getContentType()));
            }
            this.trash = new Mail(m);
        }catch (Exception e){
            Log.d("Exception", e.toString());
        }    }

    public Mail getDraft() {
        return draft;
    }
    public Mail getPrimary() {
        return primary;
    }

    public Mail getSpam() {
        return spam;
    }

    public Mail getTrash() {
        return trash;
    }
    public void setInbox(Mail p, Mail d, Mail s, Mail t){
        this.primary = p;
        this.draft = d;
        this.spam = s;
        this.trash = t;
    }

    public Mail getSentMail() {
        return sentMail;
    }

    public void updateInbox(Inbox inbox){
        this.primary.getMessages().addAll(inbox.getPrimary().getMessages());
        this.draft.getMessages().addAll(inbox.getDraft().getMessages());
        this.spam.getMessages().addAll(inbox.getSpam().getMessages());
        this.trash.getMessages().addAll(inbox.getTrash().getMessages());
      
    }

}
