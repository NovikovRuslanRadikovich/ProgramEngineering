package ru.kpfu.itis.truckingservice.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseCreator {

    private final static String SUCCESS_RESULT = "Success";
    private final static String FAIL_RESULT = "Fail";

    protected <T> ResponseEntity<ApiResponse<T>> createGoodResponse(T body) {
        return createResponse(body, null, HttpStatus.OK);
    }

    protected <T> ResponseEntity<ApiResponse<T>> createGoodResponse() {
        return createGoodResponse((T) SUCCESS_RESULT);
    }

    protected <T> ResponseEntity<ApiResponse<T>> createBadResponse(String error) {
        return createResponse((T) FAIL_RESULT, error, HttpStatus.OK);
    }

    private <T> ResponseEntity<ApiResponse<T>> createResponse(T body, String error, HttpStatus status) {
        return new ResponseEntity<>(new ApiResponse<>(body, error), status);

    }
}
