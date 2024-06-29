package jaz_29101_nbp.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.net.URL;
import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.util.Date;

@RestController
@JsonIgnoreProperties(ignoreUnknown = true)
@RequestMapping("/Kolos")
public class KolosController {

    private final KolosService kolosService;
    public KolosController(KolosService kolosService) {this.kolosService = kolosService;}


    @GetMapping("/{currency}/{dateStartS}/{dateEndS}")
    ResponseEntity<String> test(@PathVariable String currency, @PathVariable String dateStartS, @PathVariable String dateEndS)
    {
        String response = "avg: " + String.valueOf(kolosService.getAverage(currency, dateStartS,dateEndS));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
