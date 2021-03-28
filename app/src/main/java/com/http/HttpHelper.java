package com.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;


/**
 *
 */
public class HttpHelper {
    private static final String TAG = "HttpHelper";
    public static final int DEFAULT_CONN_TIME_OUT = 1000 * 30;
    // use for common http connection
    public static final int DEFAULT_SOCKET_TIME_OUT = 1000 * 30;
    public static HttpURLConnection getHttpURLConnectionWithProxy(String url) {
        try {
            URL mUrl = new URL(url);
            return (HttpURLConnection) mUrl.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] compress(byte[] data) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        OutputStream zipper = new GZIPOutputStream(bos);
        zipper.write(data);
        zipper.close();
        byte[] zip = bos.toByteArray();
        bos.close();
        return zip;
    }

    public static String httpString(String url, Map<String, String> header, boolean isPost, String bodyStrng) {
        byte[] body = null;
        if (null != bodyStrng) {
            try {
                body = bodyStrng.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                body = bodyStrng.getBytes();
            }
        }
        HttpURLConnection httpURLConnection = HttpHelper.getHttpURLConnectionWithProxy(url);
        httpURLConnection.setConnectTimeout(HttpHelper.DEFAULT_CONN_TIME_OUT);
        httpURLConnection.setReadTimeout(HttpHelper.DEFAULT_SOCKET_TIME_OUT);
        InputStream inputStream = null;
        try {
            if (isPost) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        if (header != null && header.size() > 0) {
            Iterator<Map.Entry<String, String>> iterator = header.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> next = iterator.next();
                httpURLConnection.setRequestProperty(next.getKey(), next.getValue());
            }
        }
        try {
            if (body != null) {
                OutputStream out = httpURLConnection.getOutputStream();
                out.write(body);
                out.flush();
                out.close();
            }
            int statusCode = httpURLConnection.getResponseCode();
//            Logger.d(TAG, "response code:" + statusCode);
            if (statusCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, len);
                }
                String s = new String(outStream.toByteArray());
//                Logger.d(TAG, "response s:" + s);
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return "";
    }
}
