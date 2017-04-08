/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Newhouse (nhitbh at gmail dot com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.fooock.shodan.model.host;

import com.fooock.shodan.model.banner.Banner;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Host {

    private long ip;

    private double latitude;
    private double longitude;

    private int[] ports;

    private String[] hostnames;
    private String[] tags;

    @SerializedName("vulns")
    private String[] vulnerabilities;

    @SerializedName("region_code")
    private String regionCode;

    @SerializedName("area_code")
    private String areaCode;

    @SerializedName("postal_code")
    private String postalCode;

    @SerializedName("dma_code")
    private String dmaCode;

    @SerializedName("country_code")
    private String countryCode;

    @SerializedName("org")
    private String organization;
    private String asn;
    private String city;
    private String isp;

    @SerializedName("last_update")
    private String lastUpdate;

    @SerializedName("country_code3")
    private String countryCode3;

    @SerializedName("country_name")
    private String countryName;

    @SerializedName("ip_str")
    private String ipStr;
    private String os;

    @SerializedName("data")
    private List<Banner> banners;

    Host() {

    }

    public long getIp() {
        return ip;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int[] getPorts() {
        return ports;
    }

    public String[] getHostnames() {
        return hostnames;
    }

    public String[] getTags() {
        return tags;
    }

    public String[] getVulnerabilities() {
        return vulnerabilities;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getDmaCode() {
        return dmaCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getOrganization() {
        return organization;
    }

    public String getAsn() {
        return asn;
    }

    public String getCity() {
        return city;
    }

    public String getIsp() {
        return isp;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getIpStr() {
        return ipStr;
    }

    public String getOs() {
        return os;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    @Override
    public String toString() {
        return "HostDto{" +
                "ip=" + ip +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", ports=" + Arrays.toString(ports) +
                ", hostnames=" + Arrays.toString(hostnames) +
                ", tags=" + Arrays.toString(tags) +
                ", vulnerabilities=" + Arrays.toString(vulnerabilities) +
                ", regionCode='" + regionCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", dmaCode='" + dmaCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", organization='" + organization + '\'' +
                ", asn='" + asn + '\'' +
                ", city='" + city + '\'' +
                ", isp='" + isp + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", countryCode3='" + countryCode3 + '\'' +
                ", countryName='" + countryName + '\'' +
                ", ipStr='" + ipStr + '\'' +
                ", os='" + os + '\'' +
                ", banners=" + banners +
                '}';
    }
}
