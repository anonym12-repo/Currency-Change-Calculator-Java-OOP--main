import java.util.Scanner;

public class Client {
    //create change array to store changeC objects 
    private changeC[] change;
    //declare a count of records entered
    private int numofRecords;

    //default constructor to initialize the change array to 500 and count to 0
    public Client() {
        this.change = new changeC[50];
        this.numofRecords = 0;
    }
    //main method
    public static void main(String[] args) {
        //create a client class object
        Client client = new Client();
        client.studentInfo();
        client.hardcodedTestCases();
        //call inputData method to enter names and amounts
        client.inputData();
        //call menu to choose among 6 options
        client.menu();
    }
    //method to display my personal info
    public void studentInfo(){
        System.out.println("HIBA ZUBAIRI");
        System.out.println("34779757");
        System.out.println("FULL TIME (EXTERNAL)");
        System.out.println("NOOR ALKHATEEB");
        System.out.println("27TH JUNE 2024, 8:04PM");    
    }
    
    //method to take in data entered by the user
    public void inputData() {
        //create scanner object to input data
        Scanner scanner = new Scanner(System.in);
        //initialize boolean flag to control the input loop
        boolean moreData = true;
        //begin a while loop that lets the user enter as much data as it wants to
        while (moreData) {
            //call method to validate data input
            validateData();
            //call method to ask the user if it wants to enter more data
            moreData = addMoreData(scanner);
        }
    }
    //method to validate data and store it
    public void validateData() {
        System.out.println("Enter atleast 10 records to test the program! ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the person: ");
        String name = scanner.next();
        //validate if name entered by the user doesnt already exist by calling ifNameExists method
        if (ifNameExists(name)) {
            System.out.println("The name is already present");
            return;
        }
        System.out.println("Please enter the currency value for the person: ");
        int amount = scanner.nextInt();
        //validate if the amount entered by the user is multiple of 5 
        if (amount % 5 != 0) {
            System.out.println("Please enter the amount in multiple of 5 only!");
            return;
        }
        //create a new changeC object using the parameterized constructor and store it in the change array at index numPerson which is currently 0
        change[numofRecords] = new changeC(name, amount);
        //update number of persons entered 
        numofRecords++;
    }
    //method to check if the name entered doesnt already exist in the array
    public boolean ifNameExists(String name) {
        for (int i = 0; i < numofRecords; i++) {
            
            if (change[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }    
    
    //method to ask user if it wants to add more data
    public boolean addMoreData(Scanner scanner) {
        System.out.println("Do you want to enter another person (Y/N): ");
        //return true and let the user enter more data if user will enter Y
        return scanner.next().equals("Y");
    }
    
    //method to handle menu and its selection
    public void menu() {
        //scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        //initialize choice to 0
        int choice = 0;
        //begin a while loop until the user chooses to exit and selects option 6
        while (choice != 6) {
            //display menu to the user
            displayMenu();
            //get users choice
            choice = scanner.nextInt();
            //process users choice accordingly
            processMenu(choice, scanner);
        }        
    }
    //method to display menu to the user and prompt the user to select one
    public void displayMenu() {
        System.out.println("1. Enter a name and display change to be given for each denomination.");
        System.out.println("2. Find the name with the smallest amount and display change to be given for each denomination.");
        System.out.println("3. Find the name with the largest amount and display change to be given for each denomination.");
        System.out.println("4. Calculate and display the total number of currency notes for each denomination.");
        System.out.println("5. Calculate and display the total amount for the sum of all denominations.");
        System.out.println("6. Exit.");
        System.out.println("Choose an option: ");
    }
    
    //method to process menu option entered by the user
    public void processMenu(int choice, Scanner scanner) {
        //begin a switch case to handle various menu choices
        switch (choice) {
            case 1:
                //call method to display name and change for a specifi name entered by the user
                displayNameAndChange();
                break;
            case 2:
                //call method to display the change for the smallest amount 
                displayChange(findSmallest());
                break;
            case 3:
                //call method to display the change for the largest amount 
                displayChange(findLargest());
                break;
            case 4:
                //method to calculate total denomination 
                calculateTotalDenominations();
                break;
            case 5:
                //method to display total amount 
                displayTotalAmount();
                break;
            case 6:
                //exit the program
                System.out.println("Exit");
            default:
                //print this message for inclide menu choice
                System.out.println("Invalid input, try again!");
        }
    }
    //method to display name and change for a specific person
    public void displayNameAndChange() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name(uppercase letters only): ");
        String name = scanner.next();
        //call findchange method using the name entered by the user to search for a changeC object with the entered name
        changeC change = findChange(name);
        //check if a mataching changeC object is found
        if (change != null) {
            //call displaychange method to display change to the user for that name
            displayChange(change);
        } else {
            //if nomatch is found display name not found
            System.out.println("Name: " + name);
            System.out.println("Not found");
        }
    }
    //method to find changeC object by name
    public changeC findChange(String name) {
        //loop to iterate through changes array
        for (int i = 0; i < numofRecords; i++) {
            //check sif changeC object at index i matches search name
            if (change[i].getName().equals(name)) {
                return change[i];
            }
        }
        return null;
    }
    
    //method to print count of a specific persons amount
    public void validateDenomination(changeC change, int denomination) {
        //get the count of notes for the entered name
        int count = change.getDenomination(denomination);
        //check if the count is greater than 0
        if (count > 0) {
            //print denominations in aed
            System.out.println(denomination + " dirhams: " + count);
        }
        //if count is 0 then dont print the denomination
    }
    
    //method to display change denominations for the name entered by the user 
    public void displayChange(changeC change) {
        System.out.println("Customer: ");
        //print customers name and amount
        System.out.println(change.getName() + " " + change.getAmount() + " Dirhams");
        //call displaydenomination method to print change is higher valued denominations 
        validateDenomination(change, 1000);
        validateDenomination(change, 500);
        validateDenomination(change, 200);
        validateDenomination(change, 100);
        validateDenomination(change, 50);
        validateDenomination(change, 20);
        validateDenomination(change, 10);
        validateDenomination(change, 5);
    }
    //method to find the changeC object with the smallest amount
    public changeC findSmallest() {
        //decakre variable smallest to first changeC object in the array
        changeC smallest = change[0];
        //loop through the array start from second element
        for (int i = 1; i < numofRecords; i++) {
            //check if the current changeC objects amount is equal to the smallest one
            if (change[i].getAmount() < smallest.getAmount()) {
                //if it is then update the smallest
                smallest = change[i];
            }
        }//return the objexts with the smallest amount
        return smallest;
    }

    public changeC findLargest() {
        changeC largest = change[0];
        for (int i = 1; i < numofRecords; i++) {
            if (change[i].getAmount() > largest.getAmount()) {
                largest = change[i];
            }
        }
        return largest;
    }
    //method to calculate total of each denomination
    public void calculateTotalDenominations() {
        //initialize variables to store total of each denomination
        int total5, total10, total20, total50, total100, total200, total500, total1000;
        total5 = total10 =  total20 = total50 = total100 = total200 = total500 = total1000 = 0;
        //loop through all stored changeC objects
        for (int i = 0; i < numofRecords; i++) {
            //add evert chacngeC objects aed 5 denominations to the total5 which was set to 0 initially
            total5 += change[i].getDenomination(5);
            total10 += change[i].getDenomination(10);
            total20 += change[i].getDenomination(20);
            total50 += change[i].getDenomination(50);
            total100 += change[i].getDenomination(100);
            total200 += change[i].getDenomination(200);
            total500 += change[i].getDenomination(500);
            total1000 += change[i].getDenomination(1000);
        }
        //print total count of each denomination
        System.out.println("Total AED 5 notes: " + total5);
        System.out.println("Total AED 10 notes: " + total10);
        System.out.println("Total AED 20 notes: " + total20);
        System.out.println("Total AED 50 notes: " + total50);
        System.out.println("Total AED 100 notes: " + total100);
        System.out.println("Total AED 200 notes: " + total200);
        System.out.println("Total AED 500 notes: " + total500);
        System.out.println("Total AED 1000 notes: " + total1000);
    }
    //method to calculate total amount of every person
    public int calculateTotalAmount() {
        //initialize total counter to 0
        int total = 0;
        //loop through the array 
        for (int i = 0; i < numofRecords; i++) {
            //add each persons amount to the total and update total
            total += change[i].getAmount();
        }
        //return total amount
        return total;
    }
    //method to display total amount in dirhams
    public void displayTotalAmount() {
        System.out.println("Total amount: " + calculateTotalAmount() + " dirhams");
    }

    public void hardcodedTestCases() {
        change[numofRecords++] = new changeC("EMAN", 405);
        change[numofRecords++] = new changeC("MAHAM", 500);
        change[numofRecords++] = new changeC("AREEBA", 940);
        change[numofRecords++] = new changeC("HIBA", 1230);
        change[numofRecords++] = new changeC("LEEN", 990);
        change[numofRecords++] = new changeC("SAMA", 655);
        change[numofRecords++] = new changeC("AFIA", 440);
        change[numofRecords++] = new changeC("SALEHA", 120);
        change[numofRecords++] = new changeC("AYESHA", 230);
        change[numofRecords++] = new changeC("MALIHA", 1000);
    }
}
