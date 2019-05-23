package flowershop.springproject.flowershop.repositories;

import flowershop.springproject.flowershop.models.Flower;
import org.springframework.data.repository.CrudRepository;

public interface FlowerRepository extends CrudRepository<Flower, Long> {
}