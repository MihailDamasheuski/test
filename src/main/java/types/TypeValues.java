package types;

public enum TypeValues {

    POST("post"),
    IMAGE("image");

    private String type;

    TypeValues(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
