package org.example;

import org.example.entities.OfertaShopee;
import org.example.service.CuttlyShortlink;
import org.example.service.FacebookPost;
import org.example.service.MagaluScrap;
import org.example.service.ShopeeOfferRequest;

public class Main {
    public static void main(String[] args) throws Exception {

        MagaluScrap magaluScrap = new MagaluScrap();
        magaluScrap.acharProdutos();
        ShopeeOfferRequest shopeeOfferRequest = new ShopeeOfferRequest();
        shopeeOfferRequest.Post();
        System.out.println(shopeeOfferRequest.getOfertas());
        for (int i = 0; i < (magaluScrap.getOfertaMagalus().size()+shopeeOfferRequest.getOfertas().size()); i++) {
            FacebookPost.postarOfertaShopee(shopeeOfferRequest.getOfertas().get(i).getProductName(),
                    shopeeOfferRequest.getOfertas().get(i).getPrice(),
                    shopeeOfferRequest.getOfertas().get(i).getOfferLink(),
                    Integer.toString(shopeeOfferRequest.getOfertas().get(i).getSales())
                    );
            FacebookPost.postarOfertaMagalu(magaluScrap.getOfertaMagalus().get(0).getNome(),
                    magaluScrap.getOfertaMagalus().get(0).getPrecoAntigo(),
                    magaluScrap.getOfertaMagalus().get(0).getLink(),
                    magaluScrap.getOfertaMagalus().get(0).getPrecoAtual(),
                    magaluScrap.getOfertaMagalus().get(0).getParcela()
                    );
        }


    }
}