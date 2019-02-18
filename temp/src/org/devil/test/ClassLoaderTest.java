package org.devil.test;

import org.devil.entity.Devil;

public class ClassLoaderTest {

    public static void main(String[] args) {
        String str = new String();
        System.out.println(str.getClass().getClassLoader());

        Devil devil = new Devil();
        System.out.println(devil.getClass().getClassLoader());
    }

}
