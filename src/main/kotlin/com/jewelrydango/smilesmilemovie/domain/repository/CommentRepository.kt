package com.jewelrydango.smilesmilemovie.domain.repository

import com.jewelrydango.smilesmilemovie.domain.model.SmileComment

interface CommentRepository {

    fun saveComment(comment: SmileComment):Boolean;

    fun updateComment(comment: SmileComment): Boolean;

    fun findCommentListByNotViewed():List<SmileComment>;
}