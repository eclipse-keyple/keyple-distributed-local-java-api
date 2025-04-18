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

/**
 * API associated to a {@link org.eclipse.keyple.core.distributed.local.spi.LocalServiceSpi}.
 *
 * @since 2.0.0
 */
public interface LocalServiceApi {

  /**
   * Returns true if the reader is contactless.
   *
   * <p>This feature is only useful for the <b>Reader Client Side</b> usage mode. The aim is to
   * enable the local service to immediately retrieve the information in order to send it to the
   * server at the time of the remote service's execution request.
   *
   * @param readerName The name of the reader to check.
   * @return True if the reader is contactless
   * @throws IllegalStateException If the service or the reader is no longer registered.
   * @since 2.2.0
   */
  boolean isReaderContactless(String readerName);

  /**
   * Specifies the names of the local pool plugins to manage.
   *
   * <p>This feature is only useful for remote control of pool plugins.
   *
   * @param poolPluginNames The list of names of the local pool plugins to manage.
   * @throws IllegalStateException If the service is no longer registered.
   * @since 2.0.0
   */
  void setPoolPluginNames(String... poolPluginNames);

  /**
   * Must be invoked when a message is received from the network remote side in order to invoke a
   * specific service locally.
   *
   * @param jsonData A JSON string containing all information about the service to invoke.
   * @param readerName The name of the targeted local reader (optional). It is required if the
   *     service is specific to a particular reader.
   * @return A JSON string containing the result of the service to send back to the network remote
   *     side. It can be empty if the service returns nothing.
   * @throws IllegalStateException If the service or the reader or the associated plugin is no
   *     longer registered.
   * @since 2.0.0
   */
  String executeLocally(String jsonData, String readerName);
}
