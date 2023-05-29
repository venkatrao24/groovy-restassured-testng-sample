class PayLoad {
    static String getPostPayLoadJson() {
        String post_data = "{\n" +
                "    \"location\":{\n" +
                "        \"lat\" : -38.383494,\n" +
                "        \"lng\" : 33.427362\n" +
                "    },\n" +
                "    \"accuracy\":50,\n" +
                "    \"name\":\"Frontline house\",\n" +
                "    \"phone_number\":\"(+91) 983 893 3937\",\n" +
                "    \"address\" : \"29, side layout, cohen 09\",\n" +
                "    \"types\": [\"shoe park\",\"shop\"],\n" +
                "    \"website\" : \"http://google.com\",\n" +
                "    \"language\" : \"French-IN\"\n" +
                "}"
        return post_data
    }

     static String getPostPayLoadXml() {
        String post_data = "{\n" +
                "    \"location\":{\n" +
                "        \"lat\" : -38.383494,\n" +
                "        \"lng\" : 33.427362\n" +
                "    },\n" +
                "    \"accuracy\":50,\n" +
                "    \"name\":\"Frontline house\",\n" +
                "    \"phone_number\":\"(+91) 983 893 3937\",\n" +
                "    \"address\" : \"29, side layout, cohen 09\",\n" +
                "    \"types\": [\"shoe park\",\"shop\"],\n" +
                "    \"website\" : \"http://google.com\",\n" +
                "    \"language\" : \"French-IN\"\n" +
                "}"
        return post_data
    }

    static String getSearchPathJson() {
        String postPath = "maps/api/place/nearbysearch/json"
        return postPath
    }

    static String getAddPlacePathJson() {
        String addPlacePath = "/maps/api/place/add/json"
        return addPlacePath
    }

    static String getDeletePathJson() {
        String deletePath = "/maps/api/place/delete/json"
        return deletePath
    }

    static String getSearchPathXml() {
        String postPath = "maps/api/place/nearbysearch/xml"
        return postPath
    }

    static String getAddPlacePathXml() {
        String addPlacePath = "/maps/api/place/add/xml"
        return addPlacePath
    }

    static String getDeletePathXml() {
        String deletePath = "/maps/api/place/delete/xml"
        return deletePath
    }

}

