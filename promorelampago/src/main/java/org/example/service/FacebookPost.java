package org.example.service;

import org.json.JSONObject;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FacebookPost {
    private static final String pageId = "101215879568509";
    private static final String accessToken = "EAARtcY1NhXgBAOSzar6X6WaOvQrW4nv6a5cvYDJWq4G89olrUq7PZAeWsixmTs1e2h4MYVrApz1r0bPgc4hksZCZBlr1VVjc0HLiJx8BZCWi0xnXiVdnZAhNgGZAe4847nXwXL50DyCNRZBmRQZCm7vozW7AZAnZA9L1CEHLtAt56QlvyHQRMStrrtWFN7QNvYMvfb5WRYYUbrXSX8ZA8wk81qJ7weO2VLXJBIZD";

    public static void postarOfertaShopee(String nomeProduto, String preco, String link, String vendas){
         //String mensagem = "Super Oferta!!\n"+nomeProduto+"\nValor: R$"+preco+"\nVendas na loja: "+vendas+"\n"+link+"\n"+link+"\n"+link;
        String mensagem = "⚠Super Oferta!!\nPromoção Verificada Shopee!\n"+nomeProduto+"\nValor: R$"+preco+"\nVendas na loja: "+vendas+"\n\n"+link;

        String mensagemcodificada = URLEncoder.encode(mensagem, StandardCharsets.UTF_8);
        String linkcodificado = URLEncoder.encode(link,StandardCharsets.UTF_8);
         try {


             // Criação do objeto JSON com a mensagem a ser postada
             JSONObject postObject = new JSONObject();
             postObject.put("message", mensagem);

             // Criação da URL da requisição
             String urlString = "https://graph.facebook.com/" + pageId + "/feed?message="+ mensagemcodificada+ "&link="+ link + "&access_token=" + accessToken;

             // Criação da conexão HTTP com o Facebook Graph API
             URL url = new URL(urlString);
             HttpURLConnection connection = connection = (HttpURLConnection) url.openConnection();;


             connection.setRequestMethod("POST");
             connection.setDoOutput(true);

             // Escrita do objeto JSON como payload da requisição
             String jsonInputString = postObject.toString();
             connection.getOutputStream().write(jsonInputString.getBytes("utf-8"));


             // Leitura da resposta do Facebook Graph API
             Scanner scanner = null;
             scanner = new Scanner(connection.getInputStream());
             String responseBody = scanner.useDelimiter("\\A").next();
             scanner.close();
             // Imprime a resposta do Facebook Graph API
             System.out.println("Resposta: " + responseBody);
         } catch (IOException e){
             e.printStackTrace();
         }
    }

        public static void postarOfertaMagalu(String nomeProduto, String precoAntigo, String link, String precoAtual, String precoDesconto) throws IOException {
        String linkCurto = CuttlyShortlink.gerarLink(link);
        String mensagem = "⚠Super Oferta!!\nLoja PARCEIRA MAGALU! \n"+nomeProduto+"\nValor Antigo: "+precoAntigo+"\nValor na Oferta: "+precoAtual+"\nParceladinho: "+precoDesconto+"\n\n"+linkCurto;
        String mensagemcodificada = URLEncoder.encode(mensagem, StandardCharsets.UTF_8);
        String linkcodificado = URLEncoder.encode(link,StandardCharsets.UTF_8);
        try {


            // Criação do objeto JSON com a mensagem a ser postada
            JSONObject postObject = new JSONObject();
            postObject.put("message", mensagem);

            // Criação da URL da requisição
            String urlString = "https://graph.facebook.com/" + pageId + "/feed?message="+ mensagemcodificada+ "&link="+ link + "&access_token=" + accessToken;

            // Criação da conexão HTTP com o Facebook Graph API
            URL url = new URL(urlString);
            HttpURLConnection connection = connection = (HttpURLConnection) url.openConnection();;


            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // Escrita do objeto JSON como payload da requisição
            String jsonInputString = postObject.toString();
            connection.getOutputStream().write(jsonInputString.getBytes("utf-8"));


            // Leitura da resposta do Facebook Graph API
            Scanner scanner = null;
            scanner = new Scanner(connection.getInputStream());
            String responseBody = scanner.useDelimiter("\\A").next();
            scanner.close();
            // Imprime a resposta do Facebook Graph API
            System.out.println("Resposta: " + responseBody);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
