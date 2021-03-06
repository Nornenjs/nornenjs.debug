package com.vrcs.debug.access;

import com.vrcs.debug.util.AbstractListFilter;

/**
 * Created by pi on 15. 2. 6.
 */
public class StatisticsFilter extends AbstractListFilter {
    
    private String name;
    
    private String platform;
    
    private Integer versionNumber;

    private Integer volumePn;
    
    public StatisticsFilter() {
    }

    public StatisticsFilter(String name, String platform, Integer versionNumber) {
        this.name = name;
        this.platform = platform;
        this.versionNumber = versionNumber;
    }

    public Integer getVolumePn() {
        return volumePn;
    }

    public void setVolumePn(Integer volumePn) {
        this.volumePn = volumePn;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

    @Override
    public String toString() {
        return "StatisticsFilter{" +
                "name='" + name + '\'' +
                ", platform='" + platform + '\'' +
                ", versionNumber=" + versionNumber +
                ", volumePn=" + volumePn +
                '}';
    }
}
