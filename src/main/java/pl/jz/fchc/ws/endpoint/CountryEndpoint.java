package pl.jz.fchc.ws.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.jz.fchc.kraj.web_service.Country;
import pl.jz.fchc.kraj.web_service.GetCountryRequest;
import pl.jz.fchc.kraj.web_service.GetCountryResponse;

@Slf4j
@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://fchc.jz.pl/kraj/web-service";

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        Country country = countryRepository.findCountry(request.getName());
        response.setCountry(country);
        log.info("Wywolanie uslugi: {} ; {},{},{}", request.getName(), country.getName(), country.getCapital(), country.getPopulation());

        return response;
    }
}
