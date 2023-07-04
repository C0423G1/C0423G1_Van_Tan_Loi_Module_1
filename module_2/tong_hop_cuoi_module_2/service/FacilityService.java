package tong_hop_cuoi_module_2.service;

import tong_hop_cuoi_module_2.model.Facility;
import tong_hop_cuoi_module_2.model.House;
import tong_hop_cuoi_module_2.model.Room;
import tong_hop_cuoi_module_2.model.Villa;
import tong_hop_cuoi_module_2.repository.FacilityRepository;
import tong_hop_cuoi_module_2.repository.IFacilityRepository;
import tong_hop_cuoi_module_2.util.Regex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public void display() {
        LinkedHashMap<Facility, Integer> integerLinkedHashMap = facilityRepository.display();
        for (Map.Entry<Facility, Integer> f : integerLinkedHashMap.entrySet()) {
            System.out.println(f.getKey() + "," + f.getValue());
        }
    }

    @Override
    public void add(int check) {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        do {
            flag = true;
            try {
                String id = null;
                switch (check) {
                    case 1:
                        do {
                            System.out.println("Mời Nhập Mã Dịch Vụ (SVVL-XXXX ,X:từ 0-9)");
                            id = scanner.nextLine();
                            if (!Regex.checkVilla(id)) {
                                System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                            }
                            if(!facilityRepository.isIdDuplicated(id)){
                                System.out.println("ID Trùng Vui lòng Nhập Lại");
                            }
                        } while (!Regex.checkVilla(id));
                        break;
                    case 2:
                        do {
                            System.out.println("Mời Nhập Mã Dịch Vụ (SVHO-XXXX ,X:từ 0-9)");
                            id = scanner.nextLine();
                            if (!Regex.checkHouse(id)) {
                                System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                            }
                            if(!facilityRepository.isIdDuplicated(id)){
                                System.out.println("ID Trùng Vui lòng Nhập Lại");
                            }
                        } while (!Regex.checkHouse(id));
                        break;
                    case 3:
                        do {
                            System.out.println("Mời Nhập Mã Dịch Vụ (SVRO-XXXX ,X:từ 0-9)");
                            id = scanner.nextLine();
                            if (!Regex.checkRooom(id)) {
                                System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                            }
                            if(!facilityRepository.isIdDuplicated(id)){
                                System.out.println("ID Trùng Vui lòng Nhập Lại");
                            }
                        } while (!Regex.checkRooom(id));
                        break;
                }
                String name = null;
                do {
                    System.out.println("Mời Nhập Tên Dịch Vụ (Chữ cái đầu viết hoa , tất cả chữ sau đều viết thường)");
                    name = scanner.nextLine();
                    if (!Regex.checkNameFacility(name)) {
                        System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                    }
                } while (!Regex.checkNameFacility(name));
                double acreage = 0;
                while (true) {
                    try {
                        System.out.println("Mời Nhập Diện Tích Sử Dụng (Diện Tích Sử Dụng Phải lớn hơn 30m2) ");
                        acreage = Double.parseDouble(scanner.nextLine());
                        if (acreage > 30) {
                            break;
                        }
                        System.out.println("Diện tích sử dụng phải lớn hớn 30m2 . Vui lòng Nhập Lại");
                    } catch (Exception e) {
                        System.out.println("Sai định Dạng Vui Lòng Nhập Lại");
                    }
                }
                double expense = 0;
                while (true) {
                    try {
                        System.out.println("Mời Nhập Chi Phí Thuế ( Từ 1 Đến 10)");
                        expense = Double.parseDouble(scanner.nextLine());
                        if (expense > 0 && expense <= 10) {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                    }
                }
                int quantily;
                while (true) {
                    try {
                        System.out.println("Mời Nhập Số lượng Khách");
                        quantily = Integer.parseInt(scanner.nextLine());
                        if (quantily < 21 && quantily > 0) {
                            break;
                        }
                        System.out.println("số lượng khách phải lớn hơn 0 và nhỏ hơn 21");
                    } catch (Exception e) {
                        System.out.println("Sai Định Dạng Vui lòng Nhập Lại");
                    }
                }
                String date = null;
                boolean flagCheck = false;
                do {
                    try {
                        flagCheck = false;
                        System.out.println("Mời Nhập Thời Gian Thuê theo :" + "\n1.Năm" + "\n2.Tháng" + "\n3.Ngày" + "\n4.Giờ ");
                        int checkDate = Integer.parseInt(scanner.nextLine());
                        switch (checkDate) {
                            case 1:
                                date = "Năm";
                                break;
                            case 2:
                                date = "Tháng";
                                break;
                            case 3:
                                date = "Ngày";
                                break;
                            case 4:
                                date = "Giờ";
                                break;
                            default:
                                flagCheck = true;
                                System.out.println("Ngoài Phạm Vi truy Cập . Vui lòng nhập lại ");
                        }
                    } catch (Exception e) {
                        flagCheck = true;
                        System.out.println("Sai Định Dạng Vui Lòng Nhập Lại");
                    }
                } while (!flagCheck);
                int floors = 0;
                String roomStandard = "";
                if (check == 2 || check == 1) {
                    System.out.println("Tiêu chuẩn phòng");
                    roomStandard = scanner.nextLine();
                    while (true) {
                        System.out.println("Số tầng");
                        floors = Integer.parseInt(scanner.nextLine());
                        if (floors > 0) {
                            break;
                        }
                        System.out.println("Số tầng phải là số nguyên dương . Mời Bạn Nhập Lại");
                    }
                }
                double poolArea = 0;
                if (check == 1) {
                    while (true) {
                        try {
                            System.out.println("Diện tích hồ bơi (Phải Lớn hơn 30m2)");
                            poolArea = Double.parseDouble(scanner.nextLine());
                            if (poolArea > 30 && poolArea < (acreage - 5)) {
                                break;
                            } else if (poolArea == acreage && poolArea > (acreage - 5)) {
                                System.out.println("Không có hồ bơi");
                                break;
                            }
                            System.out.println("Diện tích hồ bơi (Phải Lớn hơn 30m2 và nhỏ hơn diện tích sử dụng). Mời Bạn Nhập Lại");

                        } catch (Exception e) {
                            System.out.println("Sai định dạng Vui lòng Nhập Lại");
                        }

                    }
                }
                String freeService = null;
                if (check == 3) {
                    System.out.println("Dịch Vụ Miễn Phí");
                    freeService = scanner.nextLine();
                }
                switch (check) {
                    case 1:
                        System.out.println("Thêm Thông Tin Villa Mới Thành Công");
                        Villa villa = new Villa(id, name, acreage, expense, quantily, date, roomStandard, poolArea, floors);
                        facilityRepository.add(villa);
                        break;
                    case 2:
                        System.out.println("Thêm Thông Tin House Mới Thành Công");
                        House house = new House(id, name, acreage, expense, quantily, date, roomStandard, floors);
                        facilityRepository.add(house);
                        break;
                    case 3:
                        System.out.println("Thêm Thông Tin Room Mới Thành Công");
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
