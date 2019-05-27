package flowershop.springproject.flowershop.services;

import flowershop.springproject.flowershop.models.Flower;
import flowershop.springproject.flowershop.repositories.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FlowerService implements CrudService<Flower> {

    private final FlowerRepository flowerRepository;

    @Autowired
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

    public Set<Flower> getPremiumFlowers(){
        Set<Flower> flowers = new HashSet<>();
        flowerRepository.findAll().forEach(flowers::add);
        flowers.stream()
                .forEach(e -> e.setPrice(e.getPrice().multiply(new BigDecimal("0.90")).setScale(2, RoundingMode.CEILING)));
        return flowers;
    }

    @Override
    public Flower add(Flower object) {
        return flowerRepository.save(object);
    }
}