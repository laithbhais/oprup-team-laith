package net.oprup.erp.repo;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AddressRepo extends JpaRepository<Address, Long> {


    @Query(value = "select * from address as e where e.delete_flag =1 and e.employee_id =:employee_id",nativeQuery = true)
    List<Address> findAddressByEmployeeId(@Param("employee_id") Employee employee);




//    void deleteAddressByAddressId(Long id);

    @Query("select e from Address e where e.deleteFlag =1")
    List<Address> findAddressByDeleteFlag();

}
