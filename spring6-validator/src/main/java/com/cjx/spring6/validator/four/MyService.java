package com.cjx.spring6.validator.four;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class MyService {

    public String testMethod(@NotNull @Valid User user){
        return user.toString();
    }
}
