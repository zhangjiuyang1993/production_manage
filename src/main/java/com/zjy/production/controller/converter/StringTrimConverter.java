package com.zjy.production.controller.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * Created by Administrator on 2017/8/1 0001.
 */
public class StringTrimConverter implements Converter<String, String> {
    @Override
    public String convert(String source){
        try {
            //去掉字符串两边字符，如果去掉后为空设置为null
            if (source != null){
                source = source.trim();
                if(source.equals("")){
                    return null;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return source;
    }
}
