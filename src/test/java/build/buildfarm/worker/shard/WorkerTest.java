// Copyright 2017 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package build.buildfarm.worker.shard;

import build.buildfarm.common.config.BuildfarmConfigs;
import java.io.IOException;
import javax.naming.ConfigurationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class WorkerTest {
  private static BuildfarmConfigs configs = BuildfarmConfigs.getInstance();

  @Before
  public void setUp() throws IOException {
    configs.getWorker().setRoot(null);
    configs.getWorker().getCas().setPath(null);
  }

  @Test(expected = ConfigurationException.class)
  public void missingWorkerRoot() throws ConfigurationException {
    new Worker("test");
  }

  @Test(expected = ConfigurationException.class)
  public void missingCasCacheDirectory() throws ConfigurationException {
    new Worker("test");
  }
}
