package com.example.hotel.model.order;

import com.example.hotel.model.hotel.TypeRoomHotel;
import com.example.hotel.model.user.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "table_order_bill")
public class OrderBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private int idOrder;

    @Column(name = "date_order")
    private String dateOrder;

    @Column(name = "date_start")
    private String dateStart;

    @Column(name = "date_end")
    private String dateEnd;

    @Column(name = "sum_price")
    private double sumPrice;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @Column(name = "name_customer")
    private String nameCustomer;

    @Column(name = "phone_customer")
    private String phoneCustomer;

    @ManyToOne
    @JoinColumn(name = "id_type_hotel")
    private TypeRoomHotel typeRoomHotel;

    @Column(name = "status_order")
    private String statusOrder;
    private int quantity;


}

