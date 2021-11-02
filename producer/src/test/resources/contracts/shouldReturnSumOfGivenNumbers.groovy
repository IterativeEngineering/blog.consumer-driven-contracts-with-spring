package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return sum of argA and argB"
    request {
        method GET()
        url("/sum") {
            queryParameters {
                parameter("argA", "2")
                parameter("argB", "3")
            }
        }
    }
    response {
        body("5")
        status 200
    }
}