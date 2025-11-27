const {
    bikeOn,
    bikeOff,
    getBikeStatus,
    getSpeedStatus,
    getGearstatus,
    accelerate,
    decelerate,
    reset
} = require('./bike');

beforeEach(() => {
    reset();
});

describe('Bike Tests', () => {
    test('Bike can be turned on', () => {
        bikeOn();
        expect(getBikeStatus()).toBe(true);
    });

    test('Bike can be turned off', () => {
        bikeOn();
        bikeOff();
        expect(getBikeStatus()).toBe(false);
    });


    test('Bike can accelerate', () => {
        bikeOn();
        accelerate();
        expect(getSpeedStatus()).toBe(1);
    });

    test('Bike gear increases on acceleration', () => {
        bikeOn();
        accelerate();
        expect(getGearstatus()).toBe(1);
    });

    test('Bike can accelerate above 20', () => {
        bikeOn();
        for (let count = 0; count < 22; count++) {
            accelerate();

        }
        expect(getSpeedStatus()).toBe(23);
    });

    test('Bike cannot move until it is on', () => {
        accelerate();
        expect(getSpeedStatus()).toBe(0);
    });

    test('Bike gear cannot increase until it is on', () => {
        accelerate();
        expect(getGearstatus()).toBe(0);
    });

    test('Bike gear can increase to gear two', () => {
        bikeOn();
        for (let i = 0; i < 22; i++)
            accelerate();
        expect(getGearstatus()).toBe(2);
    });

    test('Bike gear can increase to gear three', () => {
        bikeOn();
        for (let i = 0; i < 30; i++) {
            accelerate();
        }
        expect(getGearstatus()).toBe(3);
    });

    test('Bike gear can increase to gear four', () => {
        bikeOn();
        for (let i = 0; i < 31; i++)
            accelerate();
        expect(getGearstatus()).toBe(4);
    });

    
    test('Gear should decrease from four to three', () => {
        bikeOn();
        for (let i = 0; i < 41; i++)
            accelerate();
        for (let i = 0; i < 10; i++)
            decelerate();
        expect(getGearstatus()).toBe(3);
    });

    test('Gear should decrease from three to two', () => {
        bikeOn();
        for (let i = 0; i < 29; i++)
            accelerate();
        for (let i = 0; i < 2; i++)
            decelerate();
        expect(getGearstatus()).toBe(2);
    });

    test('Gear should decrease when speed drops below threshold', () => {
        bikeOn();
        for (let i = 0; i < 25; i++)
            accelerate();
        for (let i = 0; i < 5; i++)
            decelerate();
        expect(getGearstatus()).toBe(1);
    });

    test('Gear should not go below zero', () => {
        bikeOn();
        accelerate();
        decelerate();
        expect(getGearstatus()).toBe(0);
    });

    test('Bike should decelerate when on', () => {
        bikeOn();
        accelerate();

        decelerate();

        expect(getSpeedStatus()).toBe(0);
    });

    test('Bike should not decelerate when off', () => {
        decelerate();
        expect(getSpeedStatus()).toBe(0);
    });

    test('Bike should not go below zero speed', () => {
        bikeOn();
        decelerate();
        expect(getSpeedStatus()).toBe(0);
    });
});