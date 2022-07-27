package com.target.controller.collectdata;

// import twitter sdk
import com.twitter.clientlib.TwitterCredentialsOAuth2;
import com.twitter.clientlib.ApiException;
import com.twitter.clientlib.api.TwitterApi;
import com.twitter.clientlib.model.*;

public class collectdata {

    // twitter oauth2
    public static void twitter_oauth2() {
        TwitterCredentialsOAuth2 twitterCredentialsOAuth2 = new TwitterCredentialsOAuth2(
                "consumer_key",
                "consumer_secret",
                "access_token",
                "access_token_secret");
        TwitterApi twitterApi = new TwitterApi(twitterCredentialsOAuth2);
        try {
            User user = twitterApi.getUserApi().showUser("target");
            System.out.println(user.getName());
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

    // find twiteet by hashtag
    public static void findtweetbyhashtag() {
        twitter_oauth2();
        try {
            List<Tweet> tweets = twitterApi.getSearchApi().search("#devops");
            for (Tweet tweet : tweets) {
                System.out.println(tweet.getText());
            }
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }

}
