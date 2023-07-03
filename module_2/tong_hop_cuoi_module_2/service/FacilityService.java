package tong_hop_cuoi_module_2.service;

import tong_hop_cuoi_module_2.model.Facility;
import tong_hop_cuoi_module_2.model.House;
import tong_hop_cuoi_module_2.model.Room;
import tong_hop_cuoi_module_2.model.Villa;
import tong_hop_cuoi_module_2.repository.FacilityRepository;
import tong_hop_cuoi_module_2.repository.IFacilityRepository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public void display() {
        LinkedHashMap<Facility, Integer> integerLinkedHashMap = facilityRepository.display();
        for (Map.Entry<Facility,Integer> f : integerLinkedHashMap.entrySet()) {
            System.out.println(f.getKey()+","+f.getValue());
        }

    }

    @Override
    public void add(int check) {
        boolean flag = true;
        do {
            flag = true;
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Mời Nhập Mã Dịch Vụ");
                String id = scanner.nextLine();
                System.out.println("Mời Nhập Tên Dịch Vụ");
                String name = scanner.nextLine();
                System.out.println("Mời Nhập Diện Tích Sử Dụng ");
                double acreage = Double.parseDouble(scanner.nextLine());
                System.out.println("Mời Nhập Chi Phí Thuế");
                double expense = Double.parseDouble(scanner.nextLine());
                System.out.println("Mời Nhập Số lượng Khách");
                int quantily = Integer.parseInt(scanner.nextLine());
                System.out.println("Mời Nhập Kiểu Thuê");
                String date = scanner.nextLine();
                String roomStandard = null;
                int floors = 0;
                if (check == 2 || check == 1) {
                    System.out.println("Tiêu chuẩn phòng");
                    roomStandard = scanner.nextLine();
                    System.out.println("Số tầng");
                    floors = Integer.parseInt(scanner.nextLine());
                }
                double poolArea = 0;
                if (check == 1) {
                    System.out.println("Diện tích hồ bơi");
                    poolArea = Double.parseDouble(scanner.nextLine());
                }
                String freeService = null;
                if (check == 3) {
                    System.out.println("Dịch Vụ Miễn Phí");
                    freeService = scanner.nextLine();
                }
                switch (check) {
                    case 1:
                        Villa villa = new Villa(id, name, acreage, expense, quantily, date, roomStandard, poolArea, floors);
                        facilityRepository.add(villa);
                        break;
                    case 2:
                        House house = new House(id, name, acreage, expense, quantily, date, roomStandard, floors);
                        facilityRepository.add(house);
                        break;
                    case 3:
                        Room room = new Room(id, name, acreage, expense, quantily, date, freeService);
                        facilityRepository.add(room);
                        break;
                }

            } catch (Exception ex) {
                flag = false;
                ex.printStackTrace();
                System.out.println("Lỗi !");
            }
        } while (flag == false);


    }


}
