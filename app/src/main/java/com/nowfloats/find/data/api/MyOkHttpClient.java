package com.nowfloats.find.data.api;

import android.os.Build;

import com.nowfloats.find.app.Global;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;

/**
 * Created by chiranjitbardhan on 28/08/17.
 */

public class MyOkHttpClient
{
    public static OkHttpClient getOkHttpClient()
    {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                    .tlsVersions(TlsVersion.TLS_1_2)
                    .cipherSuites(
                            CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                            CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                            CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256)
                    .build();

            return new OkHttpClient.Builder()
                    .connectionSpecs(Collections.singletonList(spec))
                    .connectTimeout(Global.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(Global.READ_TIMEOUT, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .writeTimeout(Global.WRITE_TIMEOUT, TimeUnit.SECONDS).build();
        }

        return new OkHttpClient.Builder()
                .connectTimeout(Global.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Global.READ_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .writeTimeout(Global.WRITE_TIMEOUT, TimeUnit.SECONDS).build();
    }
}