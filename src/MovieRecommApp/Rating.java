package MovieRecommApp;

public class Rating {
    public int Uid;
    public int Mid;
    public int Rating;

    public Rating(int uid, int mid, int rating) {
        Uid = uid;
        Mid = mid;
        Rating = rating;
    }

    public int getUid() {
        return Uid;
    }

    public int getMid() {
        return Mid;
    }

    public int getRating() {
        return Rating;
    }
}
