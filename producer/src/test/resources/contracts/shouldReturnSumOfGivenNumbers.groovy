package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return sum of given numbers"
    request {
        method GET()
        url("/sum") {
            queryParameters {
                parameter("number1", "2")
                parameter("number2", "3")
            }
        }
    }
    response {
        body("5")
        status 200
    }
}