/* **************************************************************************************
 * Copyright (c) 2021 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * MIT License which is available at https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 ************************************************************************************** */
package org.eclipse.keyple.core.distributed.local;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DistributedLocalApiPropertiesTest {

  private static String libVersion;

  @BeforeAll
  public static void beforeAll() throws Exception {
    InputStream inputStream = new FileInputStream("gradle.properties");
    try {
      Properties properties = new Properties();
      properties.load(inputStream);
      libVersion = properties.getProperty("version");
    } finally {
      inputStream.close();
    }
  }

  @Test
  public void versionIsCorrectlyWritten() {
    String apiVersion = DistributedLocalApiProperties.VERSION;
    assertThat(apiVersion).matches("\\d+\\.\\d+");
    assertThat(libVersion).startsWith(apiVersion);
  }
}
