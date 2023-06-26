package tong_hop_cuoi_module_2.model;

public abstract class Facility {
    private String laundry;
    public String housekeeping;
    public String restaurantAndDining;
    public String parking;
    public String tourBookingAndTicketReservation;

    public Facility() {
    }

    @Override
    public String toString() {
        return "Laundry service: Includes washing, ironing, and folding personal clothing, bed linens, towels, and other fabric items.\n" +
                "\n" +
                "Housekeeping service: Involves cleaning and tidying up the bedroom, living room, and bathroom. Tasks include surface cleaning, floor sweeping, changing bed linens, and providing necessary toiletries.\n" +
                "\n" +
                "Restaurant and dining service: Provides food and dining services either within the premises of the Villa, House, or in a separate dining area. This can include à la carte service, buffet service, or on-demand catering.\n" +
                "\n" +
                "Parking service: Offers secure and convenient parking space for guests using the Villa, House, or Room facilities.\n" +
                "\n" +
                "Internet and cable TV service: Provides fast internet connection and cable television to meet guests' information and entertainment needs.\n" +
                "\n" +
                "Security and safety service: Ensures the safety of guests by providing 24/7 security service, surveillance systems, and appropriate safety measures.\n" +
                "\n" +
                "Customer support service: Provides assistance and handles guest requests, including guidance on facility usage, tour booking, flight ticketing, car rental, etc.\n" +
                "\n" +
                "Transportation service: Offers transportation service from airports, train stations, or pick-up points to the Villa, House, or Room, and vice versa.\n" +
                "\n" +
                "Tour guiding service: Provides information and guidance on local attractions, recreational activities, and destinations for guests to enjoy and explore.\n" +
                "\n" +
                "Tour booking and ticket reservation service: Assists guests in booking tours and securing tickets for various activities and attractions." +
                "\n"+
                "Dịch vụ giặt là: Bao gồm việc giặt, là và là ủi quần áo cá nhân, chăn ga, khăn tắm và các vật dụng vải khác.\n" +
                "\n" +
                "Dịch vụ dọn phòng: Bao gồm việc làm sạch và dọn dẹp phòng ngủ, phòng khách và phòng tắm. Công việc bao gồm lau chùi bề mặt, quét dọn sàn, thay ga trải giường và cung cấp các vật dụng vệ sinh cần thiết.\n" +
                "\n" +
                "Dịch vụ nhà hàng và phục vụ bữa ăn: Cung cấp dịch vụ ẩm thực và phục vụ bữa ăn trong khuôn viên của Villa, House hoặc trong phòng ăn riêng biệt. Đây có thể là dịch vụ tự chọn món ăn, dịch vụ buffet hoặc dịch vụ phục vụ theo yêu cầu.\n" +
                "\n" +
                "Dịch vụ đỗ xe: Cung cấp không gian đỗ xe an toàn và tiện ích cho khách hàng sử dụng dịch vụ Villa, House hoặc Room.\n" +
                "\n" +
                "Dịch vụ Internet và truyền hình cáp: Cung cấp kết nối Internet nhanh chóng và truyền hình cáp để đáp ứng nhu cầu truy cập thông tin và giải trí của khách hàng.\n" +
                "\n" +
                "Dịch vụ bảo vệ và an ninh: Đảm bảo an toàn cho khách hàng bằng cách cung cấp dịch vụ bảo vệ 24/7, hệ thống giám sát an ninh và các biện pháp an toàn phù hợp.\n" +
                "\n" +
                "Dịch vụ hỗ trợ khách hàng: Cung cấp hỗ trợ và tiếp nhận yêu cầu từ khách hàng, bao gồm hướng dẫn về cách sử dụng tiện nghi trong phòng, đặt tour du lịch, đặt vé máy bay, đặt xe, vv.\n" +
                "\n" +
                "Dịch vụ vận chuyển: Cung cấp dịch vụ vận chuyển từ sân bay, ga tàu hoặc điểm đón đến Villa, House hoặc Room và ngược lại.\n" +
                "\n" +
                "Dịch vụ hướng dẫn du lịch: Cung cấp thông tin và hướng dẫn về các điểm tham quan, hoạt động giải trí và điểm đến trong khu vực để khách hàng có thể tận hưởng và khám phá.\n" +
                "\n" +
                "Dịch vụ đặt tour và đặt vé";
    }
}
