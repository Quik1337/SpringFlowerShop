package flowershop.springproject.flowershop.repositories;

import flowershop.springproject.flowershop.models.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {

    Admin findByEmailAndPassword(String email, String password);
}