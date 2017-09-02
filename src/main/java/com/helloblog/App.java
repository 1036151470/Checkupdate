package com.helloblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class App {
    public static ArrayList<String> str = new ArrayList<>();



    public static void main(String[] args) {
        str.add("http://www.iqiyi.com/a_19rrh96abl.html");
        str.add("http://www.iqiyi.com/a_19rrh8ethx.html");
        str.add("http://www.iqiyi.com/a_19rrgj9cow.html");

        SpringApplication.run(App.class, args);
    }
}
