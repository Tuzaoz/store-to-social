package org.example;

import org.example.entities.Oferta;
import org.example.service.FacebookPost;
import org.example.service.ShopeeOfferRequest;

public class Main {
    public static void main(String[] args) throws Exception {


        ShopeeOfferRequest shopeeOfferRequest = new ShopeeOfferRequest();
        shopeeOfferRequest.Post();
        System.out.println(shopeeOfferRequest.getOfertas());
        for (Oferta oferta:shopeeOfferRequest.getOfertas()
             ) {
            FacebookPost.postarOferta(oferta.getProductName(), oferta.getPrice(), oferta.getOfferLink(), Integer.toString(oferta.getSales()));
        }

    }
}