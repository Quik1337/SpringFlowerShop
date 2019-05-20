package flowershop.springproject.flowershop.repositories;

import flowershop.springproject.flowershop.models.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface AdminRepository extends CrudRepository<Admin, Long> {

    Admin getByFirstName(String firstName);

}
