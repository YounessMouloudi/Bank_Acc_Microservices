package com.projects.customer_service.web;

import com.projects.customer_service.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {

    /* hadchi li drna hna db c'est une solution li mzna mais c'est pas la bonne solution hit ila kano 3ndna
    bzf d les parmas ghaykhassak kol mera tb9a tdir un variable ou t injecter liha sa value alors la bonne
    solution hia li ghandiroha f un package de config */
    @Value("${global.params.p1}")
    private int p1;

    @Value("${global.params.p2}")
    private int p2;

    @Value("${customer.params.x}")
    private int x;

    @Value("${customer.params.y}")
    private int y;

    @Autowired
    private GlobalConfig globalConfig;

    @GetMapping("/testConfig")
    public Map<String,Integer> configTest() {
        return Map.of("p1",p1,"p2",p2,"x",x,"y",y);
    };

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig() {
        return globalConfig;
    }
    /* hna aprés ma derna hadchi ghadi nchangiw f config repo ghadi nchangiw p1 et p2 aprés khass dir commit
    aprés ma drna commit db ghanchofo wach tchangaw les params donc ila dekhalna l config server ay
    f http://localhost:9999/customer-service/default ghadi nl9aw les params tchangaw mais ila dekhalna b
    http://localhost:8888/CUSTOMER-SERVICE/testConfig aw b http://localhost:8081/globalConfig ghanl9aw ga3
    matchanjaw => alors hna khassna ndiro un refresh l customer service w bach ndiroha b actuator ay ghadi
    nsefto request POST l http://localhost:8888/CUSTOMER-SERVICE/actuator/refresh aw l
    http://localhost:8081/actuator/refresh mais wakha hakak ila refrechiti ghadi tal9a matbadloch ay khassk
    tatredemaré sever donc hna khassk darori tzid wahd annotation @RefreshScope f controller bach yb9a
    ytrefresha une fois l9a chi changement db ila changiti w commitit w sefteti req POST une fois dir refresh
    ghadi tal9a bila tchanjaw
    */
}
