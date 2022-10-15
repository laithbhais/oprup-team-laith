package net.oprup.erp.service;

import net.oprup.erp.model.Employee;
import net.oprup.erp.model.Address;
import net.oprup.erp.repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressService {

    private  AddressRepo addressRepo;

    @Autowired
    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    public Address addAddress(Address address){
        address.setDeleteFlag(1);
        // return addressRepo.save(address);
        return addressRepo.save(address);
    }

    public List<Address> findAllAddress(){
        return addressRepo.findAddressByDeleteFlag();
    }

    public Address updateAddress(Address address){
        address.setDeleteFlag(1);
        return addressRepo.save(address);
    }

    public List<Address> getAddressByEmployeeId(Employee employee){
        return addressRepo.findAddressByEmployeeId(employee);
    }


    public  Address deleteAddress(Address address){
        address.setDeleteFlag(0);
        return addressRepo.save(address);
    }

}
