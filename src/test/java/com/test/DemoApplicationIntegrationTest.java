package com.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoApplicationIntegrationTest {

    private RestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void get() {
        String result = restTemplate.getForObject("http://localhost:" + port + "/", String.class);
        assertThat(result).isEqualTo("Hello Test-Two !!!");
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
    }

    @Test
    public void post() {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("myName", "Naman");
        restTemplate.postForEntity("http://localhost:" + port + "/{myName}",null, null,vars);

        String result = restTemplate.getForObject("http://localhost:" + port + "/", String.class);
        assertThat(result).isEqualTo("Hello Naman !!!");
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
    }

}
