package pl.jz.fchc.ws.endpoint;


import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.jaczaw.types.calculator.AdditionInput;
import pl.jaczaw.types.calculator.DivisionInput;
import pl.jaczaw.types.calculator.MultiplicationInput;
import pl.jaczaw.types.calculator.ObjectFactory;
import pl.jaczaw.types.calculator.Output;
import pl.jaczaw.types.calculator.SubtractionInput;


@Slf4j
@Endpoint
public class Calculator {


    @ResponsePayload
    @PayloadRoot(namespace = "http://jaczaw.pl/types/calculator", localPart = "AdditionInput")
    public Output addition(@RequestPayload AdditionInput input) {
        log.info(String.format("Request received for addition with input %s", input));
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() + input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://jaczaw.pl/types/calculator", localPart = "SubtractionInput")
    public Output subtraction(@RequestPayload SubtractionInput input) {
        log.info(String.format("Request received for addition with input %s", input));
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() - input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://jaczaw.pl/types/calculator", localPart = "MultiplicationInput")
    public Output multiplication(@RequestPayload MultiplicationInput input) {
        log.info("Request received for addition with input " + input);
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() * input.getNumber2());
        return output;
    }

    @ResponsePayload
    @PayloadRoot(namespace = "http://jaczaw.pl/types/calculator", localPart = "DivisionInput")
    public Output division(@RequestPayload DivisionInput input) {
        log.info("Request received for addition with input " + input);
        if (input.getNumber2() == 0) {
            throw new IllegalArgumentException("Divisor can't be null");
        }
        ObjectFactory objectFactory = new ObjectFactory();
        Output output = objectFactory.createOutput();
        output.setResult(input.getNumber1() / input.getNumber2());
        return output;
    }
}