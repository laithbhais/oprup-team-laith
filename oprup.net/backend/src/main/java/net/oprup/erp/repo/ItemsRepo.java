package net.oprup.erp.repo;


import net.oprup.erp.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface ItemsRepo extends JpaRepository<Items, Long> {


    Optional<Items> findItemsByitemsId(Long itemsId);

    @Query("select e from Items e where e.deleteFlag =1")
    List<Items> deleteItemsByDeleteFlag();

    @Query(value ="select count(items_id) from items",nativeQuery = true)
    long countItemsByItemsId();

}