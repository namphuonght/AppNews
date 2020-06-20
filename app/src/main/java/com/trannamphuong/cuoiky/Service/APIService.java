package com.trannamphuong.cuoiky.Service;

public class APIService {
    private static String base_url = "http://192.168.1.3:8000/";

    public static DataSrevice getService(){
        return APIRetrofi.getClient(base_url).create(DataSrevice.class);

    }
}
