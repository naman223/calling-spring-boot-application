package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@RestController(value = "/")
public class HelloController {

    private String myName = "Test-Two";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    @ResponseBody
    public String getMapping() {
        return "Hello "+myName+" !!!";
    }

    @PostMapping("/{myName}")
    @ResponseBody
    public ResponseEntity<?> storeMapping(@PathVariable("myName") String myName) {
        this.myName = myName;
        return ResponseEntity.ok("Your name is Stored: "+myName);
    }

    @RequestMapping("/callone")
    @ResponseBody
    public ResponseEntity<?> callOne(HttpServletRequest httpServletRequest) {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringBuffer currentUrl = httpServletRequest.getRequestURL();
        String newUrl = currentUrl.substring(0,currentUrl.lastIndexOf(":")+1).toString();

        StringBuilder url = new StringBuilder().
                append(newUrl).append("8082/emp/1");
        String result = restTemplate.getForObject(url.toString(), String.class);
        return ResponseEntity.ok("Emp details Stored in Service One: "+result);
    }

    @RequestMapping("/callall")
    @ResponseBody
    public ResponseEntity<?> callAll(HttpServletRequest httpServletRequest) {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringBuffer currentUrl = httpServletRequest.getRequestURL();
        String newUrl = currentUrl.substring(0,currentUrl.lastIndexOf(":")+1).toString();

        StringBuilder url = new StringBuilder().
                append(newUrl).append("8082/emps");
        String result = restTemplate.getForObject(url.toString(), String.class);
        return ResponseEntity.ok("Emp details Stored in Service One: "+result);
    }

}
