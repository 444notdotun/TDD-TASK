package CreditCardValidator;
import org.junit.jupiter.api. *;
import static org.junit.jupiter.api.Assertions. *;


public class CreditValidatorTest {
    CreditCardValidator cardValidator ;
    @BeforeEach
    void setUp() {
        cardValidator = new CreditCardValidator();
    }
    @Test
    public void TestThatCheckLengthOnlyTakesInDigits(){
        int check = cardValidator.checkLength("123456789107816");
        assertEquals("correct", cardValidator.output(check));
    }
    @Test
    public void TestThatFunctionDoesntAllowArgumentThatContainsString(){
      int check = cardValidator.checkLength("1234567jus88970");
      assertEquals("invalid input",cardValidator.output(check));
    }
    @Test
    public void TestThatFunctionDoesntAllowArgumentThatContainsWhiteSpace(){
        int check = cardValidator.checkLength(" ");
        assertEquals("invalid input",cardValidator.output(check) );
    }

    @Test
    public void TestThatFunctionReturnsAmericaExpress(){
        Cards check = cardValidator.checkFirstDigit("378998345622828");
        assertEquals("AMERICANEXPRESSCARD", check.toString());

    }


    @Test
    public void TestThatFunctionReturnsInvalidWhenIsAbove16(){
       int  check = cardValidator.checkLength("1234567909090897090");
        assertEquals("numbers should be less than 13 or above",cardValidator.output(check));
    }

    @Test
    public void TestThatFunctionReturnsInvalidWhenIsbelow3(){
        int  check = cardValidator.checkLength("1234567909090897090");
        assertEquals("numbers should be less than 13 or above",cardValidator.output(check));
    }

    @Test
    public void TestThatFunctionReturnsVIsa(){
        Cards check = cardValidator.checkFirstDigit("478998345622828");
        assertEquals("VISACARD", check.toString());

    }

    @Test
    public void TestThatFunctionReturnsMastercard(){
        Cards check = cardValidator.checkFirstDigit("578998345622828");
        assertEquals("MASTERCARD", check.toString());

    }
    @Test
    public void TestThatFunctionReturnsDISCOVERY(){
        Cards check = cardValidator.checkFirstDigit("678998345622828");
        assertEquals("DISCOVERYCARD", check.toString());

    }

    @Test
    public void TestThatFunctionReturnsInvalidWhenItIsNotAGoodCard(){
        Cards check = cardValidator.checkFirstDigit("178998345622828");
        assertEquals("INVALID", check.toString());
    }

    @Test
    public  void TestThatFunctionRetunsAnArray(){
        int[] check = cardValidator.ArrayOfCardNumbers("1234567891789345");
        int[] expected = {1,2,3,4,5,6,7,8,9,1,7,8,9,3,4,5};
        assertArrayEquals(expected,check);
    }

    @Test
    public  void TestThatDoublingNumbersReturnsValidArray(){
        int [] check = {1,2,3,8,4,8,8,8};
        int  expected = 23;

        assertEquals(expected,cardValidator.doublingNumbers(check));
    }

    @Test
    public  void TestThatDoublingNumbersAddsNumbersAbove9AndReturns(){
        int [] check = {1,2,7,8,9,8,10,8};
        int  expected = 18;

        assertEquals(expected,cardValidator.doublingNumbers(check));
    }

    @Test
    public void TestThatAddCanaddNumbersInOddIndex(){
        int [] check = {1,2,7,8,9,8,10,8};
        int  expected = 26;
        assertEquals(expected,cardValidator.addDigits(check));
    }

    @Test
    public void TestThatValidityCheckWorks(){
        int [] check = {4,3,8,8,5,7,6,0,1,8,4,0,2,6,2,6};

        String  expected = "invalid";
        assertEquals(expected,cardValidator.checkValidity(check));
    }


}
