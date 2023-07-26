package com.microsoft.kusto.spark.e2e;

import com.dimafeng.testcontainers.scalatest.TestContainerForAll
import com.dimafeng.testcontainers.{ForAllTestContainer, GenericContainer}
import com.sun.tools.javac.jvm.Gen
import org.scalatest.flatspec.AnyFlatSpec
import org.testcontainers.containers.Network
import org.testcontainers.utility.DockerImageName

import java.io.IOException
import java.net.URL
import scala.io.Source;

class KustoSinkE2ETests extends AnyFlatSpec with TestContainerForAll {

    override val containerDef = GenericContainer.Def("databricksruntime/dbfsfuse:experimental",
        exposedPorts = Seq(4566))

    "GenericContainer" should "start and expose 80 port" in {
        withContainers { container =>

            container.execInContainer("spark-submit\",\n" +
              "                            \"--jars\", \"connector/target/kusto-spark_3.0_2.12-4.0.2-jar-with-dependencies.jar\",\n" +
              "                            \"--master\", \"local\",\n" +
              "                            \"http://localstack:4566\"")

        }
    }
}
