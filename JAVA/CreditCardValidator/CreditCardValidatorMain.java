package CreditCardValidator;
import java.util.Scanner;
public class CreditCardValidatorMain {
    static void main(String[] args){
        Scanner input=new Scanner(System.in);
        CreditCardValidator creditValidator =new CreditCardValidator();
        String cardNumber;
        while(true){
            System.out.println("hello, kindly enter card details to verify:");
            cardNumber=input.nextLine();
            int lengthValidator =  creditValidator.checkLength(cardNumber);
            if(lengthValidator>0){
                break;
            }
            System.out.println(creditValidator.output(lengthValidator));
        }
        int [] array = creditValidator.ArrayOfCardNumbers(cardNumber);
        System.out.println("******************************************");
        System.out.println("***CREDIT CARD TYPE: "+creditValidator.checkFirstDigit(cardNumber));
        System.out.println("***CREDIT CARD NUMBER: "+ cardNumber);
        System.out.println("***CREDIT CARD DIGIT LENGTH: "+creditValidator.checkLength(cardNumber));
        System.out.println("*** CREDIT CARD VALIDITY: "+creditValidator.checkValidity(array));
        System.out.println("******************************************");






    }
}
