package com.example.demo.service;

import com.example.demo.model.MarksConverter;
import com.example.demo.model.Student;
import com.example.demo.model.VariableInstanceDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.HashMap;

@Service
public class PamService {

    public MarksConverter getMarks(Student student) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        //setting headers start
        HttpHeaders headers = new HttpHeaders();

        String x  = HttpHeaders.encodeBasicAuth("rhpamAdmin","Codezero88*", Charset.defaultCharset());

        System.out.println(x);

        headers.set("Authorization","Basic " + x);
        //setting headers end

        String url = "http://localhost:8080/kie-server/services/rest/server/containers/marksproject_1.0.0-SNAPSHOT/processes/marksproject.marksproj/instances";

        HttpEntity<Student> httpEntity = new HttpEntity<>(student,headers);
        String instanceId = restTemplate.postForObject(url,httpEntity,String.class);


        System.out.println("now in service class");
        System.out.println(student.getStudentName());
        System.out.println(student.getStudentId());

        String url2 = "http://localhost:8080/kie-server/services/rest/server/containers/marksproject_1.0.0-SNAPSHOT/processes/instances/"+instanceId+"/variables/instances/res";


        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<HashMap<Object,Object>> response;
        response = restTemplate.exchange(url2, HttpMethod.GET,requestEntity,new ParameterizedTypeReference<HashMap<Object,Object>>() {});


        ObjectMapper objectMapper = new ObjectMapper();




        System.out.println(response.getBody());

        VariableInstanceDto variableInstanceDto = objectMapper.convertValue(response.getBody(), VariableInstanceDto.class);

        System.out.println(variableInstanceDto.getVariableInstanceList().get(0).getValue());

        MarksConverter marksConverter = objectMapper.readValue(variableInstanceDto.getVariableInstanceList().get(0).getValue(), MarksConverter.class);

        System.out.println(marksConverter.getMarks());

        return marksConverter;
    }

}
