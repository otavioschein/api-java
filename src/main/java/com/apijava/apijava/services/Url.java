package com.apijava.apijava.services;

import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Url {

    public static String decodeParam(String name) {
        try {
            return URLDecoder.decode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
