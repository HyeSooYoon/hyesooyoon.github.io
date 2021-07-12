package com.sprayou.spray.dto; 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter; 

public class VendorDto {
 
        @Getter
        @AllArgsConstructor
        @Builder
        public static class Info {
            private String lastBuildDate; 
            private String postdate;
            private int total;
            private int start;
            private int display;
            private int item;
            private int items;
            private String title;
            private String link;
            private String description;
            private String bloggername;
            private String bloggerlink;

        }
 
 
}
