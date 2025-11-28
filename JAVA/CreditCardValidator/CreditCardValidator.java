package CreditCardValidator;


public class CreditCardValidator {
    Cards cardType;

    public String output(int check){
        String expected;
        if( check > 1){
            expected = "correct";
        }
        else if(check == -1) {
            expected = "numbers should be less than 13 or above";
        }else{
            expected ="invalid input";
        }
        return expected;
    }

    public int checkLength(String cardNumber) {
        if(cardNumber.isBlank()){
             return  0;
        }
        if(!cardNumber.matches("\\d+")){
          return 0;
        }
        int checkNumberLength = cardNumber.length();
        if(checkNumberLength > 12 && checkNumberLength < 17){
           return checkNumberLength;
        }
        else {
            return  -1;
        }
    }

    public Cards checkFirstDigit( String cardNumber){
        char numberOne = cardNumber.charAt(0);
        if(numberOne =='3'){
            if(cardNumber.charAt(1) == '7'){
                return Cards.AMERICANEXPRESSCARD;
            }else{
                return Cards.INVALID;
            }
        } else if (numberOne == '4'){
            return Cards.VISACARD;
        } else if(numberOne == '5') {
           return Cards.MASTERCARD;
        } else if(numberOne == '6') {
            return Cards.DISCOVERYCARD;
        }
        else {
            return Cards.INVALID;
        }
    }



    public int [] ArrayOfCardNumbers(String number){
        int list = checkLength(number);

        int [] listOfNumbers = new int[list];
        for(int count = 0;count < list;count++) {
            listOfNumbers[count] = number.charAt(count)-'0';
        }
        return listOfNumbers;
    }


    public int doublingNumbers(int [] check){
        int checker = check.length-2;
        int total = 0;
        for(int count = checker; 0 <= count; count-=2){

                check[count]*=2;
                if(check[count] >9){
                int number = check[count];
                int modulus = number%10;
                int divisor = number/10;
                int solution = divisor+modulus;
                check[count] = solution;

                }
                total+=check[count];
        }

        return total;
    }



    public  int addDigits(int[] number){
      int checker = number.length;
      int total = 0;
      for(int count = checker; 0 <= count; count--){
          if(count%2>0){
              total+=number[count];
          }
      }
      return total;
    }

    public String checkValidity(int [] cardNumber){
        int result = doublingNumbers(cardNumber)+addDigits(cardNumber);
        if(result % 10==0){
            return "valid";
        }
        return "invalid";

    }


}

