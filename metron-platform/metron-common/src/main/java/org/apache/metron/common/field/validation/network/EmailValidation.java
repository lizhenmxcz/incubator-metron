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

package org.apache.metron.common.field.validation.network;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.metron.common.field.validation.SimpleValidation;

import java.util.Map;
import java.util.function.Predicate;

public class EmailValidation extends SimpleValidation{
  @Override
<<<<<<< HEAD
  public Predicate<String> getPredicate() {
    return email -> EmailValidator.getInstance().isValid(email);
=======
  public Predicate<Object> getPredicate() {
    return email -> EmailValidator.getInstance().isValid(email == null?null:email.toString());
>>>>>>> upstream/master
  }
}
