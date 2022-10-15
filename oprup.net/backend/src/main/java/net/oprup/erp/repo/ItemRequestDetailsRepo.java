package net.oprup.erp.repo;

import net.oprup.erp.model.ItemRequest;
import net.oprup.erp.model.ItemRequestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRequestDetailsRepo extends JpaRepository<ItemRequestDetails, Long> {
    Optional<ItemRequestDetails> findItemRequestDetailsByitemRequestDetailsId(Long itemRequestDetailsId);

    @Query("select e from ItemRequestDetails e where e.deleteFlag =1")
    List<ItemRequestDetails> deleteItemRequestByDeleteFlag();

    @Query(value="select * from item_request_details  AS c where c.item_request_id=:item_request_id and c.delete_flag=1",nativeQuery = true)
    List<ItemRequestDetails> findItemRequestDetailsByItemRequest(@Param("item_request_id")ItemRequest itemRequest);

    void deleteByItemRequestDetailsId(Long id);


}
