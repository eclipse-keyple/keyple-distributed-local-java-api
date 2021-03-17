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
package org.eclipse.keyple.core.distributed.local;

import org.eclipse.keyple.core.common.KeyplePluginEvent;
import org.eclipse.keyple.core.common.KeypleReaderEvent;

/**
 * Manager associated to a {@link org.eclipse.keyple.core.distributed.local.spi.LocalServiceSpi}.
 *
 * @since 2.0
 */
public interface LocalServiceManager {

  /**
   * Must be invoked when a message is received from the remote plugin in order to execute a
   * specific command on a local reader.
   *
   * @param readerName The name of the targeted local reader.
   * @param jsonData A JSON string containing all information about the command to execute.
   * @return A JSON string containing the result of the command to send to the remote reader. It can
   *     be empty if the command returns nothing.
   * @throws IllegalArgumentException If the provided reader name or the JSON data are null or empty
   *     or if the JSON data is malformed.
   * @throws IllegalStateException If there is no local reader registered with the provided name.
   * @since 2.0
   */
  String executeLocally(String readerName, String jsonData);

  /**
   * Indicates if a specific local reader is observable.
   *
   * @param readerName The name of the local reader to check.
   * @return true if the local reader is observable, otherwise false.
   * @throws IllegalArgumentException If the provided reader name is null or empty.
   * @throws IllegalStateException If there is no local reader registered with the provided name.
   * @since 2.0
   */
  boolean isReaderObservable(String readerName);

  /**
   * Starts to observe a specific observable local reader if it is not already observed.
   *
   * <p>The method {@link
   * org.eclipse.keyple.core.distributed.local.spi.LocalServiceSpi#onReaderEvent(String, String,
   * KeypleReaderEvent)} will be invoked when a {@link
   * org.eclipse.keyple.core.common.KeypleReaderEvent} event occurs.
   *
   * @param readerName The name of the observable local reader to observe.
   * @throws IllegalArgumentException if the provided reader name is null or empty.
   * @throws IllegalStateException If there is no local reader registered with the provided name or
   *     if the local reader is not observable.
   * @since 2.0
   */
  void startReaderObservation(String readerName);

  /**
   * Stops to observe a specific observable local reader if it is registered and observed.
   *
   * @param readerName The name of the observable local reader to stop observing.
   * @throws IllegalArgumentException if the provided reader name is null or empty.
   * @since 2.0
   */
  void stopReaderObservation(String readerName);

  /**
   * Starts to observe all observable local plugins.
   *
   * <p>The method {@link
   * org.eclipse.keyple.core.distributed.local.spi.LocalServiceSpi#onPluginEvent(String, String,
   * KeyplePluginEvent)} will be invoked when a {@link
   * org.eclipse.keyple.core.common.KeyplePluginEvent} event occurs.
   *
   * @throws IllegalStateException If there is no observable local plugin.
   * @since 2.0
   */
  void startPluginsObservation();

  /**
   * Stops to observe all observable local plugins if they are registered and observed.
   *
   * @since 2.0
   */
  void stopPluginsObservation();

  /**
   * Specifies the names of the local pool plugins to manage.
   *
   * <p>This feature is only useful for remote control of pool plugins.
   *
   * @param poolPluginNames The list of names of the local pool plugins to manage.
   * @throws IllegalArgumentException If the provided list is null or empty.
   * @since 2.0
   */
  void setPoolPluginNames(String... poolPluginNames);
}
