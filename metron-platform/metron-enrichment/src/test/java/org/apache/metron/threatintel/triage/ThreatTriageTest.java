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

package org.apache.metron.threatintel.triage;

import org.adrianwalker.multilinestring.Multiline;
<<<<<<< HEAD
=======
import org.apache.metron.common.configuration.enrichment.SensorEnrichmentConfig;
>>>>>>> upstream/master
import org.apache.metron.common.configuration.enrichment.threatintel.ThreatTriageConfig;
import org.apache.metron.common.utils.JSONUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

public class ThreatTriageTest {
  /**
   {
<<<<<<< HEAD
    "riskLevelRules" : {
        "user.type in [ 'admin', 'power' ] and asset.type == 'web'" : 10
       ,"asset.type == 'web'" : 5
       ,"user.type == 'normal'  and asset.type == 'web'" : 0
                          }
   ,"aggregator" : "MAX"
=======
    "threatIntel" : {
      "triageConfig" :
      {
        "riskLevelRules" : {
            "user.type in [ 'admin', 'power' ] and asset.type == 'web'" : 10
           ,"asset.type == 'web'" : 5
          ,"user.type == 'normal'  and asset.type == 'web'" : 0
          ,"user.type in whitelist" : -1
                          }
        ,"aggregator" : "MAX"
      },
      "config" : {
        "whitelist" : [ "abnormal" ]
                 }
    }
>>>>>>> upstream/master
   }
   */
  @Multiline
  public static String smokeTestProcessorConfig;

  private static ThreatTriageProcessor getProcessor(String config) throws IOException {
<<<<<<< HEAD
    ThreatTriageConfig c = JSONUtils.INSTANCE.load(config, ThreatTriageConfig.class);
=======
    SensorEnrichmentConfig c = JSONUtils.INSTANCE.load(config, SensorEnrichmentConfig.class);
>>>>>>> upstream/master
    return new ThreatTriageProcessor(c);
  }

  @Test
  public void smokeTest() throws Exception {
    ThreatTriageProcessor threatTriageProcessor = getProcessor(smokeTestProcessorConfig);
    Assert.assertEquals("Expected a score of 0"
                       , 0d
<<<<<<< HEAD
                       ,new ThreatTriageProcessor(new ThreatTriageConfig()).apply(new HashMap<Object, Object>() {{
=======
                       ,new ThreatTriageProcessor(new SensorEnrichmentConfig()).apply(new HashMap<Object, Object>() {{
>>>>>>> upstream/master
                          put("user.type", "admin");
                          put("asset.type", "web");
                                        }}
                                        )
                       , 1e-10
                       );
    Assert.assertEquals("Expected a score of 10"
                       , 10d
                       , threatTriageProcessor.apply(new HashMap<Object, Object>() {{
                          put("user.type", "admin");
                          put("asset.type", "web");
                                        }}
                                        )
                       , 1e-10
                       );
    Assert.assertEquals("Expected a score of 5"
                       , 5d
                       , threatTriageProcessor.apply(new HashMap<Object, Object>() {{
                          put("user.type", "normal");
                          put("asset.type", "web");
                                        }}
                                        )
                       , 1e-10
                       );
    Assert.assertEquals("Expected a score of 0"
                       , 0d
                       , threatTriageProcessor.apply(new HashMap<Object, Object>() {{
                          put("user.type", "foo");
                          put("asset.type", "bar");
                                        }}
                                        )
                       , 1e-10
                       );
<<<<<<< HEAD
=======
    Assert.assertEquals("Expected a score of -Inf"
                       , Double.NEGATIVE_INFINITY
                       , threatTriageProcessor.apply(new HashMap<Object, Object>() {{
                          put("user.type", "abnormal");
                          put("asset.type", "bar");
                                        }}
                                        )
                       , 1e-10
                       );
>>>>>>> upstream/master
  }

  /**
   {
<<<<<<< HEAD
    "riskLevelRules" : {
        "user.type in [ 'admin', 'power' ] and asset.type == 'web'" : 10
       ,"asset.type == 'web'" : 5
       ,"user.type == 'normal'  and asset.type == 'web'" : 0
                          }
   ,"aggregator" : "POSITIVE_MEAN"
=======
    "threatIntel" : {
      "triageConfig" :
      {
        "riskLevelRules" : {
            "user.type in [ 'admin', 'power' ] and asset.type == 'web'" : 10
           ,"asset.type == 'web'" : 5
           ,"user.type == 'normal'  and asset.type == 'web'" : 0
                          }
        ,"aggregator" : "POSITIVE_MEAN"
      }
                   }
>>>>>>> upstream/master
   }
   */
  @Multiline
  public static String positiveMeanProcessorConfig;

  @Test
  public void positiveMeanAggregationTest() throws Exception {

    ThreatTriageProcessor threatTriageProcessor = getProcessor(positiveMeanProcessorConfig);
    Assert.assertEquals("Expected a score of 0"
                       , 5d
                       , threatTriageProcessor.apply(new HashMap<Object, Object>() {{
                          put("user.type", "normal");
                          put("asset.type", "web");
                                        }}
                                        )
                       , 1e-10
                       );
    Assert.assertEquals("Expected a score of 7.5"
                       , (10 + 5)/2.0
                       , threatTriageProcessor.apply(new HashMap<Object, Object>() {{
                          put("user.type", "admin");
                          put("asset.type", "web");
                                        }}
                                        )
                       , 1e-10
                       );

    Assert.assertEquals("Expected a score of 0"
                       , 0d
                       , threatTriageProcessor.apply(new HashMap<Object, Object>() {{
                          put("user.type", "foo");
                          put("asset.type", "bar");
                                        }}
                                        )
                       , 1e-10
                       );
  }
}
