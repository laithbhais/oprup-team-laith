package net.oprup.erp.service;

import net.oprup.erp.exception.NotFoundException;
import net.oprup.erp.model.Bank;
import net.oprup.erp.model.ItemRequest;
import net.oprup.erp.model.ItemRequestDetails;
import net.oprup.erp.repo.ItemRequestDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemRequestDetailsService {
    private final ItemRequestDetailsRepo Repo;
    @Autowired
    public ItemRequestDetailsService(ItemRequestDetailsRepo repo) {
        Repo = repo;
    }
    public ItemRequestDetails addItemRequestDetails(ItemRequestDetails itemRequestDetails){
        itemRequestDetails.setDeleteFlag(1);
        return Repo.save(itemRequestDetails);
    }
    public List<ItemRequestDetails> findAllItemRequestDetails(){
        return  Repo.deleteItemRequestByDeleteFlag();
    }

    public ItemRequestDetails findItemRequestDetailsById(Long itemRequestDetails){
        return Repo.findItemRequestDetailsByitemRequestDetailsId(itemRequestDetails)
                .orElseThrow(() -> new NotFoundException("Item by id: " + itemRequestDetails + " not found"));
    }

    public ItemRequestDetails deleteItemRequestDetails(ItemRequestDetails itemRequestDetails){
        itemRequestDetails.setDeleteFlag(0);
        return Repo.save(itemRequestDetails);
    }
    public ItemRequestDetails updateItemRequestDetails(ItemRequestDetails itemRequestDetails){
        itemRequestDetails.setDeleteFlag(1);
        return Repo.save(itemRequestDetails);
    }

    public List<ItemRequestDetails> getItemRequestDetailsByItemRequest(ItemRequest itemRequestDetails) {
        return Repo.findItemRequestDetailsByItemRequest(itemRequestDetails);
    }


    public ItemRequestDetails deleteByItemRequestDetailsId(ItemRequestDetails itemRequestDetails){
        itemRequestDetails.setDeleteFlag(0);
        return Repo.save(itemRequestDetails);
    }

}

