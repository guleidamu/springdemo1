package com.example.businessdemo.service.impl;

import com.example.businessdemo.data.ActInfVo;
import com.example.businessdemo.data.vo.Qid;
import com.example.businessdemo.feign.client.ExtractData;
import com.example.businessdemo.mapper.PermissionMapper;
import com.example.businessdemo.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private ExtractData extractData;

    @Resource
    private PermissionMapper permissionMapper;

    public ArrayList<ActInfVo> getActInf() {
        return permissionMapper.getActInfo();
    }

    public List<Object> getPermissionBy(String userId) {
        ArrayList<Object> outactList = permissionMapper.getPermissionByUserId(userId);
        List<Object> resList = new ArrayList<Object>();
        Map<String,Object> temp = new HashMap<String, Object>();
        for (Object item : outactList) {
            String outName = (String) ((Map<String, Object>) item).get("outName");
            Map<String, Object> mp = new HashMap<String, Object>();
            //去重
            if(!temp.containsKey(outName)){
                temp.put(outName,outName);
                List<Integer> actidList = new ArrayList<Integer>();
                List<String> actEnameList = new ArrayList<String>();
                for (Object item1 : outactList) {
                    Object outName1 = ((Map<String, Object>) item1).get("outName");
                    Integer actid = (Integer) ((Map<String, Object>) item1).get("act_id");
                    String actEname = (String) ((Map<String, Object>) item1).get("actEname");
                    if (outName.equals(outName1)) {
                        actidList.add(actid);
                        actEnameList.add(actEname);
                    }
                }
                mp.put("outName", outName);
                mp.put("actIdList", actidList);
                mp.put("actEnameList", actEnameList);
            }else {
                continue;
            }
            resList.add(mp);
        }
        return resList;
    }

    public String getMyschool(String id) {
        Qid qid = new Qid();
        qid.setId(id);
        String result = extractData.getMyschool(qid);
        return result;
    }

}
