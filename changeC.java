
public class changeC{

//private variables to store persons name, amount and note denominations
    private String name;
    private int amount;
    private int aed5, aed10, aed20, aed50, aed100, aed200, aed500, aed1000;

//default constructor to initialize all int values to zero and string values to null 
    public changeC(){
        this.name = "";
        this.amount = 0;
        this.aed5 = this.aed10 = this.aed20 = this.aed50 = this.aed100 = this.aed200 = this.aed500 = this.aed1000 = 0;
    }

//parameterized constructor for assigning variables to values input by the user
    public changeC( String name, int amount){
        this.name = name;
        this.amount = amount;
        calculateChange();
    }

//Getters and Setters for Name, amount and denomination
    public String getName(){
       return name;
    }
    public void setName(String name){
       this.name = name;
    }
   
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
        calculateChange();
    }
//mthod to get the count of each denomination
   public int getDenomination(int denomination){
        
        switch (denomination){
            case 5: 
               return aed5;
            
            case 10: 
                return aed10;
            
            case 20: 
                return aed20;
            
            case 50: 
                return aed50;
            
            case 100: 
                return aed100;
            
            case 200: 
                return aed200;
            
            case 500: 
                return aed500;
            
            case 1000: 
                return aed1000;
            // return 0 for invalid denomination
            default: 
                return 0;
        }
    }
   
//helper method for calculating change for different denominations
    private void calculateChange(){
        int remainingAmount = this.amount;
        //calculate number of 1000 notes and update remaining amount
        this.aed1000 = remainingAmount / 1000;
        remainingAmount %= 1000;
        //calculate number of 500 notes and update remaining amount
        this.aed500 = remainingAmount / 500;
        remainingAmount %= 500;
        //calculate number of 200 notes and update remaining amount
        this.aed200 = remainingAmount / 200;
        remainingAmount %= 200;
        //calculate number of 100 notes and update remaining amount
        this.aed100 = remainingAmount / 100;
        remainingAmount %= 100;
        //calculate number of 50 notes and update remaining amount
        this.aed50 = remainingAmount / 50;
        remainingAmount %= 50;
        //calculate number of 20 notes and update remaining amount
        this.aed20 = remainingAmount / 20;
        remainingAmount %= 20;
        //calculate number of 10 notes and update remaining amount
        this.aed10 = remainingAmount / 10;
        remainingAmount %= 10;
        //calculate number of 5 notes and update remaining amount
        this.aed5 = remainingAmount / 5;
        remainingAmount %= 5;
    }


}




