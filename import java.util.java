import java.util.Scanner;

public class User {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    
    public User(String name, String email, String password, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        
        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        
        System.out.println("Enter your phone number:");
        String phoneNumber = scanner.nextLine();
        
        User user = new User(name, email, password, phoneNumber);
        System.out.println("User " + user.getName() + " registered successfully!");
    }
}
