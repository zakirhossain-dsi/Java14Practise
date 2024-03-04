package com.cefalo.mentor.etl;

public class QueryDSLCreator {
    public static void main(String[] args) {
        String ids = "408,731";
        StringBuilder queryBuilder = new StringBuilder();

        for(String id : ids.split(",")){
            queryBuilder.append(
                    String.format("{\"match_phrase\":{\"content-id\":\"%s\"}},", id));
                    //String.format("\"%s\" or ", id));
        }
        System.out.println(queryBuilder.toString());
    }
}
