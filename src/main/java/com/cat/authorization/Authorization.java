package com.cat.authorization;

import com.cat.model.Person;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Authorization {
    private HttpClient httpClient = HttpClientBuilder.create().build();
    private final String URL_PAGE = "http://client-api.instaforex.com/" +
            "api/" +
            "Authentication/" +
            "RequestMoblieCabinetApiToken";
    private final String PERSON_LOGIN = "20234561";
    private final String PERSON_PASSWORD = "ladevi31";
    private final Person PERSON = new Person(PERSON_LOGIN, PERSON_PASSWORD);

    private String createJSON() {
        Gson gson = new Gson();
        String json = gson.toJson(PERSON);
        return json;
    }

    public String doAuthorization() throws IOException {
        HttpPost request = new HttpPost(URL_PAGE);
        String json = createJSON();
        System.out.println(json);
        StringEntity body = new StringEntity(json);
        request.setEntity(body);
        request.setHeader("Accept", "/application/json");
        request.setHeader("Content-Type", "application/json");
        HttpResponse httpResponse = httpClient.execute(request);
        HttpEntity httpEntity = httpResponse.getEntity();
        String token = getToken(httpEntity);
        System.out.println(token);
        return token;
    }

    private String getToken(HttpEntity httpEntity) throws IOException {
        StringBuilder tokenString = new StringBuilder();
        if (httpEntity != null) {
            tokenString.append(EntityUtils.toString(httpEntity));
        }
        String token = tokenString.toString();
        return token;
    }
}
