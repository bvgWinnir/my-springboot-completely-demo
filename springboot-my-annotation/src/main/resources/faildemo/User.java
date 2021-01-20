package com.bvgol.examples.myAnnotation;

import javax.validation.constraints.NotNull;

public class User {

    private String idempotentNo;

    @NotNull(

            message = "userName can't be null"

    )

    private String userName;

}
