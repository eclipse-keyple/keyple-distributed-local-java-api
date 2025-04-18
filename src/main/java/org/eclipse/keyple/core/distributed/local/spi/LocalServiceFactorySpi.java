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
package org.eclipse.keyple.core.distributed.local.spi;

/**
 * Factory of {@link LocalServiceSpi}.
 *
 * @since 2.0.0
 */
public interface LocalServiceFactorySpi {

  /**
   * Gets the distributed local's API version used at compile time.
   *
   * @return A not empty string.
   * @since 2.0.0
   */
  String getDistributedLocalApiVersion();

  /**
   * Gets the common's API version used at compile time.
   *
   * @return A not empty string.
   * @since 2.0.0
   */
  String getCommonApiVersion();

  /**
   * Retrieves the name of the distributed local service that will be instantiated by this factory.
   *
   * @return A not empty string.
   * @since 2.0.0
   */
  String getLocalServiceName();

  /**
   * Retrieves an instance of a distributed local service SPI (can be a singleton or not).
   *
   * @return A not null reference.
   * @since 2.0.0
   */
  LocalServiceSpi getLocalService();
}
