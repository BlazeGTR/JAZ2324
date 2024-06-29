package jaz_29101_nbp.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@Service
public class KolosService {
    ObjectMapper objectMapper = new ObjectMapper();

    private final RestTemplateConfig restTemplateConfig;
    private final QueryRepository queryRepository;
    public KolosService(RestTemplateConfig restTemplateConfig, QueryRepository queryRepository){ this.restTemplateConfig = restTemplateConfig; this.queryRepository = queryRepository;}

    public double getAverage(String currency, String dateStartS, String dateEndS)
    {
        String nbpApiPath = "https://api.nbp.pl/api/exchangerates/rates/A/";
        nbpApiPath += currency +"/";
        nbpApiPath += dateStartS+"/";
        nbpApiPath += dateEndS+"/";
        String result = restTemplateConfig.restTemplate().getForObject(nbpApiPath,String.class);
        NbpResponseClass response = new NbpResponseClass();
        //Mapujemy wartości
        try {
            response = objectMapper.readValue(result, NbpResponseClass.class);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        //wyświetlamy wszystkie wartości z tables
        double avg = 0;
        for( int i = 0;response.getRates().length > i; i++ )
        {
            avg += response.getRates()[i].getMid();
        }
        avg /= response.getRates().length;
        System.out.println(avg);
        Query query = new Query(currency, LocalDate.parse(dateStartS),LocalDate.parse(dateEndS),avg);
        queryRepository.save(query);
        return avg;
    }
}
