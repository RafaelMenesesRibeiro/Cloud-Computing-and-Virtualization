/* ConstantValue_Attribute.java
 * Part of BIT -- Bytecode Instrumenting Tool
 *
 * Copyright (c) 1997, The Regents of the University of Colorado. All
 * Rights Reserved.
 * 
 * Permission to use and copy this software and its documentation for
 * NON-COMMERCIAL purposes and without fee is hereby granted provided
 * that this copyright notice appears in all copies. If you wish to use
 * or wish to have others use BIT for commercial purposes please contact,
 * Stephen V. O'Neil, Director, Office of Technology Transfer at the
 * University of Colorado at Boulder (303) 492-5647.
 *  
 * By downloading BIT, the User agrees and acknowledges that in no event
 * will the Regents of the University of Colorado be liable for any
 * damages including lost profits, lost savings or other indirect,
 * incidental, special or consequential damages arising out of the use or
 * inability to use the BIT software.
 * 
 * BIT was invented by Han Bok Lee at the University of Colorado in
 * Boulder, Colorado.
 */


package BIT.lowBIT;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantValue_Attribute extends Attribute_Info {
  // data members
  
  // constantvalue_index is an index into the constant pool
  //   table and indicates the value of the constant
  public short constantvalue_index;
  
  // constructor
  public ConstantValue_Attribute(DataInputStream iStream, short attribute_name_index, Cp_Info[] cp)
    throws IOException {
    this.attribute_name_index = attribute_name_index;
    attribute_length = iStream.readInt();
    if (System.getProperty("CJKDEBUG3") != null)
    System.err.println("READ BIT parsing len: " + attribute_length);
    constantvalue_index = (short) iStream.readUnsignedShort();
  }

  public void write(DataOutputStream oStream) throws IOException
  {
    oStream.writeShort((int) attribute_name_index);
    oStream.writeInt(attribute_length);
    oStream.writeShort((int) constantvalue_index);
  }
}
