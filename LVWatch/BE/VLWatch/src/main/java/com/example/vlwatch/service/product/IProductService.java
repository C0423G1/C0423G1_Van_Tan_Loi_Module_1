package com.example.vlwatch.service.product;

import com.example.vlwatch.dto.product_home.IWatchHome;

import java.util.ArrayList;

public interface IProductService {

    ArrayList<IWatchHome> watchMale();
    ArrayList<IWatchHome> watchFemale();
}
