package utils.json.utils;

public enum PathFields {
    ENTRY("entry"),
    EXTERNAL_SOURCE("externalSource"),
    ACTION("action"),
    HEADLINE("headline"),
    TITLE("title"),
    NID("nid"),
    TYPE("type"),
    CREATED("created"),
    REVISION_TIMESTAMP("revision_timestamp"),
    HIDDEN("hidden"),
    LABEL("label"),
    LAYOUT("layout"),
    PUBLICATION_DATE("publication_date"),
    CONTENT("content"),
    LINK("link"),
    IMAGES("images"),
    URL("url"),
    FID("fid");

    private String field;

    /**
     *
     * @param field string value of Enum constant
     */
    PathFields(String field) {
        this.field = field;
    }

    /**
     *
      * @return String value of Enum constant
     */
    public String field(){
        return this.field;
    }

}
