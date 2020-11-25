package com.totalcross.knowcode.config;

/**
 * There are Firebase confs.
 */
public abstract class FirebaseConfig {

    private FirebaseConfig() {

    }

    /**
     * Firebase Realtime Database Secret Key.
     */
    private static final String FIREBASE_AUTH_KEY = "9xev12w1d3uGdsBiVjwXQkUov3WfJh7lojO96MB0";

    /**
     * Firebase Realtime Database Commands document base URL.
     */
    public static final String COMMANDS_FIREBASE_URL = "https://webinarhomeappliance.firebaseio.com/databases/(default)/documents/commands.json?auth="
            + FIREBASE_AUTH_KEY;

}