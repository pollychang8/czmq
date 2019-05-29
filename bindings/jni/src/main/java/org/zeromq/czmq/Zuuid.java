/*
################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Read the zproject/README.md for information about making permanent changes. #
################################################################################
*/
package org.zeromq.czmq;

import java.util.stream.Stream;
import org.zeromq.tools.ZmqNativeLoader;

public class Zuuid implements AutoCloseable{
    static {
        Stream.of(
                "zmq",
                "uuid",
                "libsystemd",
                "lz4",
                "curl",
                "microhttpd",
                "czmq"
            )
            .forEach(lib -> {
                try {
                    ZmqNativeLoader.loadLibrary(lib);
                } catch (Exception e) {
                    System.err.println("[WARN] " + e.getMessage() +" from jar. Assuming it is installed on the system.");
                }
            });
        try {
            ZmqNativeLoader.loadLibrary("czmqjni");
        } catch (Exception e) {
            System.exit (-1);
        }
    }
    public long self;
    /*
    Create a new UUID object.
    */
    native static long __new ();
    public Zuuid () {
        /*  TODO: if __new fails, self is null...            */
        self = __new ();
    }
    public Zuuid (long pointer) {
        self = pointer;
    }
    /*
    Create UUID object from supplied ZUUID_LEN-octet value.
    */
    native static long __newFrom (byte [] source);
    public static Zuuid newFrom (byte [] source) {
        return new Zuuid (__newFrom (source));
    }
    /*
    Destroy a specified UUID object.
    */
    native static void __destroy (long self);
    @Override
    public void close () {
        __destroy (self);
        self = 0;
    }
    /*
    Set UUID to new supplied ZUUID_LEN-octet value.
    */
    native static void __set (long self, byte [] source);
    public void set (byte [] source) {
        __set (self, source);
    }
    /*
    Set UUID to new supplied string value skipping '-' and '{' '}'
    optional delimiters. Return 0 if OK, else returns -1.
    */
    native static int __setStr (long self, String source);
    public int setStr (String source) {
        return __setStr (self, source);
    }
    /*
    Return UUID binary data.
    */
    native static byte [] __data (long self);
    public byte [] data () {
        return __data (self);
    }
    /*
    Return UUID binary size
    */
    native static long __size (long self);
    public long size () {
        return __size (self);
    }
    /*
    Returns UUID as string
    */
    native static String __str (long self);
    public String str () {
        return __str (self);
    }
    /*
    Return UUID in the canonical string format: 8-4-4-4-12, in lower
    case. Caller does not modify or free returned value. See
    http://en.wikipedia.org/wiki/Universally_unique_identifier
    */
    native static String __strCanonical (long self);
    public String strCanonical () {
        return __strCanonical (self);
    }
    /*
    Store UUID blob in target array
    */
    native static void __export (long self, byte [] target);
    public void export (byte [] target) {
        __export (self, target);
    }
    /*
    Check if UUID is same as supplied value
    */
    native static boolean __eq (long self, byte [] compare);
    public boolean eq (byte [] compare) {
        return __eq (self, compare);
    }
    /*
    Check if UUID is different from supplied value
    */
    native static boolean __neq (long self, byte [] compare);
    public boolean neq (byte [] compare) {
        return __neq (self, compare);
    }
    /*
    Make copy of UUID object; if uuid is null, or memory was exhausted,
    returns null.
    */
    native static long __dup (long self);
    public Zuuid dup () {
        return new Zuuid (__dup (self));
    }
    /*
    Self test of this class.
    */
    native static void __test (boolean verbose);
    public static void test (boolean verbose) {
        __test (verbose);
    }
}
