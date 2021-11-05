package pl.jz.fchc.ws.endpoint;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.jz.fchc.kraj.web_service.Country;
import pl.jz.fchc.kraj.web_service.GetCountryRequest;
import pl.jz.fchc.kraj.web_service.GetCountryResponse;
import pl.jz.fchc.kraj.web_service.SetCountryRequest;
import pl.jz.fchc.kraj.web_service.SetCountryResponse;

@Slf4j
@Endpoint
@AllArgsConstructor
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://fchc.jz.pl/kraj/web-service";

    private final CountryRepository countryRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        Country country = countryRepository.findCountry(request.getName());
        response.setCountry(country);
        log.info("Wywolanie uslugi: {} ; {},{},{}", request.getName(), country.getName(), country.getCapital(), country.getPopulation());

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "setCountryRequest")
    @ResponsePayload
    public SetCountryResponse setCountry(@RequestPayload SetCountryRequest request) {
        SetCountryResponse response = new SetCountryResponse();
        String nazwa = countryRepository.addCountry(request.getCountry());
        response.setName(nazwa);
        log.info("Wywolanie uslugi: setCountryRequest {},{}, {}", request.getCountry().getName(), request.getCountry().getCapital(), nazwa);

        return response;
    }
}
