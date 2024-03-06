package com.mykytaaa.user.profile.service.e2e.assertions;

import io.cucumber.datatable.DataTable;
import org.assertj.core.api.SoftAssertions;

public abstract class AbstractDtoAssertHandler<T> {

    /**
     * Asserts the equality of the actual response body with the expected response using SoftAssertions.
     *
     * @param dataTable       The DataTable containing the expected response data.
     * @param actualResponse  The actual response obtained from the system under test.
     */
    public void assertResponseBody(DataTable dataTable, T actualResponse) {
        final SoftAssertions softly = new SoftAssertions();

        assertActualResponse(dataTable, actualResponse, softly);

        softly.assertAll();
    }

    /**
     * Abstract method to be implemented by subclasses to assert the equality of actual response
     * with expected response using SoftAssertions.
     *
     * @param dataTable       The DataTable containing expected response data.
     * @param actualResponse  The actual response obtained from the system under test.
     * @param softly          SoftAssertions object for collecting assertion errors.
     */
    public abstract void assertActualResponse(DataTable dataTable, T actualResponse, SoftAssertions softly);
}
