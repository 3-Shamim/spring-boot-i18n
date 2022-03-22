package com.learningstuff.springbooti18n.controllers;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Email: mdshamim723@gmail.com
 * Date: ২২/৩/২২
 * Time: ১২:২১ PM
 * To change this template use File | Settings | File and Code Templates.
 */

@AllArgsConstructor
@RequestMapping(value = "/hello")
@RestController
public class HelloController {

    private final MessageSource messageSource;

    @GetMapping(value = "/1")
    public String getLangError1(Locale locale) {

        System.out.println(locale);

        return messageSource.getMessage("error.notfound", null, locale);
    }

    @GetMapping(value = "/2")
    public String getLangError(@RequestHeader(value = "accept-language", defaultValue = "en") Locale locale) {

        System.out.println(locale);

        return messageSource.getMessage("error.notfound", null, locale);
    }

    @GetMapping(value = "/3")
    public String getLangError2(@RequestParam(value = "locale", defaultValue = "en") Locale locale) {
        return messageSource.getMessage("error.notfound", null, locale);
    }

}
