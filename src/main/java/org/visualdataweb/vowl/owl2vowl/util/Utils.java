package org.visualdataweb.vowl.owl2vowl.util;

import java.io.InputStream;

/**
 * Created by snadal on 17/05/16.
 */
public class Utils {
    public static InputStream getResourceAsStream(String filename) {
        InputStream in = Utils.class.getClassLoader().getResourceAsStream(filename);
        return in;
    }
}
