package com.example.vlwatch.service.product;

import com.example.vlwatch.dto.product_home.IWatchHome;
import com.example.vlwatch.dto.product_home.UserInfo;
import com.example.vlwatch.model.TableWatch;

import java.util.ArrayList;

public interface IProductService {

    ArrayList<IWatchHome> watchMale();
    ArrayList<IWatchHome> watchFemale();

    UserInfo userInfo(String userName);

    TableWatch IdProduct(int idProduct);
}
