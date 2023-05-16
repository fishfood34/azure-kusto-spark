package com.microsoft.kusto.spark.it.containers

import org.testcontainers.containers.{GenericContainer, Network}

class DatabricksContainer(final val dockerImageName: String) extends GenericContainer[DatabricksContainer](dockerImageName) {
  val DB_IMAGE_NAME: String = "ubuntu/squid"
  val PROXY_PORT: Int = 3128


  override def withNetwork(network: Network): DatabricksContainer = {
    super.withNetwork(network).withExposedPorts(PROXY_PORT)
  }
}

