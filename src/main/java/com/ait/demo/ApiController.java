package com.ait.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by mhager on 07.01.17.
 */
@RestController
public class ApiController {

    private final Logger log = LoggerFactory.getLogger(ApiController.class);

    @RequestMapping(method = GET, path = "/ping", produces = "text/plain")
    public String ping() {
        return "ok";
    }

    @RequestMapping(method = GET, path = "/ping2", produces = "text/plain")
    public String ping2() {
        return "ok";
    }

}
