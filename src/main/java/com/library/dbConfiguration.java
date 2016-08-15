package com.library;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

/**
 * Created by Attila on 15/08/2016.
 */
public class dbConfiguration {

    public HashMap<String,String> setUrlForDataSource() {
        HashMap<String,String> myUrl = new HashMap<String,String>();
        try {
            URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
            myUrl.put("username", dbUri.getUserInfo().split(":")[0]);
            myUrl.put("password", dbUri.getUserInfo().split(":")[1]);
            myUrl.put("dbUrl", "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath());
            return myUrl;
        } catch(URISyntaxException e) {
            System.err.println("Unable to create host URI");
            e.printStackTrace();
            return null;
        }
    }

    //    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setPassword(setUrlForDataSource().get("password"));
        dataSource.setUrl(setUrlForDataSource().get("dbUrl"));
        dataSource.setUsername(setUrlForDataSource().get("username"));
        return dataSource;
    }
}
