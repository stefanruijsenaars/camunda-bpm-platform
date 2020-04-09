/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.test.bpmn.event.timer;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;
import org.camunda.bpm.engine.test.util.ProcessEngineBootstrapRule;
import org.camunda.bpm.engine.test.util.ProvidedProcessEngineRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Frederik Heremans
 */
public class BoundaryTimerEventFullHistoryTest {

  @Rule
  public ProcessEngineBootstrapRule bootstrapRule = new ProcessEngineBootstrapRule(
      "org/camunda/bpm/engine/test/standalone/history/fullhistory.camunda.cfg.xml");

  @Rule
  public ProvidedProcessEngineRule engineRule = new ProvidedProcessEngineRule(bootstrapRule);

  protected RuntimeService runtimeService;

  @Before
  public void setUp() {
    runtimeService = engineRule.getRuntimeService();
  }

  @Deployment
  @Test
  public void testSetProcessVariablesFromTaskWhenTimerOnTask() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("timerVariablesProcess");
    runtimeService.setVariable(processInstance.getId(), "myVar", 123456L);
  }

}
