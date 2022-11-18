/**
 * 
 */
package prj5;

/**
 * @author Devon
 *
 */
public class Influencer {
    private String month;
    private String influencerUsername;
    private String channelName;
    private String country;
    private String mainTopic;
    private int likes;
    private int post;
    private int followers;
    private int comments;
    private int views;

    public Influencer(
        String month,
        String username,
        String channelName,
        String country,
        String mainTopic,
        int likes,
        int post,
        int followers,
        int comments,
        int views) {
        this.month = month;
        this.influencerUsername = username;
        this.channelName = channelName.toLowerCase();
        this.country = country;
        this.mainTopic = mainTopic;
        this.likes = likes;
        this.post = post;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
    }

    // getter methods


    public String getMonth() {
        return this.month;
    }


    public String getUsername() {
        return this.influencerUsername;
    }


    public String getChannelName() {
        return this.channelName;
    }


    public String getCountry() {
        return this.country;
    }


    public String getMainTopic() {
        return this.mainTopic;
    }


    public int getLikes() {
        return this.likes;
    }


    public int getPosts() {
        return this.post;
    }


    public int getFollowers() {
        return this.followers;
    }


    public int getComments() {
        return this.comments;
    }


    public int getViews() {
        return this.views;
    }


    public int getTotalEngagement() {
        // sum of all interactions (comments and likes)
        return comments + likes;
    }


    public int traditionalEngagement() {
        return (getTotalEngagement() / getFollowers()) * 100;

    }


    public int reachEngagement() {
        return (getTotalEngagement() / getViews()) * 100;

    }
}
