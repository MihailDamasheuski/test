package services;

public enum TestDataFiles {


    IMAGE("Image.json");


    String path;

    TestDataFiles(String path) {
        this.path = path;
    }

    public String getPath() {

        return ClassLoader.getSystemResource(path).getPath();
    }
}
