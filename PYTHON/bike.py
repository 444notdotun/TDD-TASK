class Bike:
    def __init__(self):
        self.GEARONE = 1
        self.GEARTWO = 2
        self.GEARTHREE = 3
        self.GEARFOUR = 4


        self.gearstatus = 0
        self.bikeStatus = False
        self.speedStatus = 0

    def get_bike_status(self):
        return self.bikeStatus

    def get_speed_status(self):
        return self.speedStatus

    def bike_on(self):
        if not self.bikeStatus:
            self.bikeStatus = True
            return True
        return False

    def bike_off(self):
        if self.bikeStatus:
            self.bikeStatus = False
            return False
        return True

    def get_gear_status(self):
        return self.gearstatus

    def accelerate(self):
        if self.bikeStatus:
            if 0 <= self.speedStatus <= 20:
                if self.speedStatus == 0:
                    self.gearstatus += self.GEARONE
                self.speedStatus += self.GEARONE

            elif 21 <= self.speedStatus <= 30:
                if self.speedStatus == 21:
                    self.gearstatus += 1
                self.speedStatus += self.GEARTWO

            elif 31 <= self.speedStatus <= 40:
                if self.speedStatus == 31:
                    self.gearstatus += 1
                self.speedStatus += self.GEARTHREE

            elif self.speedStatus >= 41:
                if self.speedStatus in [41, 42, 43] and self.gearstatus == 3:
                    self.gearstatus += 1
                self.speedStatus += self.GEARFOUR

    def decelerate(self):
        if self.bikeStatus:
            if 0 < self.speedStatus <= 20:
                if self.speedStatus == 1:
                    self.gearstatus -= self.GEARONE
                if self.gearstatus >= 0:
                    self.speedStatus -= self.GEARONE

            elif 21 <= self.speedStatus <= 30:
                if self.gearstatus == 2:
                    self.gearstatus -= 1
                self.speedStatus -= self.GEARTWO

            elif 31 <= self.speedStatus <= 40:
                if self.gearstatus == 3:
                    self.gearstatus -= 1
                self.speedStatus -= self.GEARTHREE

            elif self.speedStatus >= 41:
                if self.gearstatus == 4:
                    self.gearstatus -= 1
                self.speedStatus -= self.GEARFOUR