package engineering.iterative.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/sum")
    public int sumNumbers(@RequestParam("number1") Integer n1,
                          @RequestParam("number2") Integer n2) {
        return n1 + n2;
    }
}
