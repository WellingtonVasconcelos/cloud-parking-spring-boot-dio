package br.com.tom.cloud.service;

import br.com.tom.cloud.exception.ParkingNotFoundException;
import br.com.tom.cloud.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap();

    static {
        var id = getUUID();
        var id1 = getUUID();
        Parking parking = new Parking(id, "CRB-1997", "SP", "IDEA", "PRATA");
        Parking parking1 = new Parking(id1, "CAB-1972", "SP", "GM S10", "BRANCA");

        parkingMap.put(id, parking);
        parkingMap.put(id1, parking1);
    }
    public List<Parking> findAll(){

        return parkingMap.values().stream().collect(Collectors.toList());
    }
    private static String getUUID(){

        return UUID.randomUUID().toString().replace("-","");
    }

    public Parking findById(String id) {
        Parking parking = parkingMap.get(id);
        if (parking == null){
            throw new ParkingNotFoundException(id);
        }
        return parking;
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;
    }

    public void delete(String id) {
        findById(id);
        parkingMap.remove(id);

    }

    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setColor(parkingCreate.getColor());
        parkingMap.replace(id, parking);
        return parking;
    }
}
