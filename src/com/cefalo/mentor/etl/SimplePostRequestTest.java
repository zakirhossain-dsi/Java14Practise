/*
package com.cefalo.mentor.etl;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class SimplePostRequestTest {
    public static void main(String[] args) throws IOException {
        var jsonString = FileUtils.readFileToString(new File("src/image.json"), StandardCharsets.UTF_8);
        String url = "https://bucketeer-261d8467-41d2-4038-b4a7-0a3873b5d20c.s3.amazonaws.com/uploads/ac_image/image/21233/Kári_Stefánsson_på_kontoret.jpg";

        //String jsonString = "{\"type\":\"image\", \"version\":\"0.10.5\", \"additional_properties\":{\"originalUrl\":\""+ url +"\"}}";

        HttpEntity httpEntity = MultipartEntityBuilder
                .create()
                .addBinaryBody("ans", jsonString.getBytes(), ContentType.APPLICATION_JSON, "21233").build();

        var httpRequest = RequestBuilder.create("POST")
                .setUri("https://api.sandbox.mentormedier.arcpublishing.com/photo/api/v2/photos")
                .setHeader(HttpHeaders.AUTHORIZATION, "Bearer 820A6SHNKHPHP9V84UMROM19S9PO50H5LARBe47nE+l3tqkxQ38ScIaberBsIfOHtxW7+QSk")
                .setEntity(httpEntity)
                .build();

        var client = HttpClients.createDefault();

        try (client) {
            var response = client.execute(httpRequest);
            System.out.println(EntityUtils.toString(response.getEntity()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
