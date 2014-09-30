/*
 * Copyright (c) 2014 DataTorrent, Inc. ALL Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.datatorrent.benchmark.memsql;

import com.datatorrent.api.LocalMode;
import com.datatorrent.common.util.DTThrowable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import org.apache.hadoop.conf.Configuration;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemsqlInputBenchmarkTest
{
  private static final Logger LOG = LoggerFactory.getLogger(MemsqlInputBenchmarkTest.class);

  @Test
  public void testMethod() {
    Configuration conf = new Configuration();
    InputStream inputStream = getClass().getResourceAsStream("/dt-site-memsql.xml");
    conf.addResource(inputStream);

    MemsqlInputBenchmark app = new MemsqlInputBenchmark();
    LocalMode.runApp(app, conf, 20000);

    /*LocalMode lm = LocalMode.newInstance();

    try {
      lm.prepareDAG(app, conf);
      LocalMode.Controller lc = lm.getController();
      //lc.setHeartbeatMonitoringEnabled(false);
      lc.run(20000);
    }
    catch (Exception ex) {
      java.util.logging.Logger.getLogger(MemsqlInputBenchmarkTest.class.getName()).log(Level.SEVERE, null, ex);
    }*/


    try {
      inputStream.close();
    }
    catch (IOException ex) {
      DTThrowable.rethrow(ex);
    }
  }
}
