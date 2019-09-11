package com.example.damuMyschool.service.impl;

import com.example.damuMyschool.data.dto.TjtbDto;
import com.example.damuMyschool.data.entity.Tjtb;
import com.example.damuMyschool.data.vo.IndexXaxisData;
import com.example.damuMyschool.data.vo.TjEchartData;
import com.example.damuMyschool.data.vo.TjtbVo;
import com.example.damuMyschool.mapper.TjtbMapper;
import com.example.damuMyschool.response.Result;
import com.example.damuMyschool.response.ResultBuilder;
import com.example.damuMyschool.service.TjtbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TjtbServiceImpl implements TjtbService {

    private static final Logger logger = LoggerFactory.getLogger(TjtbServiceImpl.class);

    @Resource
    private TjtbMapper tjtbMapper;


    public Result fenZuTongJi(TjtbDto tjtbDto) {
        ArrayList<Tjtb> tjtbs = new ArrayList<Tjtb>();
        tjtbs = tjtbMapper.getTjtbGp(tjtbDto);
        for (Tjtb tjtb : tjtbs) {
            tjtb.setOprtId(tjtbDto.getOprtId());
            tjtb.setVersion(tjtbDto.getVersion());
        }

        ArrayList<TjtbVo> tjtbVoLists = new ArrayList<TjtbVo>();
        List<TjtbVo> tjtbVoList = new ArrayList<TjtbVo>();
        for (Tjtb tjtb : tjtbs) {
            tjtbVoList = getTjtb(tjtb);
            if (null != tjtbVoList) {
                tjtbVoLists.addAll(tjtbVoList);
            }
        }

        return ResultBuilder.success(tjtbVoLists);
    }

    private List<TjtbVo> getTjtb(Tjtb tjtb) {
        List<TjtbVo> tjtbVos = new ArrayList<TjtbVo>();
        List<Tjtb> tjtbList = tjtbMapper.getTjtbSjByGp(tjtb);

        if (tjtbList.size() < 1 || null == tjtbList) {
            return null;
        }
        //取出第一条
        Tjtb tjtb1 = tjtbList.get(0);
        //当chartIndex等于1，图
        if (tjtb1.getChartindex().equals("1")) {
            String title = tjtb1.getyCname();
            List x1Data = new ArrayList();
            List x2Data = new ArrayList();
            String type = tjtb1.getyValue();
            Map<String, String> temp = new HashMap();
            for (Tjtb tjtb2 : tjtbList) {
                if (!temp.containsKey(tjtb2.getX1Value())) {
                    temp.put(tjtb2.getX1Value(), tjtb2.getX1Value());
                    x1Data.add(tjtb2.getX1Value());
                }

                if (!x2Data.contains(tjtb2.getX2Value())) {
                    x2Data.add(tjtb2.getX2Value());
                }
            }
            if (type.equals("percent_25")) {
                TjEchartData tjEchartData = getTjEchartData(title, tjtb1, type, x1Data, x2Data, tjtbList);
                tjtbVos = getTjtbVos(tjtbVos, tjEchartData);
            }
        }
        return tjtbVos;
    }

    private List<TjtbVo> getTjtbVos(List<TjtbVo> tjtbVos, TjEchartData tjEchartData) {
        TjtbVo tjtbVo = new TjtbVo();
        tjtbVo.setShowFlag("1");
        tjtbVo.setEchartData(tjEchartData);
        tjtbVos.add(tjtbVo);
        return tjtbVos;
    }

    private TjEchartData getTjEchartData(String title, Tjtb tjtb1, String type, List x1Data, List x2Data, List<Tjtb> tjtbList) {
        TjEchartData tjEchartData = new TjEchartData();
        List<IndexXaxisData> indexXaxisDataList = new ArrayList<IndexXaxisData>();
        IndexXaxisData indexXaxisData = null;
        tjEchartData.setTitle(title);
        tjEchartData.setxAxisData(x1Data);
        if (x2Data.size() > 0 && x2Data != null) {
            for (Object data1 : x2Data) {
                indexXaxisData = getIndexXaxisData(x1Data, type, data1, tjtbList);
                if (null != indexXaxisData) {
                    indexXaxisDataList.add(indexXaxisData);
                } else {
                    indexXaxisDataList.add(new IndexXaxisData());
                }
            }


        }

        tjEchartData.setIndexXaxisDatas(indexXaxisDataList);
        return tjEchartData;
    }

    private IndexXaxisData getIndexXaxisData(List x1Datas, String type, Object data1, List<Tjtb> tjtbList) {
        IndexXaxisData indexXaxisData = new IndexXaxisData();
        indexXaxisData.setName(data1.toString());
        List<Object> list = new ArrayList<Object>();
        if ("PERCENT_25".equalsIgnoreCase(type)) {
            int i;
            for (Object x1Data : x1Datas) {
                for (i = 0; i< tjtbList.size(); i++) {
                    Tjtb tjtb = tjtbList.get(i);
                    if (null == tjtb) {
                        continue;
                    } else if (objectEqual(tjtb.getX1Value(), x1Data) && objectEqual(tjtb.getX2Value(), data1)) {
                        list.add(tjtbList.get(i).getPercent25() == null ? 0 : tjtbList.get(i).getPercent25());
                        break;
                    }
                }
                if (i == tjtbList.size()) {
                    list.add(0);
                }
            }
        } else {
            logger.info("统计类型不是percent25");
        }
        if (null == list || list.size() < 1) {
            list.add(0);
        }
        indexXaxisData.setDatalist(list);
        return indexXaxisData;
    }

    private boolean objectEqual(Object object1, Object object2) {
        if ((null == object1) && (null == object2)) {
            return true;
        } else if ((null == object1) && (null != object2)) {
            return false;
        } else if ((null != object1) && (null == object2)) {
            return false;
        } else {
            return object1.equals(object2);
        }

    }

    public ArrayList<Tjtb> getTjtbGp(TjtbDto tjtbDto) {
//        logger.info("tjtbDto前端接入 "+ JSONObject.to);
//        ArrayList<Tjtb> tjtbs = new ArrayList<Tjtb>();
//        tjtbs = tjtbMapper.getTjtbGp(tjtbDto);
//        for(Tjtb tjtb : tjtbs){
//            tjtb.setOprtId(tjtbDto.getOprtId());
//            tjtb.setVersion(tjtbDto.getVersion());
//        }
        return null;
    }

    public ArrayList<Tjtb> getTjtbSjByGp(TjtbDto tjtbDto) {
        return null;
    }
}
