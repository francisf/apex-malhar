/*
 *  Copyright (c) 2012-2013 Malhar, Inc.
 *  All Rights Reserved.
 */
package com.malhartech.demos.wordcount;

import com.malhartech.api.ApplicationFactory;
import com.malhartech.api.DAG;
import com.malhartech.lib.algo.UniqueCounterEach;
import com.malhartech.lib.io.ConsoleOutputOperator;

import org.apache.hadoop.conf.Configuration;

/**
 * To run the test, you need to generate a data file as sample file.
 * default location is
 * This program will count the number of words.
 *
 * @author Zhongjian Wang <zhongjian@malhar-inc.com>
 */
public class Application implements ApplicationFactory
{
  private boolean allInline =  false;

  @Override
  public void getApplication(DAG dag, Configuration conf)
  {
    allInline = true;

    WordCountInputOperator input = dag.addOperator("wordinput", new WordCountInputOperator());
    UniqueCounterEach<String> wordCount = dag.addOperator("count", new UniqueCounterEach<String>());

    dag.addStream("wordinput-count", input.outputPort, wordCount.data).setInline(allInline);

    ConsoleOutputOperator consoleOperator = dag.addOperator("console", new ConsoleOutputOperator());
    dag.addStream("count-console",wordCount.count, consoleOperator.input);

  }


}
