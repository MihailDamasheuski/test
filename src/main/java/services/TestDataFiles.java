package services;

public enum TestDataFiles {


    IMAGE("Image.json"),
    VIDEO("VideoScmMsgs.json");


    String path;

    TestDataFiles(String path) {
        this.path = path;
    }

    public String getPath() {

        return ClassLoader.getSystemResource(path).getPath();
    }
}
