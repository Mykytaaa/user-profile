package com.mykytaaa.user.profile.service.e2e.assertions;

import io.cucumber.datatable.DataTable;
import org.assertj.core.api.SoftAssertions;

public abstract class DtoAssertHandler<T> {

    public void assertResponseBody(DataTable dataTable, T actualResponse) {
        SoftAssertions softly = new SoftAssertions();

        assertActualResponse(dataTable, actualResponse, softly);

        softly.assertAll();
    }

    public abstract void assertActualResponse(DataTable dataTable, T actualResponse, SoftAssertions softly);
}
