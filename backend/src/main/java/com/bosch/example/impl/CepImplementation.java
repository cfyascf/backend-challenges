// package com.bosch.example.impl;

// import java.io.DataOutputStream;
// import java.io.IOException;
// import java.net.HttpURLConnection;
// import java.net.MalformedURLException;
// import java.net.URI;
// import java.net.URL;
// import java.net.http.HttpClient;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;
// import java.net.http.HttpResponse.BodyHandlers;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import com.bosch.example.services.CuritibaService;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// public class CepImplementation implements CuritibaService {

//     @Override
//     public Cep getCpfRequest(String cep) {
//         Cep request = getRequest(cep);
//         return request;
//     }

//     public Cep getRequest(String cep) throws InterruptedException, IOException{
//         HttpClient client = HttpClient.newHttpClient();
//         HttpRequest request = (HttpRequest) HttpRequest.newBuilder()
//                 .uri(URI.create("https://viacep.com.br/ws/" + cep +"/json/"))
//                 .build();
           
//        HttpResponse<String> response = client
//                 .send(request, BodyHandlers.ofString()); 

//         ObjectMapper mapper = new ObjectMapper();
//         JsonNode rootNode = mapper.readTree(response.body());

//         String cidade = rootNode.path("localidade").asText();

//         Boolean validCep = validateCep(cep);

//         ResponseEntity<String> httpResp;
//         if(validCep) {
//             httpResp = new ResponseEntity<>("CEP válido!", HttpStatus.OK);
//         } else {
//             httpResp = new ResponseEntity<>("CEP não válido!", HttpStatus.BAD_REQUEST);
//         }
    
//         Cep newCep = new Cep(cep, cidade, validCep, httpResp);

//         return newCep;
//     }

//     public Boolean validateCep(String cep) {
//         boolean result = false;
// 		if ( cep == null || "".equals(cep) ) {
// 			result = false;
// 		} else {
// 			Pattern pattern = Pattern.compile("^(([0-9]{2}\\.[0-9]{3}-[0-9]{3})|([0-9]{2}[0-9]{3}-[0-9]{3})|([0-9]{8}))$");  
// 			Matcher matcher = pattern.matcher(cep);
// 			result = matcher.find();
// 		}
// 		return result;
//     }
// }
