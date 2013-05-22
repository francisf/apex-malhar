/*
 *  Copyright (c) 2012 Malhar, Inc.
 *  All Rights Reserved.
 */
package com.malhartech.demos.mobile;

import org.junit.Test;

import com.malhartech.api.LocalMode;


public class ApplicationTest
{
  public ApplicationTest()
  {
  }

  /**
   * Test of getApplication method, of class Application.
   */
  @Test
  public void testGetApplication() throws Exception
  {
    LocalMode.runApp(new Application(), 10000);
  }
}
