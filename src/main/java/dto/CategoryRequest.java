package dto;

public class CategoryRequest {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "CategoryRequest{" +
                "title='" + title + '\'' +
                '}';
    }
}
