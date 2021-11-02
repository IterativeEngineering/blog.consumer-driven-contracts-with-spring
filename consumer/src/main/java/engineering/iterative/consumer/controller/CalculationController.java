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
    public Double averageOfTwoDigits(@RequestParam("number1") Integer n1, @RequestParam("number2") Integer n2) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8090/sum?number1=" + n1 + "&number2=" + n2,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                String.class);

        double sumResult = Double.parseDouble(Objects.requireNonNull(responseEntity.getBody()));

        return sumResult/2.0;
    }
}
