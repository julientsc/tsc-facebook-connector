package model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Page;
import facebook4j.Post;

public class FBPage {
	private String name;
	private String id;
	private String category;
	
	private List<FBPost> posts = new ArrayList<>();
	
	public FBPage(Facebook facebook, String id) throws FacebookException {
		this.id = id;
		
		Page page = facebook.getPage(id);
		this.name = page.getName();
		this.category = page.getCategory();
		
		for(Post post : facebook.getFeed(page.getId())) {
//			System.out.println(post.getFullPicture());
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println(post);
		}
		
	}
}
