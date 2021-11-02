package engineering.iterative.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/sum")
    public int sumNumbers(@RequestParam("argA") Integer argA,
                          @RequestParam("argB") Integer argB) {
        return argA + argB;
    }
}
