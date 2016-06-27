/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.metron.common.configuration.writer;

import org.apache.metron.common.configuration.ParserConfigurations;
import org.apache.metron.common.utils.ConversionUtils;

import java.util.Map;

public class ParserWriterConfiguration implements WriterConfiguration {
  public static final String BATCH_CONF = "batchSize";
  public static final String INDEX_CONF = "indexName";
  private ParserConfigurations config;
  public ParserWriterConfiguration(ParserConfigurations config) {
    this.config = config;
  }
  @Override
  public int getBatchSize(String sensorName) {
<<<<<<< HEAD
    Object batchObj = config.getSensorParserConfig(sensorName).getParserConfig().get(BATCH_CONF);
    return batchObj == null?1:ConversionUtils.convert(batchObj, Integer.class);
=======
    if(config != null
    && config.getSensorParserConfig(sensorName) != null
    && config.getSensorParserConfig(sensorName).getParserConfig() != null
      ) {
      Object batchObj = config.getSensorParserConfig(sensorName).getParserConfig().get(BATCH_CONF);
      return batchObj == null ? 1 : ConversionUtils.convert(batchObj, Integer.class);
    }
    return 1;
>>>>>>> upstream/master
  }

  @Override
  public String getIndex(String sensorName) {
<<<<<<< HEAD
    Object indexObj = config.getSensorParserConfig(sensorName).getParserConfig().get(INDEX_CONF);
    return indexObj.toString();
=======
    if(config != null && config.getSensorParserConfig(sensorName) != null
    && config.getSensorParserConfig(sensorName).getParserConfig() != null
      ) {
      Object indexObj = config.getSensorParserConfig(sensorName).getParserConfig().get(INDEX_CONF);
      if(indexObj != null) {
        return indexObj.toString();
      }
      return null;
    }
    return sensorName;
>>>>>>> upstream/master
  }

  @Override
  public Map<String, Object> getSensorConfig(String sensorName) {
    return config.getSensorParserConfig(sensorName).getParserConfig();
  }

  @Override
  public Map<String, Object> getGlobalConfig() {
    return config.getGlobalConfig();
  }
}
