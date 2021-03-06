/*
 * Copyright 2000-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jetbrains.python.refactoring.surround.surrounders.expressions;

import com.intellij.openapi.util.NlsSafe;
import com.jetbrains.python.psi.PyExpression;
import com.jetbrains.python.psi.PyStatement;
import com.jetbrains.python.psi.PyStatementListContainer;
import com.jetbrains.python.psi.PyWhileStatement;

public class PyWhileExpressionSurrounder extends PyExpressionAsConditionSurrounder {
  private static final @NlsSafe String TEMPLATE_DESCRIPTION = "while expr";

  @Override
  protected String getTextToGenerate() {
    return "while a:\n pass";
  }

  @Override
  protected PyExpression getCondition(PyStatement statement) {
    if (statement instanceof PyWhileStatement) {
      return ((PyWhileStatement)statement).getWhilePart().getCondition();
    }
    return null;
  }

  @Override
  protected PyStatementListContainer getStatementListContainer(PyStatement statement) {
    if (statement instanceof PyWhileStatement) {
      return ((PyWhileStatement)statement).getWhilePart();
    }
    return null;
  }

  @Override
  public String getTemplateDescription() {
    //noinspection DialogTitleCapitalization
    return TEMPLATE_DESCRIPTION;
  }
}
