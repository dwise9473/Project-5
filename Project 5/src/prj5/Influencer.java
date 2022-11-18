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
        this.channelName = channelName;
        this.country = country;
        this.mainTopic = mainTopic;
        this.likes = likes;
        this.post = post;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
    }
    // getter methods
}
