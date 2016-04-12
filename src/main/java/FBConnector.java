import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import facebook4j.Account;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.GeoLocation;
import facebook4j.Like;
import facebook4j.Location;
import facebook4j.PagableList;
import facebook4j.Page;
import facebook4j.Post;
import facebook4j.RawAPIResponse;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.auth.AccessToken;
import facebook4j.internal.org.json.JSONObject;
import model.FBPage;

public class FBConnector {

	private Facebook facebook = null;

	public static void main(String[] args) {
		FBConnector fbConnector = new FBConnector();
	}

	public FBConnector() {
		this.facebook = new FacebookFactory().getInstance();

		this.facebook.setOAuthAppId("17502271978", "aadb7e3676b821feb1eb9114c493c55a");
		// facebook.setOAuthPermissions(commaSeparetedPermissions);
		try {
			facebook.setOAuthAccessToken(facebook.getOAuthAppAccessToken());
		} catch (FacebookException e1) {
			System.err.println(e1.getMessage());
		}
		

		try {
			ResponseList<Page> results = facebook.searchPages("T'es de Sion si", new Reading().limit(10));
			System.out.println("Count : " + results.size());
			for (Page page : results) {
				
				new FBPage(facebook, page.getId());
				
//				System.out.println("Page : " + page.getName());
//				
//				Gson gson = new GsonBuilder().setPrettyPrinting().create();
//				System.out.println(gson.toJson(page));
//				return;
				
//				ResponseList<Post> posts = facebook.getFeed(page.getId(), new Reading().limit(5));
//				for (Post post : posts) {
//					ResponseList<Like> a = facebook.getPostLikes(post.getId(), new Reading().limit(1000));
//					
//					System.out.println("Nb Like : " + a.size());
//					System.out.println("Picture : " + post.getLink());
//					System.out.println("----");
//					
//				}
			}
		} catch (FacebookException e) {
			System.err.println(e.getMessage());
		}

	}
}
