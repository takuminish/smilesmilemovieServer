package com.jewelrydango.smilesmilemovie.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.expression.spel.ast.StringLiteral
import org.springframework.stereotype.Component

@Configuration
@ConfigurationProperties(prefix="cloudant")
class CloundantConfig {
     var url: String = "";
     var apiKey: String = "";
     var dbName: String = "";
}