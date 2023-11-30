package com.example.vlwatch.service.product;

import com.example.vlwatch.dto.product_home.IWatchHome;
import com.example.vlwatch.dto.product_home.UserInfo;
import com.example.vlwatch.repository.product.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService implements IProductService {
   @Autowired
   private IProductRepository productRepository;

   @Override
   public ArrayList<IWatchHome> watchMale() {
      return productRepository.watchMaleHome();
   }

   @Override
   public ArrayList<IWatchHome> watchFemale() {
      return productRepository.watchFemaleHome();
   }

   @Override
   public UserInfo userInfo(String userName) {
      return productRepository.userInfo(userName);
   }
}
