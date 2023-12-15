package com.example.vlwatch.controller.ProductHome;

import com.example.vlwatch.dto.product_home.IWatchHome;
import com.example.vlwatch.dto.product_home.UserInfo;
import com.example.vlwatch.model.TableTypeWatch;
import com.example.vlwatch.model.TableWatch;
import com.example.vlwatch.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/male")
    public ResponseEntity<ArrayList<IWatchHome>> getListMale() {
        ArrayList<IWatchHome> hotelDto = productService.watchMale();
        return ResponseEntity.ok(hotelDto);
    }
    @GetMapping("/female")
    public ResponseEntity<ArrayList<IWatchHome>> getListFemale() {
        ArrayList<IWatchHome> hotelDto = productService.watchFemale();
        return ResponseEntity.ok(hotelDto);
    }
    @GetMapping("/user")
    public ResponseEntity<UserInfo> getUserById(@RequestParam String userName) {
        UserInfo userInfo = productService.userInfo(userName);
        System.out.println(userInfo);
        return ResponseEntity.ok(userInfo);
    }
    @GetMapping("/product/{idProduct}")
    public ResponseEntity<TableWatch> getProductById(@PathVariable int idProduct) {
        TableWatch watch = productService.IdProduct(idProduct);
        System.out.println(watch);
        return ResponseEntity.ok(watch);
    }


}
