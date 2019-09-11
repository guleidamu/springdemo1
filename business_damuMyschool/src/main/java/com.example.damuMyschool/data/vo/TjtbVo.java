package com.example.damuMyschool.data.vo;

public class TjtbVo {

    public String getShowFlag() {
        return showFlag;
    }

    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
    }

    public TjTableData getTabledata() {
        return tabledata;
    }

    public void setTabledata(TjTableData tabledata) {
        this.tabledata = tabledata;
    }

    public TjEchartData getEchartData() {
        return echartData;
    }

    public void setEchartData(TjEchartData echartData) {
        this.echartData = echartData;
    }

    private String showFlag;

    private TjTableData tabledata;

    private TjEchartData echartData;
}
