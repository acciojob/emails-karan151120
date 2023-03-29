package com.driver;


public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(this.password==oldPassword) {
            if(check(newPassword)) {
                this.password = newPassword;
            }
        }
    }

    public boolean check(String newPassword) {
        if(newPassword.length()<8) return false;

        boolean flagu = false;
        boolean flagl = false;
        boolean flagd = false;
        boolean flags = false;

        for(int i=0; i<newPassword.length(); i++) {

            if(newPassword.charAt(i)>='A' && newPassword.charAt(i)<='Z') {
                flagu = true;
            }
            if(newPassword.charAt(i)>='a' && newPassword.charAt(i)<='z') {
                flagl = true;
            }
            if(newPassword.charAt(i)>='0' && newPassword.charAt(i)<='9') {
                flagd = true;
            }
            if(!flagd){
            if((newPassword.charAt(i)>=32 && newPassword.charAt(i)<=47) || (newPassword.charAt(i)>=58 && newPassword.charAt(i)<=64) || (newPassword.charAt(i)>=91 && newPassword.charAt(i)<=96) || (newPassword.charAt(i)>=123 && newPassword.charAt(i)<=126)) {
                flagd = true;
            }}
        }

        if(flagd && flagl && flagu && flags) return true;
        return false;
    }
}
