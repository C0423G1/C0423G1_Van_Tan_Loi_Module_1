package tong_hop_cuoi_module_2.repository;

import tong_hop_cuoi_module_2.model.Facility;

import java.util.LinkedHashMap;

public interface IFacilityRepository {
//    LinkedHashMap<Facility, Integer> display();
    LinkedHashMap<Facility, Integer> display(int check);

    void add(Facility facility,int check);

    boolean isIdDuplicated(String id, int check);

}
