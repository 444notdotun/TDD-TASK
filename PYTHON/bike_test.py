import unittest
from bike import Bike

class BikeTest(unittest.TestCase):

    def setUp(self):
        self.bike = Bike()

    def test_bike_on_can_be_turned_on(self):
        self.assertTrue(self.bike.bike_on())

    def test_bike_on_can_be_turned_off(self):
        self.bike.bike_on()
        self.assertFalse(self.bike.bike_off())

    def test_bike_can_accelerate(self):
        self.bike.bike_on()
        self.bike.accelerate()
        self.assertEqual(1, self.bike.get_speed_status())

    def test_bike_can_accelerate_and_gear_increases(self):
        self.bike.bike_on()
        self.bike.accelerate()
        self.assertEqual(1, self.bike.get_gear_status())

    def test_bike_can_accelerate_above_20(self):
        self.bike.bike_on()
        for _ in range(21):
            self.bike.accelerate()
        self.assertEqual(21, self.bike.get_speed_status())

    def test_bike_cannot_move_until_on(self):
        self.bike.accelerate()
        self.assertEqual(0, self.bike.get_speed_status())

    def test_bike_gear_cannot_increase_until_on(self):
        self.bike.accelerate()
        self.assertEqual(0, self.bike.get_gear_status())

    def test_bike_gear_can_increase_to_two(self):
        self.bike.bike_on()
        for _ in range(22):
            self.bike.accelerate()
        self.assertEqual(2, self.bike.get_gear_status())

    def test_bike_gear_can_increase_to_three(self):
        self.bike.bike_on()
        for _ in range(30):
            self.bike.accelerate()
        self.assertEqual(3, self.bike.get_gear_status())

    def test_bike_gear_can_increase_to_four(self):
        self.bike.bike_on()
        for _ in range(31):
            self.bike.accelerate()
        self.assertEqual(4, self.bike.get_gear_status())

    def test_gear_should_decrease_from_four_to_three(self):
        self.bike.bike_on()
        for _ in range(41):
            self.bike.accelerate()
        for _ in range(10):   # decelerate 10 times
            self.bike.decelerate()
        self.assertEqual(3, self.bike.get_gear_status())

    def test_gear_should_decrease_from_three_to_two(self):
        self.bike.bike_on()
        for _ in range(29):
            self.bike.accelerate()
        for _ in range(2):
            self.bike.decelerate()
        self.assertEqual(2, self.bike.get_gear_status())

    def test_gear_should_decrease_when_speed_drops_below_threshold(self):
        self.bike.bike_on()
        for _ in range(25):
            self.bike.accelerate()
        for _ in range(5):
            self.bike.decelerate()
        self.assertEqual(1, self.bike.get_gear_status())

    def test_gear_should_not_go_below_zero(self):
        self.bike.bike_on()
        self.bike.accelerate()
        self.bike.decelerate()
        self.assertEqual(0, self.bike.get_gear_status())

    def test_bike_should_decelerate_when_on(self):
        self.bike.bike_on()
        self.bike.accelerate()
        self.bike.decelerate()
        self.assertEqual(0, self.bike.get_speed_status())

    def test_bike_should_not_decelerate_when_off(self):
        self.bike.decelerate()
        self.assertEqual(0, self.bike.get_speed_status())

    def test_bike_should_not_go_below_zero_speed(self):
        self.bike.bike_on()
        self.bike.decelerate()
        self.assertEqual(0, self.bike.get_speed_status())


