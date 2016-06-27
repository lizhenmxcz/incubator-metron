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

<<<<<<< HEAD
import com.google.common.base.Function;
import com.google.common.base.Joiner;
=======
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;
import org.apache.metron.common.dsl.*;
>>>>>>> upstream/master
import org.apache.metron.common.query.generated.PredicateBaseListener;
import org.apache.metron.common.query.generated.PredicateParser;

import java.util.*;
<<<<<<< HEAD
=======
import java.util.function.Function;
>>>>>>> upstream/master
import java.util.function.Predicate;

class QueryCompiler extends PredicateBaseListener {
  private VariableResolver resolver = null;
<<<<<<< HEAD
  private Stack<PredicateToken> tokenStack = new Stack<>();
=======
  private Stack<Token> tokenStack = new Stack<>();
>>>>>>> upstream/master

  public QueryCompiler(VariableResolver resolver) {
    this.resolver = resolver;
  }

  @Override
  public void enterSingle_rule(org.apache.metron.common.query.generated.PredicateParser.Single_ruleContext ctx) {
    tokenStack.clear();
  }

  @Override
  public void exitSingle_rule(org.apache.metron.common.query.generated.PredicateParser.Single_ruleContext ctx) {
  }

  @Override
  public void exitLogicalExpressionAnd(PredicateParser.LogicalExpressionAndContext ctx) {
<<<<<<< HEAD
    PredicateToken<?> left = popStack();
    PredicateToken<?> right = popStack();
    tokenStack.push(new PredicateToken<>(booleanOp(left, right, (l, r) -> l && r, "&&"), Boolean.class));
=======
    Token<?> left = popStack();
    Token<?> right = popStack();
    tokenStack.push(new Token<>(booleanOp(left, right, (l, r) -> l && r, "&&"), Boolean.class));
>>>>>>> upstream/master
  }

  @Override
  public void exitLogicalExpressionOr(PredicateParser.LogicalExpressionOrContext ctx) {
<<<<<<< HEAD
    PredicateToken<?> left = popStack();
    PredicateToken<?> right = popStack();

    tokenStack.push(new PredicateToken<>(booleanOp(left, right, (l, r) -> l || r, "||"), Boolean.class));
  }

  private boolean booleanOp(PredicateToken<?> left, PredicateToken<?> right, BooleanOp op, String opName)
=======
    Token<?> left = popStack();
    Token<?> right = popStack();

    tokenStack.push(new Token<>(booleanOp(left, right, (l, r) -> l || r, "||"), Boolean.class));
  }

  private boolean booleanOp(Token<?> left, Token<?> right, BooleanOp op, String opName)
>>>>>>> upstream/master
  {
    if(left.getUnderlyingType().equals(right.getUnderlyingType()) && left.getUnderlyingType().equals(Boolean.class)) {
      Boolean l = (Boolean) left.getValue();
      Boolean r = (Boolean) right.getValue();
      if(l == null || r == null) {
        throw new ParseException("Unable to operate on " + left.getValue()  + " " + opName + " " + right.getValue() + ", null value");
      }
      return op.op(l, r);
    }
    else {
      throw new ParseException("Unable to operate on " + left.getValue()  + " " + opName + " " + right.getValue() + ", bad types");
    }
  }


  @Override
  public void exitLogicalConst(PredicateParser.LogicalConstContext ctx) {
    Boolean b = null;
    switch(ctx.getText().toUpperCase()) {
      case "TRUE":
        b = true;
        break;
      case "FALSE":
        b = false;
        break;
      default:
        throw new ParseException("Unable to process " + ctx.getText() + " as a boolean constant");
    }
<<<<<<< HEAD
    tokenStack.push(new PredicateToken<>(b, Boolean.class));
=======
    tokenStack.push(new Token<>(b, Boolean.class));
  }


  @Override
  public void exitDoubleLiteral(PredicateParser.DoubleLiteralContext ctx) {
    tokenStack.push(new Token<>(Double.parseDouble(ctx.getText()), Double.class));
  }


  @Override
  public void exitIntegerLiteral(PredicateParser.IntegerLiteralContext ctx) {
    tokenStack.push(new Token<>(Integer.parseInt(ctx.getText()), Integer.class));
  }

  private <T extends Comparable<T>> boolean compare(T l, T r, String op) {
    if(op.equals("==")) {
        return l.compareTo(r) == 0;
      }
      else if(op.equals("!=")) {
        return l.compareTo(r) != 0;
      }
      else if(op.equals("<")) {
        return l.compareTo(r) < 0;
      }
      else if(op.equals(">")) {
        return l.compareTo(r) > 0;
      }
      else if(op.equals(">=")) {
        return l.compareTo(r) >= 0;
      }
      else {
        return l.compareTo(r) <= 0;
      }
>>>>>>> upstream/master
  }

  @Override
  public void exitComparisonExpressionWithOperator(PredicateParser.ComparisonExpressionWithOperatorContext ctx) {
<<<<<<< HEAD
    boolean isEqualsOp = ctx.getChild(1).getText().equals("==");
    PredicateToken<?> left = popStack();
    PredicateToken<?> right = popStack();
    if(left.getUnderlyingType().equals(right.getUnderlyingType())) {
      boolean isEquals = left.equals(right);
      tokenStack.push(new PredicateToken<>(isEqualsOp?isEquals:!isEquals, Boolean.class));
    }
    else {
      throw new ParseException("Unable to compare " + left.getValue() + " " + ctx.getText() + " " + right.getValue());
    }
  }

  public PredicateToken<?> popStack() {
=======
    String op = ctx.getChild(1).getText();
    Token<?> right = popStack();
    Token<?> left = popStack();
    if(left.getValue() instanceof Number
    && right.getValue() instanceof Number
      ) {
      Double l = ((Number)left.getValue()).doubleValue();
      Double r = ((Number)right.getValue()).doubleValue();
      tokenStack.push(new Token<>(compare(l, r, op), Boolean.class));

    }
    else {
      String l = left.getValue() == null?"":left.getValue().toString();
      String r = right.getValue() == null?"":right.getValue().toString();
      tokenStack.push(new Token<>(compare(l, r, op), Boolean.class));
    }
  }

  public Token<?> popStack() {
>>>>>>> upstream/master
    if(tokenStack.empty()) {
      throw new ParseException("Unable to pop an empty stack");
    }
    return tokenStack.pop();
  }

  @Override
  public void exitLogicalVariable(PredicateParser.LogicalVariableContext ctx) {
<<<<<<< HEAD
    tokenStack.push(new PredicateToken<>(resolver.resolve(ctx.getText()), String.class));
=======
    tokenStack.push(new Token<>(resolver.resolve(ctx.getText()), Object.class));
>>>>>>> upstream/master
  }


  @Override
  public void exitStringLiteral(PredicateParser.StringLiteralContext ctx) {
    String val = ctx.getText();
<<<<<<< HEAD
    tokenStack.push(new PredicateToken<>(val.substring(1, val.length() - 1), String.class));
  }


  @Override
  public void enterList_entity(PredicateParser.List_entityContext ctx) {
    tokenStack.push(new PredicateToken<>(new FunctionMarker(), FunctionMarker.class));
=======
    tokenStack.push(new Token<>(val.substring(1, val.length() - 1), String.class));
  }



  @Override
  public void enterList_entity(PredicateParser.List_entityContext ctx) {
    tokenStack.push(new Token<>(new FunctionMarker(), FunctionMarker.class));
>>>>>>> upstream/master
  }


  @Override
  public void exitList_entity(PredicateParser.List_entityContext ctx) {
<<<<<<< HEAD
    Set<String> inSet = new HashSet<>();
    while(true) {
      PredicateToken<?> token = popStack();
=======
    LinkedList<String> args = new LinkedList<>();
    while(true) {
      Token<?> token = popStack();
>>>>>>> upstream/master
      if(token.getUnderlyingType().equals(FunctionMarker.class)) {
        break;
      }
      else {
<<<<<<< HEAD
        inSet.add((String)token.getValue());
      }
    }
    tokenStack.push(new PredicateToken<>(inSet, Set.class));
=======
        args.addFirst((String)token.getValue());
      }
    }
    tokenStack.push(new Token<>(args, List.class));
>>>>>>> upstream/master
  }


  @Override
  public void enterFunc_args(PredicateParser.Func_argsContext ctx) {
<<<<<<< HEAD
    tokenStack.push(new PredicateToken<>(new FunctionMarker(), FunctionMarker.class));
=======
    tokenStack.push(new Token<>(new FunctionMarker(), FunctionMarker.class));
>>>>>>> upstream/master
  }


  @Override
  public void exitFunc_args(PredicateParser.Func_argsContext ctx) {
<<<<<<< HEAD
    LinkedList<String> args = new LinkedList<>();
    while(true) {
      PredicateToken<?> token = popStack();
=======
    LinkedList<Object> args = new LinkedList<>();
    while(true) {
      Token<?> token = popStack();
>>>>>>> upstream/master
      if(token.getUnderlyingType().equals(FunctionMarker.class)) {
        break;
      }
      else {
<<<<<<< HEAD
        args.addFirst((String)token.getValue());
      }
    }
    tokenStack.push(new PredicateToken<>(args, List.class));
  }

  @Override
  public void exitInExpression(PredicateParser.InExpressionContext ctx) {
    PredicateToken<?> left = popStack();
    PredicateToken<?> right = popStack();
    String key = null;
    Set<String> set = null;
    if(left.getUnderlyingType().equals(Set.class)) {
      set = (Set<String>) left.getValue();
    }
    else {
      throw new ParseException("Unable to process in clause because " + left.getValue() + " is not a set");
    }
    if(right.getUnderlyingType().equals(String.class)) {
      key = (String) right.getValue();
    }
    else {
      throw new ParseException("Unable to process in clause because " + right.getValue() + " is not a string");
    }
    tokenStack.push(new PredicateToken<>(set.contains(key), Boolean.class));
  }

  @Override
  public void exitNInExpression(PredicateParser.NInExpressionContext ctx) {
    PredicateToken<?> left = popStack();
    PredicateToken<?> right = popStack();
    String key = null;
    Set<String> set = null;
    if(left.getUnderlyingType().equals(Set.class)) {
      set = (Set<String>) left.getValue();
    }
    else {
      throw new ParseException("Unable to process in clause because " + left.getValue() + " is not a set");
    }
    if(right.getUnderlyingType().equals(String.class)) {
      key = (String) right.getValue();
    }
    else {
      throw new ParseException("Unable to process in clause because " + right.getValue() + " is not a string");
    }
    tokenStack.push(new PredicateToken<>(!set.contains(key), Boolean.class));
=======
        args.addFirst(token.getValue());
      }
    }
    tokenStack.push(new Token<>(args, List.class));
  }

  private boolean handleIn(Token<?> left, Token<?> right) {
    Object key = null;
    Set<Object> set = null;
    if(left.getValue() instanceof Collection) {
      set = new HashSet<>((List<Object>) left.getValue());
    }
    else if(left.getValue() != null) {
      set = ImmutableSet.of(left.getValue());
    }
    else {
      set = new HashSet<>();
    }


    key = right.getValue();
    if(key == null || set.isEmpty()) {
      return false;
    }
    return set.contains(key);
  }

  @Override
  public void exitInExpression(PredicateParser.InExpressionContext ctx) {
    Token<?> left = popStack();
    Token<?> right = popStack();
    tokenStack.push(new Token<>(handleIn(left, right), Boolean.class));
>>>>>>> upstream/master
  }


  @Override
<<<<<<< HEAD
  public void exitLogicalFunc(PredicateParser.LogicalFuncContext ctx) {
    String funcName = ctx.getChild(0).getText();
    Predicate<List<String>> func;
=======
  public void exitNInExpression(PredicateParser.NInExpressionContext ctx) {
    Token<?> left = popStack();
    Token<?> right = popStack();
    tokenStack.push(new Token<>(!handleIn(left, right), Boolean.class));
  }

  @Override
  public void exitLogicalFunc(PredicateParser.LogicalFuncContext ctx) {
    String funcName = ctx.getChild(0).getText();
    Predicate<List<Object>> func;
>>>>>>> upstream/master
    try {
      func = LogicalFunctions.valueOf(funcName);
    }
    catch(IllegalArgumentException iae) {
      throw new ParseException("Unable to find logical function " + funcName + ".  Valid functions are "
              + Joiner.on(',').join(LogicalFunctions.values())
      );
    }
<<<<<<< HEAD
    PredicateToken<?> left = popStack();
    List<String> argList = null;
    if(left.getUnderlyingType().equals(List.class)) {
      argList = (List<String>) left.getValue();
=======
    Token<?> left = popStack();
    List<Object> argList = null;
    if(left.getValue() instanceof List) {
      argList = (List<Object>) left.getValue();
>>>>>>> upstream/master
    }
    else {
      throw new ParseException("Unable to process in clause because " + left.getValue() + " is not a set");
    }
    Boolean result = func.test(argList);
<<<<<<< HEAD
    tokenStack.push(new PredicateToken<>(result, Boolean.class));
  }

  @Override
  public void exitStringFunc(PredicateParser.StringFuncContext ctx) {
    String funcName = ctx.getChild(0).getText();
    Function<List<String>, String> func;
    try {
      func = StringFunctions.valueOf(funcName);
    }
    catch(IllegalArgumentException iae) {
      throw new ParseException("Unable to find string function " + funcName + ".  Valid functions are "
              + Joiner.on(',').join(StringFunctions.values())
      );
    }
    PredicateToken<?> left = popStack();
    List<String> argList = null;
    if(left.getUnderlyingType().equals(List.class)) {
      argList = (List<String>) left.getValue();
=======
    tokenStack.push(new Token<>(result, Boolean.class));
  }

  /**
   * {@inheritDoc}
   * <p/>
   * <p>The default implementation does nothing.</p>
   *
   * @param ctx
   */
  @Override
  public void exitTransformationFunc(PredicateParser.TransformationFuncContext ctx) {
    String funcName = ctx.getChild(0).getText();
    Function<List<Object>, Object> func;
    try {
      func = TransformationFunctions.valueOf(funcName);
    }
    catch(IllegalArgumentException iae) {
      throw new ParseException("Unable to find string function " + funcName + ".  Valid functions are "
              + Joiner.on(',').join(TransformationFunctions.values())
      );
    }
    Token<?> left = popStack();
    List<Object> argList = null;
    if(left.getUnderlyingType().equals(List.class)) {
      argList = (List<Object>) left.getValue();
>>>>>>> upstream/master
    }
    else {
      throw new ParseException("Unable to process in clause because " + left.getValue() + " is not a set");
    }
<<<<<<< HEAD
    String result = func.apply(argList);
    tokenStack.push(new PredicateToken<>(result, String.class));
  }

=======
    Object result = func.apply(argList);
    tokenStack.push(new Token<>(result, Object.class));
  }



>>>>>>> upstream/master
  @Override
  public void exitExistsFunc(PredicateParser.ExistsFuncContext ctx) {
    String variable = ctx.getChild(2).getText();
    boolean exists = resolver.resolve(variable) != null;
<<<<<<< HEAD
    tokenStack.push(new PredicateToken<>(exists, Boolean.class));
=======
    tokenStack.push(new Token<>(exists, Boolean.class));
>>>>>>> upstream/master
  }

  @Override
  public void exitNotFunc(PredicateParser.NotFuncContext ctx) {
<<<<<<< HEAD
    PredicateToken<Boolean> arg = (PredicateToken<Boolean>) popStack();
    tokenStack.push(new PredicateToken<>(!arg.getValue(), Boolean.class));
=======
    Token<Boolean> arg = (Token<Boolean>) popStack();
    tokenStack.push(new Token<>(!arg.getValue(), Boolean.class));
>>>>>>> upstream/master
  }

  public boolean getResult() throws ParseException {
    if(tokenStack.empty()) {
      throw new ParseException("Invalid predicate: Empty stack.");
    }
<<<<<<< HEAD
    PredicateToken<?> token = popStack();
=======
    Token<?> token = popStack();
>>>>>>> upstream/master
    if(token.getUnderlyingType().equals(Boolean.class) && tokenStack.empty()) {
      return (Boolean)token.getValue();
    }
    if(tokenStack.empty()) {
      throw new ParseException("Invalid parse, stack not empty: " + Joiner.on(',').join(tokenStack));
    }
    else {
      throw new ParseException("Invalid parse, found " + token + " but expected boolean");
    }
  }
}
