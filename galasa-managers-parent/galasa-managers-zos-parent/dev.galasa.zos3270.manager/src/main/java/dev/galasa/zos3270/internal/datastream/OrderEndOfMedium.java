/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2020.
 */
package dev.galasa.zos3270.internal.datastream;

public class OrderEndOfMedium extends AbstractOrder {

    public static final byte ID = 0x19;

    public OrderEndOfMedium() {
    }

    @Override
    public String toString() {
        return "ENDOFMEDIUM()";
    }

    public String getText() {
        return " ";
    }

    @Override
    public byte[] getBytes() {
        return new byte[] {ID};
    }

}
