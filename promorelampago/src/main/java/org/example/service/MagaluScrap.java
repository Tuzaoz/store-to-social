package org.example.service;

import org.example.entities.OfertaMagalu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class MagaluScrap {
    List<OfertaMagalu> ofertaMagalus;

    public List<OfertaMagalu> getOfertaMagalus() {
        return ofertaMagalus;
    }

    public void setOfertaMagalus(List<OfertaMagalu> ofertaMagalus) {
        this.ofertaMagalus = ofertaMagalus;
    }

    public void acharProdutos() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/org/example/utils/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.magazineluiza.com.br/selecao/ofertasdodia/?page=1&sortOrientation=desc&sortType=soldQuantity");
            WebElement listaDeProdutos = driver.findElement(By.cssSelector("div[data-testid='product-list']"));
            List<WebElement> produtos = listaDeProdutos.findElements(By.tagName("li"));
            List<String> nomeProdutos = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                WebElement produto = produtos.get(i);
                WebElement nomeDoProd = produto.findElement(By.tagName("h2"));
                String nomeDoProduto = nomeDoProd.getText();
                nomeProdutos.add(nomeDoProduto);
            }
            System.out.println(nomeProdutos);

            List<OfertaMagalu> ofertaMagaluList = new ArrayList<>();


            for (String nomeproduto:nomeProdutos
                 ) {
                driver.get("https://www.magazinevoce.com.br/magazinepromo0dia/");
                Thread.sleep(3000);
                WebElement pagina = driver.findElement(By.tagName("html"));
                pagina.click();
                WebElement pesquisa = driver.findElement(By.name("q"));
                pesquisa.sendKeys(nomeproduto);
                WebElement botaopesquisa = driver.findElement(By.className("i-magnifying"));
                botaopesquisa.click();
                Thread.sleep(5000);
                WebElement listaDeProdutosContainer = driver.findElement(By.tagName("ol"));
                List<WebElement> listadeprodutos = listaDeProdutosContainer.findElements(By.tagName("li"));
                WebElement linkProduto =listadeprodutos.get(0).findElement(By.tagName("a"));
                linkProduto.click();
                Thread.sleep(5000);
                String linkAfiliadoProduto =  driver.getCurrentUrl();
                WebElement precoAntigoContainer = driver.findElement(By.className("p-through"));
                String precoAntigo = precoAntigoContainer.getText();
                WebElement precoAtualContainer = driver.findElement(By.className("p-price"));
                String precoAtual = precoAtualContainer.getText();
                WebElement parcelaContainer = driver.findElement(By.className("p-installment"));
                String parcela = parcelaContainer.getText();
                OfertaMagalu ofertaMagalu = new OfertaMagalu(nomeproduto, linkAfiliadoProduto, precoAntigo, precoAtual, parcela);
                System.out.println(ofertaMagalu);
                ofertaMagaluList.add(ofertaMagalu);

            }
            setOfertaMagalus(ofertaMagaluList);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}
