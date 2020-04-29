package com.redhat.developers;

import com.redhat.developers.model.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RefreshScope
@RestController
@Slf4j
public class GreeterController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${external-api.ms-product.url}")
    private String productApiUrl;

    @Value("${greeter.message}")
    private String greeterMessageFormat;

    @Value("${greeter.message2}")
    private String greeterMessageFormat2;

    @GetMapping("/greet/{user}")
    public String greet(@PathVariable("user") String user) {
        String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");
        log.info("Prefix :{} and User:{}", prefix, user);
        if (prefix == null) {
            prefix = "Hello!";
        }

        return String.format(greeterMessageFormat, prefix, user) + " | " + this.greeterMessageFormat2;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> products() throws Exception {


       return  restTemplate.exchange(RequestEntity
            .get(new URI(this.productApiUrl + "/products"))
            .build(),
           new ParameterizedTypeReference<List<Product>>(){});
    }

}
