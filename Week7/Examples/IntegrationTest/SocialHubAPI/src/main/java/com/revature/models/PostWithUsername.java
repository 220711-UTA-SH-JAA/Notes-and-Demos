package com.revature.models;

import java.sql.Date;

public class PostWithUsername {

    /*
        The entire purpose of this class is so we can send back the username in the post, because we are jsonignoring the user

     */

    public int postId;

    public String content;

    public String username;

    public Date postedDate;

    public PostWithUsername(int postId, String content, String username, Date postedDate) {
        this.postId = postId;
        this.content = content;
        this.username = username;
        this.postedDate = postedDate;
    }
}
