/* **************************************************************************************
 * Copyright (c) 2021 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 ************************************************************************************** */
package org.eclipse.keyple.core.distributed.local.spi;

import org.eclipse.keyple.core.distributed.local.LocalServiceApi;

/**
 * Distributed local service extension able to communicate with a distributed remote plugin
 * extension.
 *
 * @since 2.0.0
 */
public interface LocalServiceSpi {

  /**
   * Connects the associated Keyple Core {@link LocalServiceApi} API.
   *
   * @param localServiceApi The API to connect.
   * @since 2.0.0
   */
  void connect(LocalServiceApi localServiceApi);

  /**
   * Gets the name of the distributed local service extension.
   *
   * @return A not empty string.
   * @since 2.0.0
   */
  String getName();

  /**
   * Exchanges the JSON API levels between the Keyple Core and Distributed layers.
   *
   * @param coreApiLevel The JSON API level of the Core layer.
   * @return The JSON API level of the Distributed layer.
   * @since 2.1.0
   */
  int exchangeApiLevel(int coreApiLevel);

  /**
   * Invoked when a plugin event occurs in order to be forwarded to the remote plugin.
   *
   * <p>This method will only be invoked if the start reader detection functional method has been
   * previously invoked in order to activate the observation of all local plugins.
   *
   * @param readerName The name of the associated local reader.
   * @param jsonData The plugin event as a JSON data to forward to the remote plugin.
   * @since 2.0.0
   */
  void onPluginEvent(String readerName, String jsonData);

  /**
   * Invoked when a reader event occurs in order to be forwarded to the remote plugin.
   *
   * <p>This method will only be invoked if the start cart detection functional method has been
   * previously invoked in order to activate the observation of a specific local reader.
   *
   * @param readerName The name of the associated local reader.
   * @param jsonData The reader event as a JSON data to forward to the remote plugin.
   * @since 2.0.0
   */
  void onReaderEvent(String readerName, String jsonData);
}
