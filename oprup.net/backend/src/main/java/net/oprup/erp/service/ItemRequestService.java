package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.ItemRequest;
import net.oprup.erp.repo.ItemRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemRequestService {
    private final ItemRequestRepo Repo;

    @Autowired
    public ItemRequestService(ItemRequestRepo repo) {
        Repo = repo;
    }

    public ItemRequest addItemRequest(ItemRequest itemRequest){
        itemRequest.setDeleteFlag(1);
        return Repo.save(itemRequest);
    }
    public List<ItemRequest> findAllItemRequest(){
        return  Repo.deleteItemRequestByDeleteFlag();
    }

    public ItemRequest findItemRequestById(Long itemRequest){
        return Repo.findItemRequestByitemRequestId(itemRequest)
                .orElseThrow(() -> new NotFoundException("Item by id: " + itemRequest + " not found"));
    }

    public ItemRequest deleteItemRequest(ItemRequest itemRequest){
        itemRequest.setDeleteFlag(0);
        return Repo.save(itemRequest);
    }
    public ItemRequest updateItemRequest(ItemRequest itemRequest){
        itemRequest.setDeleteFlag(1);
        return Repo.save(itemRequest);
    }

    public long countId(){

        return Repo.countItemRequestByItemRequestId();
    }

}
