package flowershop.springproject.flowershop.services;

import flowershop.springproject.flowershop.models.Flower;
import flowershop.springproject.flowershop.repositories.FlowerRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FlowerService implements CrudService<Flower> {

    private final FlowerRepository flowerRepository;

    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    @Override
    public Flower getById(Long id) {
        return flowerRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Flower> getAll() {
        Set<Flower> flowers = new HashSet<>();
        flowerRepository.findAll().forEach(flowers::add);
        return flowers;
    }

    @Override
    public Flower add(Flower object) {
        return flowerRepository.save(object);
    }
}
