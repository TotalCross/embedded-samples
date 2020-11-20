package com.totalcross.knowcode.communication;

import totalcross.io.ByteArrayStream;
import totalcross.io.IOException;
import totalcross.net.HttpStream;
import totalcross.net.URI;
import totalcross.net.UnknownHostException;
import totalcross.net.ssl.SSLSocketFactory;

/**
 * This is a implementation of HttpStream, with personalized default options.
 */
public abstract class HTTPConnection {

    private HTTPConnection() {

    }

    /**
     * Does delete request in uri.
     * 
     * @param uri
     * @throws Exception
     */
    public final static void doDelete(final URI uri) throws Exception {
        /*
         * Setting basic HTTP options
         */
        final HttpStream.Options options = buildOptions();
        options.httpType = HttpStream.DELETE;
        /**/

        /*
         * Performing delete
         */
        try (final HttpStream hs = new HttpStream(uri, options)) {
            if (!hs.isOk()) {
                throw new Exception("Connection Error! HTTP Code: " + hs.responseCode);
            }
        }
    }

    /**
     * Does get request in uri
     * 
     * @param uri
     * @return
     * @throws UnknownHostException
     * @throws IOException
     */
    public final static String doGet(final URI uri) throws UnknownHostException, IOException {
        String response = null;

        /*
         * Setting basic HTTP options
         */
        final HttpStream.Options options = buildOptions();
        options.httpType = HttpStream.GET;
        /**/

        /*
         * Performing get
         */
        try (HttpStream hs = new HttpStream(uri, options); ByteArrayStream bas = new ByteArrayStream(4096)) {
            bas.readFully(hs, 10, 4096);
            response = new String(bas.getBuffer(), 0, bas.available());
        }
        /**/

        return response;
    }

    /**
     * This method set's a set of default HTTP options.
     * 
     * @return
     */
    private static HttpStream.Options buildOptions() {
        final HttpStream.Options options = new HttpStream.Options();
        options.readTimeOut = 15000;
        options.socketFactory = new SSLSocketFactory(); // This is very important because Firebase uses HTTPS
        options.writeTimeOut = 15000;
        options.openTimeOut = 5000;
        options.writeBytesSize = 4096;
        options.setContentType("application/json; charset=UTF-8");
        options.setCharsetEncoding("UTF-8");

        return options;
    }
}