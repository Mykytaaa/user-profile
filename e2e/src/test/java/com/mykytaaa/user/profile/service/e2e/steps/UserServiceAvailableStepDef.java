package com.mykytaaa.user.profile.service.e2e.steps;

import com.fasterxml.jackson.databind.JsonNode;
import com.mykytaaa.user.profile.service.e2e.generated.api.ActuatorApi;
import com.mykytaaa.user.profile.service.e2e.util.JsonSerializationHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class UserServiceAvailableStepDef {

    /**
     * API interface for interacting with the Actuator endpoints.
     */
    private final ActuatorApi actuatorApi;

    /**
     * Helper class for JSON serialization tasks.
     */
    private final JsonSerializationHelper jsonHelper;

    /**
     * Checks if the User Profile Service is up and running by verifying its health status.
     * It asserts that the service status is "UP".
     */
    @Given("User Profile Service is up and running")
    public void upServiceIsUpAndRunning() {
        final var health = actuatorApi.health();
        final var actualStatus = jsonHelper.getObjectAsNode(health).get("status").asText();

        assertThat(actualStatus).isEqualTo("UP");
    }

    /**
     * Verifies the availability of a specific User Profile endpoint with the given URL and HTTP method.
     * It checks if the endpoint is listed among the service mappings.
     *
     * @param url The URL of the endpoint.
     * @param httpMethod The HTTP method used by the endpoint.
     */
    @And("User Profile endpoint {string} with http method {string} available")
    public void userEndpointAvailable(String url, String httpMethod) {
        final var mappings = actuatorApi.mappings();
        final var actualEndpoints = jsonHelper.getObjectAsNode(mappings)
                .get("contexts")
                .get("application")
                .get("mappings")
                .get("dispatcherHandlers")
                .get("webHandler")
                .findValues("predicate")
                .stream()
                .map(JsonNode::asText)
                .toList();

        final var expectedEndpoint = "{%s %s}".formatted(httpMethod.toUpperCase(), url.toLowerCase());

        assertThat(actualEndpoints).contains(expectedEndpoint);
    }
}
