import React from "react";
import Comment from "./Comment";


const comments = [
    {
        name: "첫번째다 이그야",
        comment: "안녕하세요...."
    },
    {
        name: "두번째다 이그야",
        comment: "두번째 안녕이요"
    },
    {
        name: "세번째다 이그야",
        comment: "세번째 안녕",
    },
];


function CommentList(props){
    return(
        <div>
            {comments.map((comment) => {
                return(
                    <Comment name={comment.name} comment={comment.comment}/>
                );
            })}
        </div>
    );
}

export default CommentList;