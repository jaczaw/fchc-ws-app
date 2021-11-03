# fchc-ws-app

#### ********************************************************************
### 1. Na podstawie artykułu 
- Medium [Opublikuj usługę sieciową SOAP za pomocą Spring Boot](https://medium.com/swlh/publish-a-soap-web-service-with-spring-boot-b561a4142d81)
- Spring Guides [Tworzenie usługi internetowej SOAP](https://spring.io/guides/gs/producing-web-service/)
#### ********************************************************************

#### 1.  http://http://localhost:9091/ws/countries.wsdl
- Request

```dtd
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://fchc.jz.pl/kraj/web-service">
   <soapenv:Header/>
   <soapenv:Body>
      <web:getCountryRequest>
         <web:name>Poland</web:name>
      </web:getCountryRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
- Response
```dtd
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:getCountryResponse xmlns:ns2="http://fchc.jz.pl/kraj/web-service">
         <ns2:country>
            <ns2:name>Poland</ns2:name>
            <ns2:population>38186860</ns2:population>
            <ns2:capital>Warsaw</ns2:capital>
            <ns2:currency>PLN</ns2:currency>
         </ns2:country>
      </ns2:getCountryResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

#### 2.  http://localhost:9091/ws/calculatorDemo
- Request
```dtd
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:cal="http://jaczaw.pl/types/calculator">
    <soapenv:Header/>
    <soapenv:Body>
        <cal:AdditionInput>
            <cal:number1>3</cal:number1>
            <cal:number2>3</cal:number2>
        </cal:AdditionInput>
    </soapenv:Body>
</soapenv:Envelope>
```
- Response
```dtd
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:output xmlns:ns2="http://jaczaw.pl/types/calculator">
         <ns2:result>6</ns2:result>
      </ns2:output>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```
