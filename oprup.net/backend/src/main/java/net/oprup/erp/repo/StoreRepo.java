package net.oprup.erp.repo;


import net.oprup.erp.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface StoreRepo extends JpaRepository<Store, Long> {
    Optional<Store> findStoreByStoreId(Long storeId);

    void deleteStoreByStoreId(Long storeId);

    @Query("select s from Store s where s.deleteFlag =1")
    List<Store> findStoreByDeleteFlag();





}











