package tong_hop_cuoi_module_2.repository;

import tong_hop_cuoi_module_2.model.Facility;
import tong_hop_cuoi_module_2.model.Room;
import tong_hop_cuoi_module_2.model.Villa;
import tong_hop_cuoi_module_2.service.FacilityService;
import tong_hop_cuoi_module_2.util.WriteAndRead;

import java.util.LinkedHashMap;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {

    public LinkedHashMap<Facility, Integer> display() {
        LinkedHashMap<Facility, Integer> linkedHashMap = new LinkedHashMap<>();
//        linkedHashMap = WriteAndRead.readVilla("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Villa.csv");
        linkedHashMap = WriteAndRead.readRoom("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Room.csv");
//        linkedHashMap = WriteAndRead.readHouse("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\model\\House.csv");
        return linkedHashMap;
    }

    @Override
    public void add(Facility facility) {
        LinkedHashMap<Facility, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap = WriteAndRead.readVilla("C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Villa.csv");
        linkedHashMap.put(facility, 0);
        WriteAndRead.writeVilla(linkedHashMap, "C:\\CodeGymC0423G1\\codegym\\module_1\\module_2\\tong_hop_cuoi_module_2\\data\\Villa.csv", false);
    }


}
