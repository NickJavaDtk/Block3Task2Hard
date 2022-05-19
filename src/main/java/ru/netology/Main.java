package ru.netology;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class Main {
    public static final String LINK
            = "https://api.nasa.gov/planetary/apod?api_key=E1NHfRQGXa0hC5rz3pnagmFJo6zQp0Ipxt5udkQR";
    public static ObjectMapper mapper = new ObjectMapper( );


    public static void main(String[] args) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create( )
                    .setDefaultRequestConfig(RequestConfig.custom( )
                            .setConnectTimeout(5000)
                            .setSocketTimeout(30000)
                            .setRedirectsEnabled(false)
                            .build( ))
                    .build( );
            HttpGet request = new HttpGet(LINK);
            request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType( ));
            CloseableHttpResponse response = httpClient.execute(request);
            String body = new String(response.getEntity( ).getContent( ).readAllBytes( ), StandardCharsets.UTF_8);
            ApiNasa nasa = mapper.readValue(body, ApiNasa.class);
            fileRecord(nasa.getUrl( ));
            httpClient.close();
            response.close();

        } catch (IOException e) {
            e.printStackTrace( );
        }
    }

    public static void fileRecord(String url) {
        try (InputStream in = new URL(url).openStream( );
             FileOutputStream fos = new FileOutputStream("output.jpg")) {
            byte[] b = in.readAllBytes( );
            fos.write(b);
        } catch (IOException e) {
            e.printStackTrace( );
        }

    }
}
