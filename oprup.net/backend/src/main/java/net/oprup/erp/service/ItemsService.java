package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Items;
import net.oprup.erp.repo.ItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ItemsService {
    private final ItemsRepo Repo;

    @Autowired
    public ItemsService(ItemsRepo repo) {
        Repo = repo;
    }

    public Items addItems(Items items){
        items.setDeleteFlag(1);
        return Repo.save(items);
    }
    public List<Items> findAllItems(){
        return  Repo.deleteItemsByDeleteFlag();
    }

    public Items findItemsById(Long itemsId){
        return Repo.findItemsByitemsId(itemsId)
                .orElseThrow(() -> new NotFoundException("Item by id: " + itemsId + " not found"));
    }

    public Items deleteItems(Items item){
        item.setDeleteFlag(0);
        return Repo.save(item);
    }
    public Items updateItem(Items items){
        items.setDeleteFlag(1);
        return Repo.save(items);
    }

    public long countId(){

        return Repo.countItemsByItemsId();
    }





}
