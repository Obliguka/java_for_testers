package ru.stqa.mantis.manager;

import okhttp3.OkHttpClient;

public class HttpSessionHelper extends HelperBase{


    public HttpSessionHelper(ApplicationManager manager) {
        super(manager);
    }
    OkHttpClient client;

}
