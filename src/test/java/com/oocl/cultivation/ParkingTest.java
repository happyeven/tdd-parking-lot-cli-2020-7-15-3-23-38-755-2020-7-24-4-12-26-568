package com.oocl.cultivation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author ZHUDO2
 * @Date 7/24/2020 4:28 PM
 * @Version 1.0
 */
public class ParkingTest {
    @Test
    void should_return_ticket_when_parking_boy_parking_car_given_car_and_parking_boy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car(1);
        //when
        Ticket ticket = parkingBoy.parkingCar(car);
        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_correct_car_when_fetch_car_given_ticket_and_parking_boy_and_car() {
        //given
        int token = 1;
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car(token);
        Ticket ticket = parkingBoy.parkingCar(car);
        //when
        Car resultCar = parkingBoy.fetchingCar(ticket);
        //then
        Assertions.assertEquals(car.getCarId(), resultCar.getCarId());
    }

    @Test
    void should_return_2_ticket_when_parking_boy_parking_car_given_2_car_and_parking_boy() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car firstCar = new Car(1);
        Car secondCar = new Car(2);
        //when
        Ticket firstTicket = parkingBoy.parkingCar(firstCar);
        Ticket secondTicket = parkingBoy.parkingCar(secondCar);
        //then
        Assertions.assertNotNull(firstTicket);
        Assertions.assertNotNull(secondTicket);
    }

    @Test
    void should_return_2_car_when_fetch_car_given_2_ticket_and_parking_boy_and_2_car() {
        //given
        int firstToken = 1;
        int secondToken = 2;
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car firstTargetCar = new Car(firstToken);
        Car secondTargetCar = new Car(secondToken);
        Ticket firstTicket = parkingBoy.parkingCar(firstTargetCar);
        Ticket secondTicket = parkingBoy.parkingCar(secondTargetCar);
        //when
        Car firstFetchingCar = parkingBoy.fetchingCar(firstTicket);
        Car secondFetchingCar = parkingBoy.fetchingCar(secondTicket);
        //then
        Assertions.assertEquals(firstTargetCar, firstFetchingCar);
        Assertions.assertEquals(secondTargetCar, secondFetchingCar);
    }

    @Test
    void should_return_null_when_parking_car_given_wrong_ticket_and_parking_boy() {
        //given
        int token = 20;
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Ticket wrongTicket = new Ticket(token);
        //when
        Car fetchingCar = parkingBoy.fetchingCar(wrongTicket);
        //then
        Assertions.assertNull(fetchingCar);
    }

    @Test
    void should_return_null_when_fetching_car_given_used_ticket_and_parking_boy() {
        //given
        int token = 20;
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car(token);
        Ticket ticket = parkingBoy.parkingCar(car);
        Car firstCar = parkingBoy.fetchingCar(ticket);
        //when
        Car secondCar = parkingBoy.fetchingCar(ticket);
        //then
        Assertions.assertNull(secondCar);
    }

    @Test
    void should_return_null_when_parking_boy_parking_car_given_car_and_parking_lot_has_no_position() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        int parkingCarIndex = 0;
        for (; parkingCarIndex < 10; parkingCarIndex++) {
            parkingBoy.parkingCar(new Car(parkingCarIndex));
        }
        //when
        Ticket ticket = parkingBoy.parkingCar(new Car(parkingCarIndex));
        //then
        Assertions.assertNull(ticket);
    }

    @Test
    void should_return_null_when_parking_boy_fetch_car_given_no_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        //when
        Car car = parkingBoy.fetchingCarWithoutTicket();
        //then
        Assertions.assertNull(car);
    }

    @Test
    void should_return_null_when_parking_boy_parking_car_given_car_is_null() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = null;
        //when
        Ticket ticket = parkingBoy.parkingCar(car);
        //then
        Assertions.assertNull(ticket);
    }

    @Test
    void should_return_unrecognized_parking_ticket_when_query_error_message_given_does_not_provided_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        int wrongToken = 1;
        Ticket wrongTicket = new Ticket(wrongToken);
        parkingBoy.fetchingCar(wrongTicket);
        //when
        String errorMessage = parkingBoy.queryErrorMessage();
        //then
        Assertions.assertEquals("Unrecognized parking ticket.", errorMessage);

    }

    @Test
    void should_return_unrecognized_parking_ticket_when_query_error_message_given_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        int token = 1;
        Car car = new Car(token);
        Ticket ticket = parkingBoy.parkingCar(car);
        parkingBoy.fetchingCar(ticket);
        parkingBoy.fetchingCar(ticket);
        //when
        String errorMessage = parkingBoy.queryErrorMessage();
        //then
        Assertions.assertEquals("Unrecognized parking ticket.", errorMessage);
    }

    @Test
    void should_return_please_provide_ticket_when_query_error_message_given_without_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.fetchingCarWithoutTicket();
        //when
        String errorMessage = parkingBoy.queryErrorMessage();
        //then
        Assertions.assertEquals("Please provide your parking ticket.", errorMessage);
    }

    @Test
    void should_return_not_enough_position_when_query_error_message_given_1_car_and_parkingLot_without_position() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setAvailableCapacity(0);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.parkingCar(new Car(1));
        //when
        String errorMessage = parkingBoy.queryErrorMessage();
        //then
        Assertions.assertEquals("Not enough position.", errorMessage);
    }

    @Test
    void should_return_ticket_with_correspondParkingLot_is_secondParkingLot_when_parking_car_given_1_car_1_full_parkingLot_and_1_available_parkingLot() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        firstParkingLot.setAvailableCapacity(0);
        ParkingLot secondParkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
        Car car = new Car(1);
        //when
        Ticket ticket = parkingBoy.parkingCar(car);
        //then
        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(secondParkingLot, ticket.getCorrespondParkingLot());
    }

    @Test
    void should_return_ticket_with_correspond_ParkingLot_is_secondParkingLot_when_smart_parking_boy_parking_car_given_1_car_and_3_parkingLots_availableCapacity_respectively_8_10_9() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        firstParkingLot.setAvailableCapacity(8);
        ParkingLot secondParkingLot = new ParkingLot();
        secondParkingLot.setAvailableCapacity(10);
        ParkingLot thirdParkingLot = new ParkingLot();
        thirdParkingLot.setAvailableCapacity(9);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(firstParkingLot, secondParkingLot, thirdParkingLot);
        //when
        Ticket ticket = smartParkingBoy.parkingCar(new Car(1));
        //then
        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(secondParkingLot, ticket.getCorrespondParkingLot());
    }

    @Test
    void
    should_return_ticket_with_correspond_ParkingLot_is_secondParkingLot_when_smart_parking_boy_parking_car_given_1_car_and_3_parkingLots_availableCapacity_respectively_6_8_8() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        firstParkingLot.setAvailableCapacity(6);
        ParkingLot secondParkingLot = new ParkingLot();
        secondParkingLot.setAvailableCapacity(8);
        ParkingLot thirdParkingLot = new ParkingLot();
        thirdParkingLot.setAvailableCapacity(8);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(firstParkingLot,
                secondParkingLot, thirdParkingLot);
        //when
        Ticket ticket = smartParkingBoy.parkingCar(new Car(1));
        //then
        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(secondParkingLot, ticket.getCorrespondParkingLot());
    }

    @Test
    void should_return_ticket_with_correspond_ParkingLot_is_thirdParkingLot_when_super_smart_parking_boy_parking_car_given_1_car_and_3_parkingLots_available_position_rate_respectively_0_point_7and_0_point_6_and_0_point_8() {
        //given
        ParkingLot firstParkingLot = new ParkingLot();
        firstParkingLot.setAvailableCapacity(7);
        ParkingLot secondParkingLot = new ParkingLot();
        secondParkingLot.setAvailableCapacity(6);
        ParkingLot thirdParkingLot = new ParkingLot();
        thirdParkingLot.setCapacity(5);
        thirdParkingLot.setAvailableCapacity(4);
        Car car = new Car(1);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(firstParkingLot, secondParkingLot, thirdParkingLot);
        //when
        Ticket ticket = superSmartParkingBoy.parkingCar(car);
        //then
        Assertions.assertNotNull(ticket);
        Assertions.assertEquals(thirdParkingLot, ticket.getCorrespondParkingLot());
    }

    @Test
    void should_return_ticket_when_service_manager_specify_parking_boy_from_parkingBoys_parking_car_given_1_car_1_parkingLot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingBoy);
        Car car = new Car(1);
        //when
        Ticket ticket = parkingLotServiceManager.specifyParkingBoyToParkingCar(parkingBoy, car);
        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_null_when_manager_specify_parking_boy_not_managed_by_him_to_parking_car_given_1_car() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        //when
        Ticket ticket = parkingLotServiceManager.specifyParkingBoyToParkingCar(parkingBoy, car);
        //then
        Assertions.assertNull(ticket);
    }

    @Test
    void should_return_ticket_when_manager_specify_parking_boy_managed_by_him_to_fetching_car_given_ticket() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingBoy);
        Ticket ticket = parkingLotServiceManager.specifyParkingBoyToParkingCar(parkingBoy, car);
        //when
        Car targetCar = parkingLotServiceManager.specifyParkingBoyToFetchingCar(parkingBoy, ticket);
        //then
        Assertions.assertNotNull(targetCar);
    }

    @Test
    void should_return_null_when_manager_specify_parking_boy_not_managed_by_him_to_fetching_car_given_ticket() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoyManaged = new ParkingBoy(parkingLot);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingBoyManaged);
        ParkingBoy parkingBoyNotManaged = new ParkingBoy(parkingLot);
        Ticket ticket = parkingLotServiceManager.specifyParkingBoyToParkingCar(parkingBoyManaged, car);
        //when
        Car targetCar = parkingLotServiceManager.specifyParkingBoyToFetchingCar(parkingBoyNotManaged, ticket);
        //then
        Assertions.assertNull(targetCar);
    }

    @Test
    void should_return_ticket_when_manager_parking_car_given_1_car_1_parking_lot_owned_by_manager() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        parkingLotServiceManager.setParkingLot(parkingLot);
        //when
        Ticket ticket = parkingLotServiceManager.parkingCar(car);
        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_car_when_manager_fetching_car_given_1_ticket_1_parking_lot() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager();
        parkingLotServiceManager.setParkingLot(parkingLot);
        Ticket ticket = parkingLotServiceManager.parkingCar(car);
        //when
        Car targetCar = parkingLotServiceManager.fetchingCar(ticket);
        //then
        Assertions.assertEquals(targetCar,car);
    }

    @Test
    void should_return_Unrecognized_parking_ticket_when_manager_specify_parking_boy_fetching_car_given_used_ticket() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingLotServiceManager parkingLotServiceManager = new ParkingLotServiceManager(parkingBoy);
        Ticket ticket = parkingLotServiceManager.specifyParkingBoyToParkingCar(parkingBoy, car);
        parkingLotServiceManager.specifyParkingBoyToFetchingCar(parkingBoy,ticket);
        parkingLotServiceManager.specifyParkingBoyToFetchingCar(parkingBoy, ticket);
        //when
        String errorMessage = parkingLotServiceManager.displayErrorMessage(parkingBoy);
        //then
        Assertions.assertEquals("Unrecognized parking ticket.",errorMessage);
    }


}
