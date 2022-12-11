package com.example.netflixclonebackend.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParserObj{


    public static  <T> T parseData(Object data, Class<T> obj) {
        ObjectMapper mapper = new ObjectMapper();
        T convertedData = null;
        try {
//            System.out.println(convertedData);
            byte[] dataToparse = mapper.writeValueAsBytes(data);
            convertedData = (T) mapper.readValue(dataToparse, obj);
            System.out.println(convertedData.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertedData;
    }
}
