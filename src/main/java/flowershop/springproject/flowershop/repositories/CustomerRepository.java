package flowershop.springproject.flowershop.repositories;

import flowershop.springproject.flowershop.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByEmailAndPassword(String email, String password);
<<<<<<< HEAD

}
=======
}
>>>>>>> a2bce46ecb9c5adc74b68acad6a8ae7b38d2431e
