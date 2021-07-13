package com.jewelrydango.smilesmilemovie.app

import com.jewelrydango.smilesmilemovie.domain.model.SmileComment
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
class CommentController {

    @GetMapping("/")
    fun index(): String? {
        return "index"
    }

    @PostMapping("/postComment")
    @ResponseBody
    fun postComment(@RequestBody smileComment:SmileComment): String {
        System.out.println(smileComment.comment);
        System.out.println(smileComment.color);
        return "成功";
    }
}