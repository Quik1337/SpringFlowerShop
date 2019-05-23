package flowershop.springproject.flowershop.restcontrollers;

import flowershop.springproject.flowershop.models.Flower;
import flowershop.springproject.flowershop.services.FlowerService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/flower")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class FlowerRestController {

    private final FlowerService flowerService;

    public FlowerRestController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }


    @GetMapping("getAllFlowers")
    public @ResponseBody Set<Flower> getAllFlowers(){
        return flowerService.getAll();
    }

}
