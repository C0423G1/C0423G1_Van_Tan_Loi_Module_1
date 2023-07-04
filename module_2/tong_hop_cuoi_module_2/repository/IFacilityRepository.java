package tong_hop_cuoi_module_2.repository;

import tong_hop_cuoi_module_2.model.Facility;

import java.util.LinkedHashMap;

public interface IFacilityRepository {
    LinkedHashMap<Facility, Integer> display();

    void add(Facility facility);

    boolean isIdDuplicated(String id);

}
