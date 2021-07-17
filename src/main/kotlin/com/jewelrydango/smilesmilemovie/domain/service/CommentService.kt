package com.jewelrydango.smilesmilemovie.domain.service

import com.jewelrydango.smilesmilemovie.domain.model.SmileComment
import com.jewelrydango.smilesmilemovie.domain.repository.CommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CommentService {

    @Autowired
    lateinit var commentRepository: CommentRepository;

    fun saveComment(comment: String, color: String): Boolean  {
        val comment = SmileComment(comment, color);

        this.commentRepository.saveComment(comment);
        return true;
    }

    fun findCommentListByNotViewed(): List<SmileComment> {
        val list: List<SmileComment> = this.commentRepository.findCommentListByNotViewed();
        list.map{
            val tmp = it;
            tmp.isViewed = true;
            this.commentRepository.updateComment(tmp);
        }
        return list;
    }
}