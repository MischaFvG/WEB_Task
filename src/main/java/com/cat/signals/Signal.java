package com.cat.signals;

import com.cat.authorization.Authorization;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Signal {
    private HttpClient httpClient = HttpClientBuilder.create().build();
    private Authorization authorization = new Authorization();
    private final String SIGNALS_URL = "http://client-api.instaforex.com/" +
            "clientmobile/" +
            "GetAnalyticSignals/" +
            "20234561?tradingsystem=3";
    private final String FIRST_UNIX_TIME = "1479860023";
    private final String SECOND_UNIX_TIME = "1480066860";

    public String doSignal(SignalsList firstSignal, SignalsList secondSignal) throws IOException {
        HttpGet httpGet = new HttpGet(SIGNALS_URL + "&pairs=" + firstSignal + "," + secondSignal +
                "&from=" + FIRST_UNIX_TIME +
                "&to=" + SECOND_UNIX_TIME);
        httpGet.addHeader("Passkey", authorization.doAuthorization());
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity resultEntity = httpResponse.getEntity();
        String result = getResponseResult(resultEntity);
        System.out.println(result);
        return result;
    }

    private String getResponseResult(HttpEntity httpEntity) throws IOException {
        StringBuilder resultString = new StringBuilder();
        if (httpEntity != null) {
            resultString.append(EntityUtils.toString(httpEntity));
        }
        String result = resultString.toString();
        return result;
    }
}
