package features.java;

public class Test {
    public static void main(String[] args) {
        String newUrls[] = {
                 "http://w.morgenbladet.no/sites/morgenbladet.no/files/a.jpg"
                ,"http://w.morgenbladet.no/sites/morgenbladet.no/files/images/a.jpg"
                ,"http://w.morgenbladet.no/sites/default/files/a.jpg"
                ,"https://morgenbladet.no/sites/default/files/a.jpg"
                ,"http://w.morgenbladet.no/sites/default/files/styles/large/public/aarets_beste-kulturomslag/a.jpeg?itok=OSDbBZbR"
        };

        String imageUris[] = {
                 "http://w.morgenbladet.no/sites/default/files/a.jpeg"
                ,"http://w.morgenbladet.no/sites/default/files/archive/a.jpg"
                ,"http://w.morgenbladet.no/sites/default/files/archive_087/a.jpg"
                ,"http://w.morgenbladet.no/sites/default/files/images/a.jpg"
                ,"http://w.morgenbladet.no/sites/default/files/archive_110clkasfkasdfj/a.jpg"
                ,"http://w.morgenbladet.no/sites/default/files/archive_123/a.jpg"
                ,"http://w.morgenbladet.no/sites/default/files/images/a.jpg"
                ,"https://morgenbladet.no/sites/default/files/images/a.jpg"
                ,"http://w.morgenbladet.no/sites/default/files/styles/large/public/aarets_beste-kulturomslag/a.jpeg"
        };

        for(String newUrl : newUrls){
            var purgedNewUrl = newUrl
                    .replaceFirst("https://morgenbladet.no", "http://w.morgenbladet.no")
                    .replaceFirst("/default/", "/morgenbladet.no/")
                    .replaceFirst("/images", "")
                    .replaceFirst(".jpeg", ".jpg")
                    .replaceFirst("\\?.+", "");


            for(String imageUri : imageUris){
                var purgedImgUri = imageUri
                        .replaceFirst("https://morgenbladet.no", "http://w.morgenbladet.no")
                        .replaceFirst("/archive[^/]*", "")
                        .replaceFirst("/default/", "/morgenbladet.no/")
                        .replaceFirst("/images", "")
                        .replaceFirst(".jpeg", ".jpg")
                        .replaceFirst("\\?.+", "");
                System.out.println(String.format("%s %s %b", purgedNewUrl, purgedImgUri, purgedNewUrl.equalsIgnoreCase(purgedImgUri)));
            }
        }





    }
}



