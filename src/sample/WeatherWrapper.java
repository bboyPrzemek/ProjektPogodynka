package sample;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherWrapper {

    private List<Datum> data = null;
    private String cityName;
    private String lon;
    private String timezone;
    private String lat;
    private String countryCode;
    private String stateCode;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
@JsonIgnoreProperties(ignoreUnknown = true)
class Datum {

    private Integer moonriseTs;
    private String windCdir;
    private Integer rh;
    private Float pres;
    private Integer sunsetTs;
    private Float ozone;
    private Float moonPhase;
    private Float windGustSpd;
    private Integer snowDepth;
    private Integer clouds;
    private Integer ts;
    private Integer sunriseTs;
    private Float appMinTemp;
    private Float windSpd;
    private Integer pop;
    private String windCdirFull;
    private Float slp;
    private Float appMaxTemp;
    private Float vis;
    private Float dewpt;
    private Integer snow;
    private Float uv;
    private String validDate;
    private Integer windDir;
    private Object maxDhi;
    private Integer cloudsHi;
    private Float precip;
    private Weather weather;
    private Float maxTemp;
    private Integer moonsetTs;
    private String datetime;
    private Float temp;
    private Float minTemp;
    private Integer cloudsMid;
    private Integer cloudsLow;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getMoonriseTs() {
        return moonriseTs;
    }

    public void setMoonriseTs(Integer moonriseTs) {
        this.moonriseTs = moonriseTs;
    }

    public String getWindCdir() {
        return windCdir;
    }

    public void setWindCdir(String windCdir) {
        this.windCdir = windCdir;
    }

    public Integer getRh() {
        return rh;
    }

    public void setRh(Integer rh) {
        this.rh = rh;
    }

    public Float getPres() {
        return pres;
    }

    public void setPres(Float pres) {
        this.pres = pres;
    }

    public Integer getSunsetTs() {
        return sunsetTs;
    }

    public void setSunsetTs(Integer sunsetTs) {
        this.sunsetTs = sunsetTs;
    }

    public Float getOzone() {
        return ozone;
    }

    public void setOzone(Float ozone) {
        this.ozone = ozone;
    }

    public Float getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(Float moonPhase) {
        this.moonPhase = moonPhase;
    }

    public Float getWindGustSpd() {
        return windGustSpd;
    }

    public void setWindGustSpd(Float windGustSpd) {
        this.windGustSpd = windGustSpd;
    }

    public Integer getSnowDepth() {
        return snowDepth;
    }

    public void setSnowDepth(Integer snowDepth) {
        this.snowDepth = snowDepth;
    }

    public Integer getClouds() {
        return clouds;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    public Integer getSunriseTs() {
        return sunriseTs;
    }

    public void setSunriseTs(Integer sunriseTs) {
        this.sunriseTs = sunriseTs;
    }

    public Float getAppMinTemp() {
        return appMinTemp;
    }

    public void setAppMinTemp(Float appMinTemp) {
        this.appMinTemp = appMinTemp;
    }

    public Float getWindSpd() {
        return windSpd;
    }

    public void setWindSpd(Float windSpd) {
        this.windSpd = windSpd;
    }

    public Integer getPop() {
        return pop;
    }

    public void setPop(Integer pop) {
        this.pop = pop;
    }

    public String getWindCdirFull() {
        return windCdirFull;
    }

    public void setWindCdirFull(String windCdirFull) {
        this.windCdirFull = windCdirFull;
    }

    public Float getSlp() {
        return slp;
    }

    public void setSlp(Float slp) {
        this.slp = slp;
    }

    public Float getAppMaxTemp() {
        return appMaxTemp;
    }

    public void setAppMaxTemp(Float appMaxTemp) {
        this.appMaxTemp = appMaxTemp;
    }

    public Float getVis() {
        return vis;
    }

    public void setVis(Float vis) {
        this.vis = vis;
    }

    public Float getDewpt() {
        return dewpt;
    }

    public void setDewpt(Float dewpt) {
        this.dewpt = dewpt;
    }

    public Integer getSnow() {
        return snow;
    }

    public void setSnow(Integer snow) {
        this.snow = snow;
    }

    public Float getUv() {
        return uv;
    }

    public void setUv(Float uv) {
        this.uv = uv;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public Integer getWindDir() {
        return windDir;
    }

    public void setWindDir(Integer windDir) {
        this.windDir = windDir;
    }

    public Object getMaxDhi() {
        return maxDhi;
    }

    public void setMaxDhi(Object maxDhi) {
        this.maxDhi = maxDhi;
    }

    public Integer getCloudsHi() {
        return cloudsHi;
    }

    public void setCloudsHi(Integer cloudsHi) {
        this.cloudsHi = cloudsHi;
    }

    public Float getPrecip() {
        return precip;
    }

    public void setPrecip(Float precip) {
        this.precip = precip;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Integer getMoonsetTs() {
        return moonsetTs;
    }

    public void setMoonsetTs(Integer moonsetTs) {
        this.moonsetTs = moonsetTs;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Float minTemp) {
        this.minTemp = minTemp;
    }

    public Integer getCloudsMid() {
        return cloudsMid;
    }

    public void setCloudsMid(Integer cloudsMid) {
        this.cloudsMid = cloudsMid;
    }

    public Integer getCloudsLow() {
        return cloudsLow;
    }

    public void setCloudsLow(Integer cloudsLow) {
        this.cloudsLow = cloudsLow;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}


class Weather {

    private String icon;
    private Integer code;
    private String description;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

