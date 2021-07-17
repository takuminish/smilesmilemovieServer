package com.jewelrydango.smilesmilemovie.infra.externalclient

import com.cloudant.client.api.ClientBuilder
import com.cloudant.client.api.Database
import com.cloudant.client.api.model.Response
import com.cloudant.client.api.query.Expression
import com.cloudant.client.api.query.QueryBuilder
import com.cloudant.client.api.query.QueryResult
import com.jewelrydango.smilesmilemovie.config.CloundantConfig
import com.jewelrydango.smilesmilemovie.domain.model.SmileComment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.net.URL
import javax.annotation.PostConstruct

@Component
class CloundantClient {

    private lateinit var db: Database;

    @Autowired
    lateinit var cloudantConfig: CloundantConfig;

    @PostConstruct
    fun createConnection() {
        val client = ClientBuilder.url( URL(this.cloudantConfig.url))
            .iamApiKey(this.cloudantConfig.apiKey)
            .build();
        this.db = client.database(this.cloudantConfig.dbName, false);
    }

    fun <T>query(query: String, classOfT: Class<T>): QueryResult<T> {
        return this.db.query(query, classOfT);
    }

    fun save(target: Any): Response {
        return this.db.save(target);
    }

    fun update(target: Any): Response {
        return this.db.update(target);
    }
}