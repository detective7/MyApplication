// IMyAidlInterface.aidl
package com.example.myapplication.aidl;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    int puls(int a,int b);
    String toUpperCase(String str);
}
