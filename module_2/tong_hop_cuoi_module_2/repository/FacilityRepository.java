package tong_hop_cuoi_module_2.repository;

import tong_hop_cuoi_module_2.model.Facility;
import tong_hop_cuoi_module_2.model.House;
import tong_hop_cuoi_module_2.model.Room;
import tong_hop_cuoi_module_2.model.Villa;
import tong_hop_cuoi_module_2.service.FacilityService;
import tong_hop_cuoi_module_2.util.WriteAndRead;

import java.util.LinkedHashMap;
import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    public static LinkedHashMap<Facility, Integer> linkedHashMap = new LinkedHashMap<>();

    static {
        linkedHashMap.put(new House("SVHO-0001", "House 1", 100, 5, 12, "Ngày", "Hạng Thường", 2), 1);
        linkedHashMap.put(new House("SVHO-0002", "House 2", 120, 7, 18, "Tháng", "Hạng Sang", 3), 4);
        linkedHashMap.put(new Villa("SVVL-0001", "Villa 1", 300, 10, 19, "Năm", "Cao Cấp", 50, 2), 1);
        linkedHashMap.put(new Villa("SVVL-0002", "Villa 2", 380, 10, 15, "Giờ", "Cao Cấp", 70, 3), 8);
        linkedHashMap.put(new Room("SVRO-0002", "Room 2", 50, 1, 2, "Ngày", "Đỗ Xe Miễn Phí"), 8);
        linkedHashMap.put(new Room("SVRO-0001", "Room 1", 50, 1, 2, "Ngày", "Đỗ Xe Miễn Phí"), 2);
    }

    public LinkedHashMap<Facility, Integer> display() {
        return linkedHashMap;
    }

    @Override
    public void add(Facility facility) {
        linkedHashMap.put(facility, 0);
    }

    public boolean isIdDuplicated(String id) {
        for (Facility facility : linkedHashMap.keySet()) {
            if (facility.getId().equals(id)) {
                return true;
            }
        }
        return false;

    }


}
