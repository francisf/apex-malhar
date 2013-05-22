/**
 * Copyright (c) 2012-2012 Malhar, Inc.
 * All rights reserved.
 */
package com.malhartech.demos.performance;

import java.io.IOException;

import org.junit.Test;

import com.malhartech.api.LocalMode;

/**
 * Test the DAG declaration in local mode.
 */
public class ApplicationTest
{
  @Test
  public void testApplication() throws IOException, Exception
  {
    LocalMode.runApp(new Application(), 60000);
  }
}
