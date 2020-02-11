package com.jpaHiberdemo;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateJpaApplication {

	public static void main(String[] args) throws IOException {
		String url = "http://localhost:8080/";
		SpringApplication.run(HibernateJpaApplication.class, args);
		openHomePage(url);
        
	}
	
	private static void openHomePage(String url) throws IOException {
            if(Desktop.isDesktopSupported()){
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI(url));
                } catch (IOException | URISyntaxException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else{
                Runtime runtime = Runtime.getRuntime();
                try {
                    runtime.exec("xdg-open " + url);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
	    }
}
