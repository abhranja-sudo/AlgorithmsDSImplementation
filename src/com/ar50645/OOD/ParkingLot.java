package com.ar50645.OOD;

import com.sun.jdi.CharType;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private List<Levels> levels;

    private int getAvailability(SpotTypes spotTypes, int level) {
        if(levels.size() < level) {
            throw new SlotNotFoundException();
        }

        return levels.get(level).getSpotsAvailable();
    }
}

public enum VehicleTypes {
    CAR,
    BUS,
    MOTORCYCLE
}

@Getter
public enum SpotTypes {

    // constructor
    SMALL(List.of(VehicleTypes.MOTORCYCLE)),
    COMPACT(List.of(VehicleTypes.CAR, VehicleTypes.MOTORCYCLE)),
    LARGE(List.of(VehicleTypes.CAR, VehicleTypes.MOTORCYCLE, VehicleTypes.BUS));

    private List<VehicleTypes> allowedTypes;
}

@AllArgsArgument
public class Spot {
    private int slotNumber;
    private SpotTypes spotType;
    private boolean occupied;
    private Instant lastOccupiedTime;

    public void book() {
        this.occupied = true;
        lastOccupiedTime = Instant.now();
    }

    public void release() {
        this.occupied = false;
    }
}

public class Levels {
    private int level;
    private Map<SpotTypes, Integer> spotsAvailable;
    private List<Spot> spots;

    // constructor
    public void Levels(int level, Map<SpotTypes, Integer> spotsAvailable) {
        this.level = level;
        int counter = 0;
        for(Map.Entry<SpotTypes, Integer> entry: spotsAvailable.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++) {
                spots.add(new Spot(counter, entry.getKey()));
            }
        }
        this.spotsAvailable = spotsAvailable;
        this.spots = spots;
    }

    public synchronized void bookSpot(Spot spot) {
        spot.book();
        spotsAvailable.put(spot.SpotTypes, spotsAvailable.get(spo
}

public record Ticket(Spot spot, String ticketNumber, String vehicleNumber){};
public class Reservation {

    private Map<Slot, Ticket> booking;
    private Map<VehicleTypes, FeesCalculator> feesCalculatorMap;

    private static final Integer PRICE_PER_HOUR = 10;
    private ParkingLot parkingLot;
    public Integer booking(VehicleTypes carType) {
        for(Levels level: parkingLot.getLevels()) {
            Spot slot = search(carType, levels);
            synchronized (slot) {
                return new Ticket(UUID.randomUUID().toString(), level.getLevelNumber(), spot.getSlotNumber(), vehicleType, Instant.now());
            }
        }
        throw new SlotNotFoundException();
    }

    private long checkOut(Ticket ticket) {
        ticket.spot().release();
        return feesCalculatorMap.get(ticket.spot()).calculatePrice(Duration.between(Instant.now(), booking.get()))
    }

    private Spot search(VehicleTypes carType, Levels level) {
        for(Spot spot: level.getSpots()) {
            if(!spot.occupied()) {
                return spot;
            }
        }

        return null;
    }


    public interface FeesCalculator {
        long calculatePrice(Duration duration);
    }

    public class CarFeesCalculator implements FeesCalculator {
        private static final int RATE_PER_HOUR = 5;

        @Override
        public long calculatePrice(Duration duration) {
            return duration.toHours() * RATE_PER_HOUR;
        }
    }

    public class TruckFeesCalculator implements FeesCalculator {
        private static final int RATE_PER_HOUR = 10;

        @Override
        public long calculatePrice(Duration duration) {
            return duration.toHours() * RATE_PER_HOUR;
        }
    }
}

}


