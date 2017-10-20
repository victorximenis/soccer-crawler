package com.victor.soccer_crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    		Document doc = Jsoup.connect("http://globoesporte.globo.com/futebol/brasileirao-serie-a").get();
    		Elements elements = doc.getElementsByClass("lista-de-jogos-item");
    		
    		for (int i = 0; i < elements.size(); i++) {
    			Element elem = elements.get(i);
    			
    			Element mandante = elem.getElementsByClass("placar-jogo-equipes-mandante").get(0)
    								.getElementsByClass("placar-jogo-equipes-nome").get(0);
    			
    			Element visitante = elem.getElementsByClass("placar-jogo-equipes-visitante").get(0)
    								.getElementsByClass("placar-jogo-equipes-nome").get(0);
    			
    			Element resultado = elem.getElementsByClass("placar-jogo-equipes-placar").get(0);
    			
    			Element placarMandante = resultado.getElementsByClass("placar-jogo-equipes-placar-mandante").get(0);
    			Element placarVisitante = resultado.getElementsByClass("placar-jogo-equipes-placar-visitante").get(0);
    			
    			System.out.println(mandante.text() + " " + placarMandante.text() + " x " + placarVisitante.text() + " " + visitante.text());
    		}
    		
    }
}
