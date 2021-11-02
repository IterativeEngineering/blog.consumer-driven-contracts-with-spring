package engineering.iterative.consumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class CalculationController {

    private final RestTemplate restTemplate;

    @GetMapping("/average")
    public Double averageOfTwoDigits(@RequestParam("argA") Integer argA, @RequestParam("argB") Integer argB) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8090/sum?argA=" + argA + "&argB=" + argB,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                String.class);

        double sumResult = Double.parseDouble(Objects.requireNonNull(responseEntity.getBody()));

        return sumResult/2.0;
    }
}
