package com.example.damuMyschool.data.vo;

import java.util.List;

public class TjEchartData {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getxAxisData() {
        return xAxisData;
    }

    public void setxAxisData(List<String> xAxisData) {
        this.xAxisData = xAxisData;
    }

    public List<IndexXaxisData> getIndexXaxisDatas() {
        return indexXaxisDatas;
    }

    public void setIndexXaxisDatas(List<IndexXaxisData> indexXaxisDatas) {
        this.indexXaxisDatas = indexXaxisDatas;
    }

    private String title;

    private List<String> xAxisData;

    private List<IndexXaxisData> indexXaxisDatas;
}
