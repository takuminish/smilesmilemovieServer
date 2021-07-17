package com.jewelrydango.smilesmilemovie.infra.repository

import com.cloudant.client.api.ClientBuilder
import com.cloudant.client.api.Database
import com.cloudant.client.api.model.Response
import com.cloudant.client.api.query.Expression
import com.cloudant.client.api.query.QueryBuilder
import com.jewelrydango.smilesmilemovie.config.CloundantConfig
import com.jewelrydango.smilesmilemovie.domain.model.SmileComment
import com.jewelrydango.smilesmilemovie.domain.repository.CommentRepository
import com.jewelrydango.smilesmilemovie.infra.externalclient.CloundantClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.net.URL

@Repository
class CommentRepositoryImpl : CommentRepository{

    @Autowired
    lateinit var cloudantClient: CloundantClient;

    override fun saveComment(comment: SmileComment): Boolean {
        val response:Response =  this.cloudantClient.save(comment);
        System.out.println(response.toString());

        return true;
    }

    override fun findCommentListByNotViewed(): List<SmileComment> {
        return this.cloudantClient.query(QueryBuilder(Expression.eq("isViewed", false)).build(), SmileComment::class.java).docs;
    }


}