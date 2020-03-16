<!DOCTYPE html>
<html lang="zh-CN" ng-app="app">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Comment System</title>
    <link rel="stylesheet" href="/statics/bootstrap.min.css">
    <link rel="stylesheet" href="/statics/css/index.css">
    <script src="/statics/js/jquery.min.js"></script>
    <script src="/statics/js/bootstrap.min.js"></script>
    <script src="/statics/js/angular.js"></script>
    <script src="/statics/js/comment.js"></script>
</head>

<body ng-controller="mainController">
<div class="alert alert-warning hintDiv" id="hintDiv">
    <strong>评论不能为空</strong>
</div>

<div class="container" data-ng-repeat="commentSaying in data">
    <div class="col-sm-8 " >
        <div class="commentSaying">
            <div class="meta-top">
                <!--avatar-->
                <a href="javascript:void(0);">
                    <img class="avatar" ng-src="{{commentSaying.avatar}}">
                </a>
                <!--nickname-->
                <p class="author">
                    <a class="name" href="javascript:void(0);">{{commentSaying.author}}</a>
                </p>
                <!--create time-->
                <span class="publish-time">{{commentSaying.createTime}}</span>
            </div>
            <!--content-->
            <p class="content">{{commentSaying.sayingContent}}</p>
        </div>

        <div class="comment-footer clearfix">
            <a class="like pull-left" href="javascript:void(0);" ng-click="like(commentSaying,commentSaying.id)">
                <span ng-if="saying.isShowLike" class="glyphicon glyphicon-heart"></span>
                <span ng-if="!saying.isShowLike" class="glyphicon glyphicon-heart-empty"></span>
                <span>喜欢({{commentSaying.likes.length}})</span>
            </a>
            <a href="javascript:void(0);" ng-if="commentSaying.isAuthor" ng-click="delete(commentSaying.id)">
                <span class="glyphicon glyphicon-trash"></span>
                <span>删除</span>
            </a>
        </div>

        <div class="commment-head">
            <span class="pull-left" style="margin-top:0px;">
              {{commentSaying.flcs.length}}条评论
            </span>
            <a class="like" href="javascript:void(0);" ng-click="showComment(commentSaying)">
                <span class="glyphicon glyphicon-pencil"></span>
                <span>添加新评论</span>
            </a>
        </div>
        <!--comment text-->
        <form id="comment" ng-if='commentSaying.isShowComment' novalidate>
            <div class="comment-text">
                <textarea autofocus placeholder="写下你的评论…" maxlength="2000" ng-model="cmt.fstlvlcmt"></textarea>
                <div style="text-align:right;">
                    <button class="btn btn-sm btn-default" style="float:left;" ng-click="showComment(commentSaying)">取消</button>
                    <button class="btn btn-sm btn-info" ng-click="firstComment(commentSaying.id,commentSaying)">提交</button>
                </div>
            </div>
        </form>

        <div class="comment-list">
            <!--first level comment-->
            <div class="first-level" ng-repeat="comment in commentSaying.flcs">
                <div class="meta-top">
                    <a href="javascript:void(0);">
                        <img class="avatar" ng-src="{{comment.avatar}}">
                    </a>
                    <p class="author">
                        <a class="name" href="javascript:void(0);">{{comment.commenter}}</a>
                    </p>
                    <div class="comment-footer clearfix">
                        <span class="publish-time pull-left" style="margin-top:0px;">{{comment.commentTime}}</span>
                        <a ng-if="comment.commenter == user.username" class="like delete" href="javascript:void(0);" ng-click="deletefslcmt(commentSaying.id, comment.id)">
                            <span>删除</span>
                        </a>
                        <a class="like delete-reply" href="javascript:void(0);" ng-click="showSecondComment(comment, comment.commenter)">
                            <span>回复</span>
                        </a>
                    </div>
                </div>
                <p class="content">{{comment.commentContent}}</p>

                <!--second level comment-->
                <div class="second-level" ng-repeat="childComment in comment.slcs">
                    <p class="reply">
                        <a href="javascript:void(0);" class="blue-link">{{childComment.replier}}</a>:
                        <a href="javascript:void(0);" class="blue-link">@{{childComment.toCommenter}}</a>
                        <span>{{childComment.replyContent}}</span>
                    </p>
                    <div class="comment-footer clearfix">
                  <span class="publish-time pull-left" style="margin-top:0px;">
                    {{childComment.replyTime}}
                  </span>
                        <a ng-if="childComment.replier == user.username" class="like delete" href="javascript:void(0);" ng-click="deletescndcmt(commentSaying.id, comment.id, childComment.id)">
                            <span>删除</span>
                        </a>
                        <a class="like delete-reply" href="javascript:void(0);" ng-click="showSecondComment(comment, childComment.replier)">
                            <span>回复</span>
                        </a>
                    </div>
                </div>

                <form id="childComment" ng-if="comment.isShowChildComment" novalidate>
                    <div class="comment-text">
                        <textarea autofocus maxlength="2000" ng-model="comment.scndlvlcmt"></textarea>
                        <div style="text-align:right;">
                            <button class="btn btn-sm btn-default" style="float:left;" ng-click="hideSecondComment(comment)">取消</button>
                            <button class="btn btn-sm btn-info" ng-click="reply(commentSaying.id, comment)">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="modal fade" id="delete1" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        Delete
                    </h4>
                </div>
                <div class="modal-body">
                    确定删除评论?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-danger" ng-click="confirmDel()">确认</button>
                </div>
            </div><!-- /.modal-content -->
        </div>
    </div><!-- /.modal -->

    <div class="modal fade" id="commentModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        Delete
                    </h4>
                </div>
                <div class="modal-body">
                    确定删除评论?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-danger" ng-click="confirm()">确认</button>
                </div>
            </div><!-- /.modal-content -->
        </div>
    </div><!-- /.modal -->

    <div class="modal fade" id="slcModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close"
                            data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        Delete
                    </h4>
                </div>
                <div class="modal-body">
                    确定删除评论?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-danger" ng-click="confirmSlc()">确认</button>
                </div>
            </div><!-- /.modal-content -->
        </div>
    </div><!-- /.modal -->
</div>
<div class="container">
    <div class="col-sm-8">
        <form id="commentForm"  novalidate>
            <div class="comment-text">
                <textarea autofocus placeholder="写下你的评论…" maxlength="2000" ng-model="cmt.fstlvlcmt2"></textarea>
                <div style="text-align:right;">
                    <button class="btn btn-sm btn-info" ng-click="Comment()">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>