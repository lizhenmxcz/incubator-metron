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
package org.apache.metron.common.configuration;

import org.adrianwalker.multilinestring.Multiline;
import org.apache.metron.common.Constants;
import org.apache.metron.common.configuration.enrichment.SensorEnrichmentUpdateConfig;
import org.apache.metron.common.configuration.enrichment.SensorEnrichmentConfig;
import org.apache.metron.common.utils.JSONUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SensorEnrichmentUpdateConfigTest {
  /**
   {
      "index": "bro",
      "batchSize": 5,
      "enrichment" : {
        "fieldMap": {
<<<<<<< HEAD
        "geo": ["ip_dst_addr", "ip_src_addr"],
        "host": ["host"]
=======
          "geo": ["ip_dst_addr", "ip_src_addr"],
          "host": ["host"]
>>>>>>> upstream/master
                    }
      },
      "threatIntel": {
        "fieldMap": {
          "hbaseThreatIntel": ["ip_dst_addr", "ip_src_addr"]
<<<<<<< HEAD
                             },
=======
                    },
>>>>>>> upstream/master
        "fieldToTypeMap": {
          "ip_dst_addr" : [ "malicious_ip" ]
         ,"ip_src_addr" : [ "malicious_ip" ]
                          },
        "triageConfig" : {
          "riskLevelRules" : {
            "not(IN_SUBNET(ip_dst_addr, '192.168.0.0/24'))" : 10
                             },
          "aggregator" : "MAX"
                        }
      }
    }
   */
  @Multiline
  public static String sourceConfigStr;

  /**
{
  "zkQuorum" : "localhost:2181"
 ,"sensorToFieldList" : {
<<<<<<< HEAD
  "bro" : {
           "type" : "THREAT_INTEL"
          ,"fieldToEnrichmentTypes" : {
            "ip_src_addr" : [ "playful" ]
           ,"ip_dst_addr" : [ "playful" ]
                                      }
          }
                        }
}
     */
=======
      "bro" : {
           "type" : "THREAT_INTEL"
          ,"fieldToEnrichmentTypes" : {
              "ip_src_addr" : [ "playful" ]
             ,"ip_dst_addr" : [ "playful" ]
                                      }
              }
                        }
}
  */
>>>>>>> upstream/master
  @Multiline
  public static String threatIntelConfigStr;

  @Test
  public void testThreatIntel() throws Exception {
<<<<<<< HEAD

    SensorEnrichmentConfig broSc = (SensorEnrichmentConfig) ConfigurationType.ENRICHMENT.deserialize(sourceConfigStr);


    SensorEnrichmentUpdateConfig config = JSONUtils.INSTANCE.load(threatIntelConfigStr, SensorEnrichmentUpdateConfig.class);
    final Map<String, SensorEnrichmentConfig> outputScs = new HashMap<>();
=======
    SensorEnrichmentConfig broSc = (SensorEnrichmentConfig) ConfigurationType.ENRICHMENT.deserialize(sourceConfigStr);
    SensorEnrichmentUpdateConfig threatIntelConfig = JSONUtils.INSTANCE.load(threatIntelConfigStr, SensorEnrichmentUpdateConfig.class);
    final Map<String, SensorEnrichmentConfig> finalEnrichmentConfig = new HashMap<>();
>>>>>>> upstream/master
    SensorEnrichmentUpdateConfig.SourceConfigHandler scHandler = new SensorEnrichmentUpdateConfig.SourceConfigHandler() {
      @Override
      public SensorEnrichmentConfig readConfig(String sensor) throws Exception {
        if(sensor.equals("bro")) {
          return JSONUtils.INSTANCE.load(sourceConfigStr, SensorEnrichmentConfig.class);
        }
        else {
          throw new IllegalStateException("Tried to retrieve an unexpected sensor: " + sensor);
        }
      }

      @Override
      public void persistConfig(String sensor, SensorEnrichmentConfig config) throws Exception {
<<<<<<< HEAD
        outputScs.put(sensor, config);
      }
    };
    SensorEnrichmentUpdateConfig.updateSensorConfigs(scHandler, config.getSensorToFieldList());
    Assert.assertNotNull(outputScs.get("bro"));
    Assert.assertNotSame(outputScs.get("bro"), broSc);
    Assert.assertEquals( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getThreatIntel().getFieldMap().get(Constants.SIMPLE_HBASE_THREAT_INTEL).size()
                       , 2
                       );
    Assert.assertEquals(1, outputScs.get("bro").getThreatIntel().getTriageConfig().getRiskLevelRules().size());
    Assert.assertTrue( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getThreatIntel().getFieldMap()
                                  .get(Constants.SIMPLE_HBASE_THREAT_INTEL)
                                  .contains("ip_src_addr")
                       );
    Assert.assertTrue( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getThreatIntel().getFieldMap()
                                  .get(Constants.SIMPLE_HBASE_THREAT_INTEL)
                                  .contains("ip_dst_addr")
                       );
    Assert.assertEquals( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getThreatIntel().getFieldToTypeMap().keySet().size()
                       , 2
                       );
    Assert.assertEquals( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_src_addr").size()
                       , 2
                       );
    Assert.assertTrue( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_src_addr").contains("playful")
                       );
    Assert.assertTrue( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_src_addr").contains("malicious_ip")
                       );
    Assert.assertEquals( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_dst_addr").size()
                       , 2
                       );
    Assert.assertTrue( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_dst_addr").contains("playful")
                       );
    Assert.assertTrue( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_dst_addr").contains("malicious_ip")
=======
        finalEnrichmentConfig.put(sensor, config);
      }
    };
    SensorEnrichmentUpdateConfig.updateSensorConfigs(scHandler, threatIntelConfig.getSensorToFieldList());
    Assert.assertNotNull(finalEnrichmentConfig.get("bro"));
    Assert.assertNotSame(finalEnrichmentConfig.get("bro"), broSc);
    Assert.assertEquals( finalEnrichmentConfig.get("bro").toJSON()
                       , finalEnrichmentConfig.get("bro").getThreatIntel().getFieldMap().get(Constants.SIMPLE_HBASE_THREAT_INTEL).size()
                       , 2
                       );
    Assert.assertEquals(1, finalEnrichmentConfig.get("bro").getThreatIntel().getTriageConfig().getRiskLevelRules().size());
    Assert.assertTrue( finalEnrichmentConfig.get("bro").toJSON()
                       , finalEnrichmentConfig.get("bro").getThreatIntel().getFieldMap()
                                  .get(Constants.SIMPLE_HBASE_THREAT_INTEL)
                                  .contains("ip_src_addr")
                       );
    Assert.assertTrue( finalEnrichmentConfig.get("bro").toJSON()
                       , finalEnrichmentConfig.get("bro").getThreatIntel().getFieldMap()
                                  .get(Constants.SIMPLE_HBASE_THREAT_INTEL)
                                  .contains("ip_dst_addr")
                       );
    Assert.assertEquals( finalEnrichmentConfig.get("bro").toJSON()
                       , finalEnrichmentConfig.get("bro").getThreatIntel().getFieldToTypeMap().keySet().size()
                       , 2
                       );
    Assert.assertEquals( finalEnrichmentConfig.get("bro").toJSON()
                       , finalEnrichmentConfig.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_src_addr").size()
                       , 2
                       );
    Assert.assertTrue( finalEnrichmentConfig.get("bro").toJSON()
                       , finalEnrichmentConfig.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_src_addr").contains("playful")
                       );
    Assert.assertTrue( finalEnrichmentConfig.get("bro").toJSON()
                       , finalEnrichmentConfig.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_src_addr").contains("malicious_ip")
                       );
    Assert.assertEquals( finalEnrichmentConfig.get("bro").toJSON()
                       , finalEnrichmentConfig.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_dst_addr").size()
                       , 2
                       );
    Assert.assertTrue( finalEnrichmentConfig.get("bro").toJSON()
                       , finalEnrichmentConfig.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_dst_addr").contains("playful")
                       );
    Assert.assertTrue( finalEnrichmentConfig.get("bro").toJSON()
                       , finalEnrichmentConfig.get("bro").getThreatIntel().getFieldToTypeMap().get("ip_dst_addr").contains("malicious_ip")
>>>>>>> upstream/master
                       );
  }

  /**
   {
  "zkQuorum" : "localhost:2181"
 ,"sensorToFieldList" : {
  "bro" : {
           "type" : "ENRICHMENT"
          ,"fieldToEnrichmentTypes" : {
            "ip_src_addr" : [ "playful" ]
           ,"ip_dst_addr" : [ "playful" ]
                                      }
          }
                        }
   }
   */
  @Multiline
  public static String enrichmentConfigStr;
  @Test
  public void testEnrichment() throws Exception {

    SensorEnrichmentConfig broSc = JSONUtils.INSTANCE.load(sourceConfigStr, SensorEnrichmentConfig.class);

    SensorEnrichmentUpdateConfig config = JSONUtils.INSTANCE.load(enrichmentConfigStr, SensorEnrichmentUpdateConfig.class);
    final Map<String, SensorEnrichmentConfig> outputScs = new HashMap<>();
    SensorEnrichmentUpdateConfig.SourceConfigHandler scHandler = new SensorEnrichmentUpdateConfig.SourceConfigHandler() {
      @Override
      public SensorEnrichmentConfig readConfig(String sensor) throws Exception {
        if(sensor.equals("bro")) {
          return JSONUtils.INSTANCE.load(sourceConfigStr, SensorEnrichmentConfig.class);
        }
        else {
          throw new IllegalStateException("Tried to retrieve an unexpected sensor: " + sensor);
        }
      }

      @Override
      public void persistConfig(String sensor, SensorEnrichmentConfig config) throws Exception {
        outputScs.put(sensor, config);
      }
    };
    SensorEnrichmentUpdateConfig.updateSensorConfigs(scHandler, config.getSensorToFieldList());
    Assert.assertNotNull(outputScs.get("bro"));
    Assert.assertNotSame(outputScs.get("bro"), broSc);
    Assert.assertEquals( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getEnrichment().getFieldMap().get(Constants.SIMPLE_HBASE_ENRICHMENT).size()
                       , 2
                       );
    Assert.assertTrue( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getEnrichment().getFieldMap()
                                  .get(Constants.SIMPLE_HBASE_ENRICHMENT)
                                  .contains("ip_src_addr")
                       );
    Assert.assertTrue( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getEnrichment().getFieldMap()
                                  .get(Constants.SIMPLE_HBASE_ENRICHMENT)
                                  .contains("ip_dst_addr")
                       );
    Assert.assertEquals( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getEnrichment().getFieldToTypeMap().keySet().size()
                       , 2
                       );
    Assert.assertEquals( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getEnrichment().getFieldToTypeMap().get("ip_src_addr").size()
                       , 1
                       );
    Assert.assertEquals( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getEnrichment().getFieldToTypeMap().get("ip_src_addr").get(0)
                       , "playful"
                       );
    Assert.assertEquals( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getEnrichment().getFieldToTypeMap().get("ip_dst_addr").size()
                       , 1
                       );
    Assert.assertEquals( outputScs.get("bro").toJSON()
                       , outputScs.get("bro").getEnrichment().getFieldToTypeMap().get("ip_dst_addr").get(0)
                       , "playful"
                       );
  }
}
