/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.datatorrent.api;

import org.apache.apex.api.UserDefinedControlTuple;
import org.apache.hadoop.classification.InterfaceStability;

/**
 * A {@link Sink} which supports adding control tuples
 */
@InterfaceStability.Evolving
public interface ControlTupleEnabledSink<T> extends Sink<T>
{
  public static final ControlTupleEnabledSink<Object> BLACKHOLE = new ControlTupleEnabledSink<Object>()
  {
    @Override
    public void put(Object tuple)
    {
    }

    @Override
    public boolean putControl(UserDefinedControlTuple payload)
    {
      return true;
    }

    @Override
    public int getCount(boolean reset)
    {
      return 0;
    }
  };

  /**
   * Add a control tuple to the sink
   *
   * @param payload the control tuple payload
   */
  public boolean putControl(UserDefinedControlTuple payload);
}
