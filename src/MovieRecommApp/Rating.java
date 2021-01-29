package MovieRecommApp;

public class Rating {
    public int Uid;
    public int Mid;
    public double Rating;

    public Rating(int uid, int mid, double rating) {
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

    public double getRating() {
        return Rating;
    }
}
