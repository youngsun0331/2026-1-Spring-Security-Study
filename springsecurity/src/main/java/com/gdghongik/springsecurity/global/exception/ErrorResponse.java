package com.gdghongik.springsecurity.global.exception;

import lombok.Getter;


public record ErrorResponse(
        String errorCodeName,
        String errorMessage
) { }
