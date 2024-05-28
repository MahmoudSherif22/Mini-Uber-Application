import java.util.Scanner;
import java.util.HashMap;

public class AccountTicket extends Ticket implements Request_ticket {
int operationNumber;

    // Map<String, String> map = new HashMap<>();
    HashMap<String, User> usersMap;
    //private ArrayList<String> Account_Issues;
    private Request_ticket requestTicket;

    @Override
    public void setNextChain(Request_ticket nextChain) {
        this.requestTicket=nextChain;
    }

    public AccountTicket() {
        super("Account");
    }

    public AccountTicket(HashMap map) {
        super("Account");
        this.usersMap=map;
    }

    @Override
    public void request(Ticket ticketType) {
        if((ticketType.getTicketType().equals("Account"))){
            System.out.println("Forget Password click 1 ");
            System.out.println("Account Hacked click 2 (change Password)");

            Scanner myObj = new Scanner(System.in);
            operationNumber = myObj.nextInt();
            if(operationNumber  == 1){
                executeOperation1();
            }

            else if(operationNumber == 2){
                executeOperation2();
            }
        }
        else{
            System.out.println("Only works for Ride , Payment and Account");
        }

    }


    void executeOperation1(){
        System.out.println(" Please Enter Your number :  ");
        Scanner operation1Input = new Scanner(System.in);
        String username = operation1Input.nextLine();
        if(usersMap.containsKey(username)){
            System.out.println("Your Password Is : " + usersMap.get(username));
        }
        else {
            System.out.println("Not Found");
        }
    }
    void executeOperation2(){
        System.out.println(" Please Enter Your number :  ");
        Scanner operation2Input = new Scanner(System.in);
        String username = operation2Input.nextLine();
        if(usersMap.containsKey(username)){
         //   Scanner m1 = new Scanner(System.in);
            String input = operation2Input.nextLine();
            User userTemp = new User(username,input);
            usersMap.put(username,userTemp);
        }
        else {
            System.out.println("Not Found ! ");
        }
    }


}
