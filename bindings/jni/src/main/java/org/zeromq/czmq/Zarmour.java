/*
################################################################################
#  THIS FILE IS 100% GENERATED BY ZPROJECT; DO NOT EDIT EXCEPT EXPERIMENTALLY  #
#  Read the zproject/README.md for information about making permanent changes. #
################################################################################
*/
package org.zeromq.czmq;

import java.util.stream.Stream;
import org.zeromq.tools.ZmqNativeLoader;

public class Zarmour implements AutoCloseable{
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
    Create a new zarmour
    */
    native static long __new ();
    public Zarmour () {
        /*  TODO: if __new fails, self is null...            */
        self = __new ();
    }
    public Zarmour (long pointer) {
        self = pointer;
    }
    /*
    Destroy the zarmour
    */
    native static void __destroy (long self);
    @Override
    public void close () {
        __destroy (self);
        self = 0;
    }
    /*
    Encode a stream of bytes into an armoured string. Returns the armoured
    string, or NULL if there was insufficient memory available to allocate
    a new string.
    */
    native static String __encode (long self, byte [] data, long size);
    public String encode (byte [] data, long size) {
        return __encode (self, data, size);
    }
    /*
    Decode an armoured string into a chunk. The decoded output is
    null-terminated, so it may be treated as a string, if that's what
    it was prior to encoding.
    */
    native static long __decode (long self, String data);
    public Zchunk decode (String data) {
        return new Zchunk (__decode (self, data));
    }
    /*
    Get the mode property.
    */
    native static int __mode (long self);
    public int mode () {
        return __mode (self);
    }
    /*
    Get printable string for mode.
    */
    native static String __modeStr (long self);
    public String modeStr () {
        return __modeStr (self);
    }
    /*
    Set the mode property.
    */
    native static void __setMode (long self, int mode);
    public void setMode (int mode) {
        __setMode (self, mode);
    }
    /*
    Return true if padding is turned on.
    */
    native static boolean __pad (long self);
    public boolean pad () {
        return __pad (self);
    }
    /*
    Turn padding on or off. Default is on.
    */
    native static void __setPad (long self, boolean pad);
    public void setPad (boolean pad) {
        __setPad (self, pad);
    }
    /*
    Get the padding character.
    */
    native static char __padChar (long self);
    public char padChar () {
        return __padChar (self);
    }
    /*
    Set the padding character.
    */
    native static void __setPadChar (long self, char padChar);
    public void setPadChar (char padChar) {
        __setPadChar (self, padChar);
    }
    /*
    Return if splitting output into lines is turned on. Default is off.
    */
    native static boolean __lineBreaks (long self);
    public boolean lineBreaks () {
        return __lineBreaks (self);
    }
    /*
    Turn splitting output into lines on or off.
    */
    native static void __setLineBreaks (long self, boolean lineBreaks);
    public void setLineBreaks (boolean lineBreaks) {
        __setLineBreaks (self, lineBreaks);
    }
    /*
    Get the line length used for splitting lines.
    */
    native static long __lineLength (long self);
    public long lineLength () {
        return __lineLength (self);
    }
    /*
    Set the line length used for splitting lines.
    */
    native static void __setLineLength (long self, long lineLength);
    public void setLineLength (long lineLength) {
        __setLineLength (self, lineLength);
    }
    /*
    Print properties of object
    */
    native static void __print (long self);
    public void print () {
        __print (self);
    }
    /*
    Self test of this class.
    */
    native static void __test (boolean verbose);
    public static void test (boolean verbose) {
        __test (verbose);
    }
}
