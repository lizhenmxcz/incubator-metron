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

package org.apache.metron.common.field.validation.primitive;

import org.apache.metron.common.field.validation.SimpleValidation;

import java.util.function.Predicate;

public class NotEmptyValidation extends SimpleValidation {
  @Override
<<<<<<< HEAD
  public Predicate<String> getPredicate() {
    return s -> !(s == null || s.trim().isEmpty());
=======
  public Predicate<Object> getPredicate() {
    return s -> !(s == null || s.toString().trim().isEmpty());
>>>>>>> upstream/master
  }

  @Override
  protected boolean isNonExistentOk() {
    return false;
  }
}
