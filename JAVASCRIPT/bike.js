
let bikeStatus = false;
let speedStatus = 0;
let gearstatus = 0;

const GEARONE = 1;
const GEARTWO = 2;
const GEARTHREE = 3;
const GEARFOUR = 4;

function reset() {
    bikeStatus = false;
    speedStatus = 0;
    gearstatus = 0;
}

function bikeOn() {
    bikeStatus = true;
}

function bikeOff() {
    bikeStatus = false;
}

function getBikeStatus() {
    return bikeStatus;
}

function getSpeedStatus() {
    return speedStatus;
}

function getGearstatus() {
    return gearstatus;
}

function accelerate() {
    if (bikeStatus) {
        if (speedStatus <= 20 && speedStatus >= 0) {
            if (speedStatus === 0) {
                gearstatus += GEARONE;
            }
            speedStatus += GEARONE;

        } else if (speedStatus >= 21 && speedStatus <= 30){
            if (speedStatus === 21) {
                gearstatus += 1;
            }

            speedStatus += GEARTWO;
        } else if (speedStatus >= 31 && speedStatus <= 40) {
            if (speedStatus === 31) gearstatus += 1;
            speedStatus += GEARTHREE;
        } else if (speedStatus >= 41) {
            if ([41, 42, 43].includes(speedStatus)) {
                if (gearstatus === 3) {
                    gearstatus += 1;
                }
            }
            speedStatus += GEARFOUR;
        }
    }
}

function decelerate() {
        if (bikeStatus) {
            if (speedStatus <= 20 && speedStatus >= 0) {
                if (speedStatus === 1) {
                    gearstatus -= 1;

                    speedStatus -= GEARONE;
                }


            } else if (speedStatus >= 21 && speedStatus <= 30) {
                if (gearstatus === 2) {
                        gearstatus -= 1;
                }
                speedStatus -= GEARTWO;
            } else if (speedStatus >= 31 && speedStatus <= 40) {
                if (gearstatus === 3) {
                        gearstatus -= 1;
                }
                speedStatus -= GEARTHREE;
            } else if (speedStatus >= 41) {
                if (gearstatus === 4) {
                    gearstatus -= 1;
                }
                speedStatus -= GEARFOUR;
            }
        }

}

module.exports = {
    bikeOn,
    bikeOff,
    getBikeStatus,
    getSpeedStatus,
    getGearstatus,
    accelerate,
    decelerate,
    reset
}




