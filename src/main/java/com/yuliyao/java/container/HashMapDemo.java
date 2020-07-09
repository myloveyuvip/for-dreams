package com.yuliyao.java.container;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author YuLiyao
 * @date 2020/7/8
 */
public class HashMapDemo {

    public void testPutNull() {
        Map map = new HashMap(16);
        map.put(null, "map");
        LinkedHashMap lMap = new LinkedHashMap();
        System.out.println("map:"+JSON.toJSONString(map));
        lMap.put(null, "lMap");
        ConcurrentHashMap cMap = new ConcurrentHashMap();
        System.out.println("lMap："+JSON.toJSONString(lMap));
        cMap.put(null, "cMap");
        System.out.println("cMap："+JSON.toJSONString(cMap));
    }

    public void testPut() {
        Map map = new HashMap(16);
        map.put(0, 0);
        //直接存在数组
        map.put(1, 1);
        //hash值对应数组位置存在，构建链接
        map.put(16, 16);

    }
}
