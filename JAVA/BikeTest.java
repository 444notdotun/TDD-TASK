import org.junit.jupiter.api. *;
import static org.junit.jupiter.api.Assertions. *;


public class BikeTest {
    Bike bike;

    @BeforeEach
    void setup(){
        bike = new Bike();
    }
    @Test
    public void TestThatBikeOnCanBeTurnedOn(){
        assertTrue(bike.bikeOn());
    }

    @Test
    public void TestThatBikeOnCanBeTurnedOff(){
        bike.bikeOn();
        assertFalse(bike.bikeOff());
    }

    @Test
    public void TestThatBikeCanAccelerate(){
        bike.bikeOn();
        bike.accelerate();
        assertEquals(1,bike.getSpeedStatus());

    }


    @Test
    public void TestThatBikeCanAccelerateAndThatTheGearIsIncreased() {
        bike.bikeOn();
        bike.accelerate();
        assertEquals(1, bike.getGearstatus());
    }

    @Test
    public void TestThatBikeCanAccelerateAbove20(){
        bike.bikeOn();
        for(int count = 0; count < 21; count++){
            bike.accelerate();
        }
        assertEquals(21, bike.getSpeedStatus());
    }

    @Test
    public void TestThatBikeCanNotMOveUnTilItIsOn(){
        bike.accelerate();
        assertEquals(0,bike.getSpeedStatus());
    }

    @Test
    public void TestThatBikeGearCanNotIncreaseUntil(){
        bike.accelerate();
        assertEquals(0,bike.getGearstatus());
    }
    @Test
    public void TestThatBikeGearCanIncreaseTwoGearTwo(){
        bike.bikeOn();
        for(int count = 0;count < 22; count++){
            bike.accelerate();
        }
        assertEquals(2, bike.getGearstatus());


    }

    @Test
    public void TestThatBikeGearCanIncreaseTwoGearThree(){
        bike.bikeOn();
        for(int count = 0;count < 30; count++){
            bike.accelerate();
        }
        assertEquals(3, bike.getGearstatus());
    }

    @Test
    public void TestThatBikeGearCanIncreaseTwoGearFour(){
        bike.bikeOn();
        for(int count = 0;count < 31; count++){
            bike.accelerate();
        }
        assertEquals(4, bike.getGearstatus());
    }

    @Test
    public void GearShouldDecreaseFromFourToThree() {
        bike.bikeOn();
        for (int count = 0; count< 41; count++) {
            bike.accelerate();
        }

        for (int i = 2; i < 12; i++) {
            bike.decelerate();
        }

        assertEquals(3, bike.getGearstatus());
    }

    @Test
    public void GearShouldDecreaseFromThreeToTwo() {
        bike.bikeOn();
        for (int count = 0; count  < 29; count++) {
            bike.accelerate();
        }
        ;
        for (int count = 2; count < 4; count++) {
            bike.decelerate();
        }
        assertEquals(2, bike.getGearstatus());
    }


    @Test
    public void gearShouldDecreaseWhenSpeedDropsBelowThreshold() {
        bike.bikeOn();
        for (int i = 0; i < 25; i++) {
            bike.accelerate();
        }
        for (int i = 0; i < 5; i++) {
            bike.decelerate();
        }
        assertEquals(1, bike.getGearstatus());
    }

    @Test
    public void gearShouldNotGoBelowToZero() {
        bike.bikeOn();
        bike.accelerate();
        bike.decelerate();
        assertEquals(0, bike.getGearstatus());
    }
    @Test
    public void bikeShouldDecelerateWhenOn() {
            bike.bikeOn();
            bike.accelerate();
            bike.decelerate();
            assertEquals(0, bike.getSpeedStatus());
        }

        @Test
        public void bikeShouldNotDecelerateWhenOff() {
            bike.decelerate();
            assertEquals(0, bike.getSpeedStatus());
        }

        @Test
        public void bikeShouldNotGoBelowZeroSpeed() {
            bike.bikeOn();
            bike.decelerate();
            assertEquals(0, bike.getSpeedStatus());
        }




    }