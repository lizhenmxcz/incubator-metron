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

package org.apache.metron.common.field.validation;

import org.apache.metron.common.query.BooleanOp;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

<<<<<<< HEAD
public abstract class SimpleValidation implements FieldValidation, Predicate<List<String>> {
=======
public abstract class SimpleValidation implements FieldValidation, Predicate<List<Object>> {
>>>>>>> upstream/master
  @Override
  public boolean isValid( Map<String, Object> input
                        , Map<String, Object> validationConfig
                        , Map<String, Object> globalConfig
                        )
  {
<<<<<<< HEAD
    Predicate<String> predicate = getPredicate();
=======
    Predicate<Object> predicate = getPredicate();
>>>>>>> upstream/master
    if(isNonExistentOk()) {
      for (Object o : input.values()) {
        if (o != null && !predicate.test(o.toString())) {
          return false;
        }
      }
    }
    else {
      for (Object o : input.values()) {
        if (o == null || !predicate.test(o.toString())) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
<<<<<<< HEAD
  public boolean test(List<String> input) {
    Predicate<String> predicate = getPredicate();
    for(String o : input) {
=======
  public boolean test(List<Object> input) {
    Predicate<Object> predicate = getPredicate();
    for(Object o : input) {
>>>>>>> upstream/master
      if(o == null || !predicate.test(o)){
        return false;
      }
    }
    return true;
  }

  @Override
  public void initialize(Map<String, Object> validationConfig, Map<String, Object> globalConfig) {

  }

<<<<<<< HEAD
  public abstract Predicate<String> getPredicate();
=======
  public abstract Predicate<Object> getPredicate();
>>>>>>> upstream/master
  protected boolean isNonExistentOk() {
    return true;
  }
}
