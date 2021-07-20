package com.jewelrydango.smilesmilemovie.app.controller

import com.jewelrydango.smilesmilemovie.app.model.SaveSmileCommentRequest
import com.jewelrydango.smilesmilemovie.config.CommentConfig
import com.jewelrydango.smilesmilemovie.domain.model.SmileComment
import com.jewelrydango.smilesmilemovie.domain.service.CommentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


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
    fun postComment(@RequestBody @Validated saveSmileCommentRequest:SaveSmileCommentRequest, bindingResult:BindingResult): Boolean {
        System.out.println(saveSmileCommentRequest)
        if(bindingResult.hasErrors()) {
            System.out.println("error");
        }
        return this.commentService.saveComment(saveSmileCommentRequest.comment, saveSmileCommentRequest.color);
    }

    @GetMapping("/comments")
    @ResponseBody
    @CrossOrigin
    fun getCommentListByNotViewed(@RequestParam token: String?): List<SmileComment> {
        if (token != this.commenConfig.token) {
            return listOf<SmileComment>()     ;
        }

        return this.commentService.findCommentListByNotViewed();
    }
}