package com.microsoft.kusto.spark.it

import org.apache.commons.io.FilenameUtils
import org.apache.commons.lang3.StringUtils

import java.util.UUID

object  ITSetup {
  private[it] def getConnectorProperties = {
    val testPrefix = "tmpSparkSinkIT_"
    val appId = getProperty("kustoAadAppId", "", sanitize = false)
    val appKey = getProperty("kustoAadAppSecret", "", sanitize = false)
    val authority = getProperty("kustoAadAuthorityID", "", sanitize = false)
    val cluster = getProperty("kustoCluster", "", sanitize = false)
    val database = getProperty("kustoDatabase", "e2e", sanitize = true)
    val defaultTable = testPrefix + UUID.randomUUID.toString.replace('-', '_')
    val table = getProperty("table", defaultTable, sanitize = true)
    ITCoordinates(appId, appKey, authority, cluster, database, table)
  }

  private def getProperty(attribute: String, defaultValue: String, sanitize: Boolean) = {
    val returnValue = sys.env.getOrElse(attribute, getPropertyFromSystemProperties(attribute, defaultValue))
    if (sanitize) FilenameUtils.normalize(returnValue) else returnValue
  }

  private def getPropertyFromSystemProperties(attribute: String, defaultValue: String):String = {
    val value = System.getProperty(attribute)
    if(StringUtils.isEmpty(value))  defaultValue else value
  }
}