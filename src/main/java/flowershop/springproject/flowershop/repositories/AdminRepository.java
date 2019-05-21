package flowershop.springproject.flowershop.repositories;

import flowershop.springproject.flowershop.models.Admin;
import flowershop.springproject.flowershop.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface AdminRepository extends CrudRepository<Admin, Long> {

    Admin findByEmailAndPassword(String email, String password);


}
