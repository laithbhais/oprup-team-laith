package net.oprup.erp.repo;

import net.oprup.erp.model.ItemRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ItemRequestRepo extends JpaRepository<ItemRequest, Long> {
    Optional<ItemRequest> findItemRequestByitemRequestId(Long itemRequestId);

    @Query("select e from ItemRequest e where e.deleteFlag =1")
    List<ItemRequest> deleteItemRequestByDeleteFlag();

    @Query(value ="select count(item_request_id) from item_request",nativeQuery = true)
    long countItemRequestByItemRequestId();



}
