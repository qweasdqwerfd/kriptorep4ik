package com.example.kriptorep4ik.logic;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JsoupParser {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();                   //фоновый поток

    public void init() {
        executor.execute(this::getWeb);                                                             //"вызови метод getWeb() в фоновом потоке"
    }

    private void getWeb() {
        try {
            Document doc = Jsoup.connect("https://www.cbr.ru/currency_base/daily/").get();
            Elements tables = doc.getElementsByTag("tbody");
            Element our_table = tables.get(0);
            Elements elements_from_table = our_table.children();
            Element AUD = elements_from_table.get(1);

            Log.d("MyLog", "Tbody size: " + AUD.text());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
