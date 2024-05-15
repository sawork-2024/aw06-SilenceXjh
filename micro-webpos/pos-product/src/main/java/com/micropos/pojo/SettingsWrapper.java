package com.micropos.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SettingsWrapper {

    private int _id;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Settings {
        private String app;
        private String store;
        private String address_one;
        private String address_two;
        private String contact;
        private String tax;
        private String symbol;
        private String percentage;
        private String footer;
        private String img;
    }
    private Settings settings;

    private String id;
}
