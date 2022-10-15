package net.oprup.erp.service;




import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Store;
import net.oprup.erp.repo.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class StoreService {
    private final StoreRepo storeRepo;

    @Autowired
    public StoreService(StoreRepo storeRepo) {
        this.storeRepo = storeRepo;
    }



    public Store addStore(Store store) {
        store.setDeleteFlag(1);
        return storeRepo.save(store);
    }

    public Store updateStore(Store store) {
        store.setDeleteFlag(1);
        return storeRepo.save(store);
    }
    public List<Store> findAllStores(){
        return  storeRepo.findStoreByDeleteFlag();
    }



    public void deleteStoreByStoreId(Long storeId){
        storeRepo.deleteStoreByStoreId(storeId);
    }

    public Store delete(Store store){
        store.setDeleteFlag(0);
        return storeRepo.save(store);
    }

    public Store findStoreById(Long storeId) {
        return storeRepo.findStoreByStoreId(storeId)
                .orElseThrow(() -> new NotFoundException("InsuranceCompany by id: " + storeId + " not found"));
    }
    public void deleteStore(Long storeId){

        this.storeRepo.deleteById(storeId);
    }


}
