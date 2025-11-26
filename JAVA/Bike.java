public class Bike {
    private final int gearone = 1;
    private final  int geartwo = 2;
    private final int gearthree = 3;
    private final int gearfour = 4;

    private int gearstatus = 0;
    private boolean bikeStatus = false;
    private int speedStatus = 0;

    public boolean getBikeStatus(){
        return this.bikeStatus;
    }



    public int getSpeedStatus(){
        return this.speedStatus;
    }

    public Boolean bikeOn(){
        if(bikeStatus==false){
            this.bikeStatus =  true;
            return true;
        }
        return false;
    }
    public boolean bikeOff(){
        if(bikeStatus==true){
            this.bikeStatus = false;
            return false;
        }
        return true;
    }

    public int getGearstatus(){
        return gearstatus;
    }


    public void accelerate(){
        if(bikeStatus){
            if (speedStatus <= 20 && speedStatus >= 0) {
                if (speedStatus == 0) {
                    this.gearstatus += gearone;
                }
                this.speedStatus += gearone;

            } else if (speedStatus >= 21 && speedStatus <= 30){
                if (speedStatus == 21){
                    this.gearstatus += 1;
                }
                this.speedStatus += geartwo;

            } else if (speedStatus >= 31 && speedStatus <= 40) {

                if (speedStatus == 31){
                    this.gearstatus += 1;
                }
                    this.speedStatus += gearthree;
            } else if (speedStatus >= 41){
                if (speedStatus == 43||speedStatus == 41 || speedStatus == 42){
                    if(gearstatus == 3){
                        this.gearstatus += 1;
                    }
                }
                this.speedStatus += gearfour;
            }
        }
    }


    public void decelerate(){
        if(bikeStatus){
            if (speedStatus <= 20 && speedStatus > 0) {
                if (speedStatus == 1) {
                    this.gearstatus -= gearone;
                }
                if (gearstatus >= 0) {
                    this.speedStatus -= gearone;

                }
            } else if (speedStatus >= 21 && speedStatus <= 30){
                if (gearstatus == 2){
                    this.gearstatus -= 1;
                }
                this.speedStatus -= geartwo;

            } else if (speedStatus >= 31 && speedStatus <= 40) {

                if (gearstatus ==3){
                    this.gearstatus -= 1;
                }
                this.speedStatus -= gearthree;
            } else if (speedStatus >= 41){
                    if(gearstatus == 4) {
                        this.gearstatus -= 1;
                    }
                    this.speedStatus -= gearfour;
            }
        }
    }



}