package org.example.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import org.example.entities.OfertaShopee;
import org.json.JSONObject;


import java.security.MessageDigest;
import java.util.List;


public class ShopeeOfferRequest {
    private List<OfertaShopee> ofertaShopees;

    public List<OfertaShopee> getOfertas() {
        return ofertaShopees;
    }

    public void setOfertas(List<OfertaShopee> ofertaShopees) {
        this.ofertaShopees = ofertaShopees;
    }

    public void Post() throws Exception {
        long timestamp = System.currentTimeMillis() / 1000L;
        System.out.println("Timestamp: " + timestamp);

        String appid = "18300350121";
        String senha = "CVK7T3ZHOJSYHHPGEVVPCMDVDSKZCH4R";

        String parse = "{  productOfferV2(listType: 1, limit: 3) {    nodes {      productName      price      offerLink      periodEndTime      sales          }  }}";
        JSONObject response = new JSONObject();
        response.put("query", parse);

        String requestBody = response.toString();

        System.out.println("Request Body: " + requestBody);

        String endpoint = "https://open-api.affiliate.shopee.com.br/graphql";

        String signature = appid + timestamp + requestBody + senha;

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(signature.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        String sha256 = hexString.toString();
        System.out.println("SHA-256 Hash: " + sha256);

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(requestBody, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(endpoint)
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("Authorization", "SHA256 Credential=" + appid + ", Timestamp=" + timestamp + ", Signature=" + sha256)
                .build();

        Response apiResponse = client.newCall(request).execute();
        //System.out.println("Response: " + apiResponse.body().string());

        JSONObject jsonResponse = new JSONObject(apiResponse.body().string());
        JSONObject data = jsonResponse.getJSONObject("data");
        JSONObject productOfferV2 = data.getJSONObject("productOfferV2");
        List<OfertaShopee> products = new ObjectMapper().readValue(productOfferV2.getJSONArray("nodes").toString(), new TypeReference<List<OfertaShopee>>() {});
        setOfertas(products);
    }
}