package com.example.borrowbooks.repository;

import com.example.borrowbooks.model.BorrowBooks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IBorrowBooks extends JpaRepository<BorrowBooks,Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO muon_sach (id_muon_sach, id, id_sach,status) VALUES (FLOOR(10000 + RAND() * 90000),:id,:iduser,0)", nativeQuery = true)
    void save(@Param("id") int id, @Param("iduser") int iduser);
    @Modifying
    @Transactional
     @Query(value = "UPDATE sach SET so_luong = so_luong-1  WHERE (id_sach =:id)",nativeQuery = true)
    void createBook(@Param("id")int id);

    @Query(value = "SELECT * FROM muon_sach WHERE muon_sach.id = :id AND muon_sach.status = 0",nativeQuery = true)
    Page<BorrowBooks> deleteBook(Pageable pageable, @Param("id") int id);
    @Query(value = "SELECT * FROM muon_sach WHERE muon_sach.id = :id AND muon_sach.id_muon_sach=:idBook AND muon_sach.status = 0",nativeQuery = true)
    List<BorrowBooks> listDeleteBook(int id, int idBook);
    @Modifying
    @Transactional
    @Query(value = "UPDATE muon_sach SET status = 1 WHERE id_muon_sach = :idBook AND id = :id",nativeQuery = true)
    void deleteBorrowBook(int id, int idBook);
}
