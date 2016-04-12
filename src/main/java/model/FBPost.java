package model;

import java.util.ArrayList;
import java.util.List;

import facebook4j.Facebook;
import facebook4j.Post;

public class FBPost {

	private String content;
	private String author;
	private List<FBComment> comments = new ArrayList<>();
	
	public FBPost(Facebook facebook, Post post) {
		post.getCaption();
//		post.get
	}
}
