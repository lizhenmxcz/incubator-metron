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

package org.apache.metron.common.query;

import org.apache.commons.net.util.SubnetUtils;
import org.apache.metron.common.field.validation.network.DomainValidation;
import org.apache.metron.common.field.validation.network.EmailValidation;
import org.apache.metron.common.field.validation.network.IPValidation;
import org.apache.metron.common.field.validation.network.URLValidation;
import org.apache.metron.common.field.validation.primitive.DateValidation;
import org.apache.metron.common.field.validation.primitive.IntegerValidation;

import javax.annotation.Nullable;
import java.util.List;
<<<<<<< HEAD
import java.util.function.Predicate;

public enum LogicalFunctions implements Predicate<List<String>> {
=======
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public enum LogicalFunctions implements Predicate<List<Object>> {
>>>>>>> upstream/master
  IS_EMPTY ( list -> {
    if(list.size() == 0) {
      throw new IllegalStateException("IS_EMPTY expects one string arg");
    }
<<<<<<< HEAD
    String val = list.get(0);
=======
    String val = (String) list.get(0);
>>>>>>> upstream/master
    return val == null || val.isEmpty() ? true:false;
  })
  ,IN_SUBNET( list -> {
    if(list.size() < 2) {
      throw new IllegalStateException("IN_SUBNET expects at least two args: [ip, cidr1, cidr2, ...]"
                                     + " where cidr is the subnet mask in cidr form"
                                     );
    }
<<<<<<< HEAD
    String ip = list.get(0);
=======
    String ip = (String) list.get(0);
>>>>>>> upstream/master
    if(ip == null) {
      return false;
    }
    boolean inSubnet = false;
    for(int i = 1;i < list.size() && !inSubnet;++i) {
<<<<<<< HEAD
      String cidr = list.get(1);
=======
      String cidr = (String) list.get(1);
>>>>>>> upstream/master
      if(cidr == null) {
        continue;
      }
      inSubnet |= new SubnetUtils(cidr).getInfo().isInRange(ip);
    }

    return inSubnet;
  })
  ,STARTS_WITH( list -> {
    if(list.size() < 2) {
      throw new IllegalStateException("STARTS_WITH expects two args: [string, prefix] where prefix is the string fragment that the string should start with");
    }
<<<<<<< HEAD
    String prefix = list.get(1);
    String str = list.get(0);
=======
    String prefix = (String) list.get(1);
    String str = (String) list.get(0);
>>>>>>> upstream/master
    if(str == null || prefix == null) {
      return false;
    }
    return str.startsWith(prefix);
  })
  ,ENDS_WITH( list -> {
    if(list.size() < 2) {
      throw new IllegalStateException("ENDS_WITH expects two args: [string, suffix] where suffix is the string fragment that the string should end with");
    }
<<<<<<< HEAD
    String prefix = list.get(1);
    String str = list.get(0);
=======
    String prefix = (String) list.get(1);
    String str = (String) list.get(0);
>>>>>>> upstream/master
    if(str == null || prefix == null) {
      return false;
    }
    return str.endsWith(prefix);
  })
  ,REGEXP_MATCH( list -> {
     if(list.size() < 2) {
      throw new IllegalStateException("REGEXP_MATCH expects two args: [string, pattern] where pattern is a regexp pattern");
    }
<<<<<<< HEAD
    String pattern = list.get(1);
    String str = list.get(0);
=======
    String pattern = (String) list.get(1);
    String str = (String) list.get(0);
>>>>>>> upstream/master
    if(str == null || pattern == null) {
      return false;
    }
    return str.matches(pattern);
  })
  , IS_IP(new IPValidation())
  , IS_DOMAIN(new DomainValidation())
  , IS_EMAIL(new EmailValidation())
  , IS_URL(new URLValidation())
  , IS_DATE(new DateValidation())
  , IS_INTEGER(new IntegerValidation())
<<<<<<< HEAD
  ;
  Predicate<List<String>> func;
  LogicalFunctions(Predicate<List<String>> func) {
=======
  , MAP_EXISTS(list -> {
      if(list.size() < 2) {
        return false;
      }
      Object key = list.get(0);
      Object mapObj = list.get(1);
      if(key != null && mapObj != null && mapObj instanceof Map) {
        return ((Map)mapObj).containsKey(key);
      }
      return false;
    }
  )
  ;
  Predicate<List<Object>> func;
  LogicalFunctions(Predicate<List<Object>> func) {
>>>>>>> upstream/master
    this.func = func;
  }
  @Nullable
  @Override
<<<<<<< HEAD
  public boolean test(@Nullable List<String> input) {
=======
  public boolean test(@Nullable List<Object> input) {
>>>>>>> upstream/master
    return func.test(input);
  }
}
