/* **************************************************************************************
 * Copyright (c) 2021 Calypso Networks Association https://www.calypsonet-asso.org/
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

import org.eclipse.keyple.core.common.KeyplePluginEvent;
import org.eclipse.keyple.core.common.KeypleReaderEvent;
import org.eclipse.keyple.core.distributed.local.LocalServiceApi;

/**
 * Distributed local service extension able to communicate with a distributed remote plugin
 * extension.
 *
 * @since 2.0
 */
public interface LocalServiceSpi {

  /**
   * Connects the associated Keyple Core {@link LocalServiceApi} API.
   *
   * @param LocalServiceApi The API to connect.
   * @since 2.0
   */
  void connect(LocalServiceApi LocalServiceApi);

  /**
   * Gets the name of the distributed local service extension.
   *
   * @return A not empty string.
   * @since 2.0
   */
  String getName();

  /**
   * Invoked when a {@link KeyplePluginEvent} event occurs in order to be forwarded to the remote
   * plugin.
   *
   * @param readerName The name of the associated local reader.
   * @param jsonData The plugin event as a JSON data to forward to the remote plugin.
   * @param pluginEvent The plugin event.
   * @since 2.0
   */
  void onPluginEvent(String readerName, String jsonData, KeyplePluginEvent pluginEvent);

  /**
   * Invoked when a {@link KeypleReaderEvent} event occurs in order to be forwarded to the remote
   * plugin.
   *
   * @param readerName The name of the associated local reader.
   * @param jsonData The reader event as a JSON data to forward to the remote plugin.
   * @param readerEvent The reader event.
   * @since 2.0
   */
  void onReaderEvent(String readerName, String jsonData, KeypleReaderEvent readerEvent);
}
