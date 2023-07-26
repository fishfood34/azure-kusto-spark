package com.microsoft.kusto.spark.e2e.containers;

import com.dimafeng.testcontainers.GenericContainer
import com.dimafeng.testcontainers.GenericContainer.DockerImage

//class DatabricksContainer ( underlying: GenericContainer) extends GenericContainer.Def[DatabricksContainer]() {
//
//    private val DATABRICKS_IMAGE = "databricksruntime/dbfsfuse:experimental"
//}

//object DatabricksContainer {
//    case class Def(hostPort: Int)  extends GenericContainer.Def[DatabricksContainer] {
//
//        private static
//        final String DATABRICKS_IMAGE = "databricksruntime/standard";
//        public DatabricksContainer(
//        final String version
//        )
//        {
//            super (DATABRICKS_IMAGE + ":" + version);
//        }
//    }
//}