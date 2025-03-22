//Email Application
package assignment;

import java.util.Scanner;

class Email {
    String firstName;
    String lastName;
    String password;
    int mailboxCapacity = 500;
    String alternateEmail;
    String email;
    static final int defaultpasswordlength = 8;
    
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;  
  
        this.password = generateRandomPassword(defaultpasswordlength);
        
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@company.com";
    }
    private String generateRandomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
    public String getPassword() {
        return this.password;
    }
    public void showInfo() {
        System.out.println("\nEMAIL ACCOUNT DETAILS:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Company Email: " + email);
        System.out.println("Mailbox Capacity: " + mailboxCapacity);
        if (alternateEmail != null) {
            System.out.println("Alternate Email: " + alternateEmail);
        }
    }
}

public class EmailApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        
        Email email = new Email(firstName, lastName);
        email.showInfo();
        
        System.out.print("\nWould you like to set an alternate email? (yes/no): ");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter alternate email: ");
            String altEmail = scanner.next();
            email.setAlternateEmail(altEmail);
        }
        
        System.out.print("\nWould you like to change the default password? (yes/no): ");
        choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter new password: ");
            String newPassword = scanner.next();
            email.changePassword(newPassword);
            System.out.println("Your new password is:"+newPassword);
        } else {
            System.out.println("Default password remains: " + email.getPassword());
        }
        
        email.showInfo();
        scanner.close();
    }
}
