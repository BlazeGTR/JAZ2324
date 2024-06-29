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
    private final RestTemplateConfig restTemplateConfig;
    public KolosController(KolosService kolosService,  RestTemplateConfig restTemplateConfig) {this.kolosService = kolosService; this.restTemplateConfig = restTemplateConfig;}
    ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping("/{currency}/{dateStartS}/{dateEndS}")
    ResponseEntity<String> test(@PathVariable String currency, @PathVariable String dateStartS, @PathVariable String dateEndS)
    {
        String nbpApiPath = "https://api.nbp.pl/api/exchangerates/rates/A/";
        nbpApiPath += currency +"/";
        nbpApiPath += dateStartS+"/";
        nbpApiPath += dateEndS+"/";
        String result = restTemplateConfig.restTemplate().getForObject(nbpApiPath,String.class);
        NbpResponseClass response = new NbpResponseClass();
        try {
            response = objectMapper.readValue(result, NbpResponseClass.class);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println(response.getRates().length);
        for( int i = 0;response.getRates().length > i; i++ )
        {
            System.out.println(response);
        }


        LocalDate dateStart = LocalDate.parse(dateStartS);
        LocalDate dateEnd = LocalDate.parse(dateEndS);
        return new ResponseEntity<>("true", HttpStatus.OK);
    }
}
