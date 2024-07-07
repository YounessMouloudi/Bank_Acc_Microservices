package com.projects.account_service.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {

    /* @Value c'est pour injecter une parametre de config dans une variable => ay hna ghanakhdo l value li f
    global.params.p1 w n7atoha f variable p1 */
    @Value("${global.params.p1}")
    private int p1;

    @Value("${global.params.p2}")
    private int p2;

    @Value("${account.params.a}")
    private int a;

    @Value("${account.params.b}")
    private int b;

    @GetMapping("/testConfig")
    public Map<String,Integer> configTest() {
        return Map.of("p1",p1,"p2",p2,"a",a,"b",b);
    }
}
