package sample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationWrapper {
        private String ip;
        private String type;
        private String continent_code;
        private String continent_name;
        private String country_code;
        private String country_name;
        private String region_code;
        private String region_name;
        private String city;
        private String zip;
        private float latitude;
        private float longitude;
        LocationObject LocationObject;


        // Getter Methods

        public String getIp() {
            return ip;
        }

        public String getType() {
            return type;
        }

        public String getContinent_code() {
            return continent_code;
        }

        public String getContinent_name() {
            return continent_name;
        }

        public String getCountry_code() {
            return country_code;
        }

        public String getCountry_name() {
            return country_name;
        }

        public String getRegion_code() {
            return region_code;
        }

        public String getRegion_name() {
            return region_name;
        }

        public String getCity() {
            return city;
        }

        public String getZip() {
            return zip;
        }

        public float getLatitude() {
            return latitude;
        }

        public float getLongitude() {
            return longitude;
        }

        public LocationObject getLocation() {
            return LocationObject;
        }

        // Setter Methods

        public void setIp(String ip) {
            this.ip = ip;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setContinent_code(String continent_code) {
            this.continent_code = continent_code;
        }

        public void setContinent_name(String continent_name) {
            this.continent_name = continent_name;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public void setCountry_name(String country_name) {
            this.country_name = country_name;
        }

        public void setRegion_code(String region_code) {
            this.region_code = region_code;
        }

        public void setRegion_name(String region_name) {
            this.region_name = region_name;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public void setLatitude(float latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(float longitude) {
            this.longitude = longitude;
        }

        public void setLocation(LocationObject locationObject) {
            this.LocationObject = locationObject;
        }
    }
@JsonIgnoreProperties(ignoreUnknown = true)

     class LocationObject {
        private float geoname_id;
        private String capital;

        ArrayList< Object > languages = new ArrayList < Object > ();
        private String country_flag;
        private String country_flag_emoji;
        private String country_flag_emoji_unicode;
        private String calling_code;
        private boolean is_eu;


        // Getter Methods

        public float getGeoname_id() {
            return geoname_id;
        }

        public String getCapital() {
            return capital;
        }

        public String getCountry_flag() {
            return country_flag;
        }

        public String getCountry_flag_emoji() {
            return country_flag_emoji;
        }

        public String getCountry_flag_emoji_unicode() {
            return country_flag_emoji_unicode;
        }

        public String getCalling_code() {
            return calling_code;
        }

        public boolean getIs_eu() {
            return is_eu;
        }

        // Setter Methods

        public void setGeoname_id(float geoname_id) {
            this.geoname_id = geoname_id;
        }

        public void setCapital(String capital) {
            this.capital = capital;
        }

        public void setCountry_flag(String country_flag) {
            this.country_flag = country_flag;
        }

        public void setCountry_flag_emoji(String country_flag_emoji) {
            this.country_flag_emoji = country_flag_emoji;
        }

        public void setCountry_flag_emoji_unicode(String country_flag_emoji_unicode) {
            this.country_flag_emoji_unicode = country_flag_emoji_unicode;
        }

        public void setCalling_code(String calling_code) {
            this.calling_code = calling_code;
        }

        public void setIs_eu(boolean is_eu) {
            this.is_eu = is_eu;
        }
    }

