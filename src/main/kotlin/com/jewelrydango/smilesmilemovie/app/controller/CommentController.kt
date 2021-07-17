package com.jewelrydango.smilesmilemovie.app.controller

import com.cloudant.client.api.ClientBuilder
import com.cloudant.client.api.CloudantClient
import com.cloudant.client.api.query.Expression.eq
import com.cloudant.client.api.query.QueryBuilder
import com.cloudant.client.api.query.QueryResult
import com.jewelrydango.smilesmilemovie.app.model.SmileCommentForm
import com.jewelrydango.smilesmilemovie.config.CloundantConfig
import com.jewelrydango.smilesmilemovie.config.CommentConfig
import com.jewelrydango.smilesmilemovie.domain.model.SmileComment
import com.jewelrydango.smilesmilemovie.domain.service.CommentService
import com.jewelrydango.smilesmilemovie.infra.externalclient.CloundantClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.net.URL


@Controller
class CommentController {

    @Autowired
    lateinit var commenConfig: CommentConfig;

    @Autowired
    lateinit var commentService: CommentService;


    @GetMapping("/")
    fun index(): String? {
        return "index"
    }

    @PostMapping("/postComment")
    @ResponseBody
    fun postComment(@RequestBody smileCommentForm:SmileCommentForm): Boolean {
        return this.commentService.saveComment(smileCommentForm.comment, smileCommentForm.color);
    }

    @GetMapping("/comments")
    @ResponseBody
    fun getCommentListByNotViewed(@RequestParam token: String?): List<SmileComment> {
        if (token != this.commenConfig.token) {
            return listOf<SmileComment>()     ;
        }

        return this.commentService.findCommentListByNotViewed();
    }
}