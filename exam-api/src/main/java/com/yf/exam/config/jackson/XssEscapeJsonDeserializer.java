package com.yf.exam.config.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.owasp.encoder.Encode;
import java.io.IOException;

public class XssEscapeJsonDeserializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText(); // 获取原始字符串
        return Encode.forHtml(value); // 转义HTML特殊字符
    }
}