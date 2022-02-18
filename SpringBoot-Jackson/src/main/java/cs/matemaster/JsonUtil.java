package cs.matemaster;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/18 17:22
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * JSON序列化
     *
     * @param obj 序列化对象
     * @return JSON序列化字符串
     */
    public static String serialize(Object obj) {
        if (obj == null) {
            return null;
        }
        ObjectMapper objectMapper = mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        String result = null;
        try {
            result = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return null;
        }
        return result;
    }

    public static void main(String[] args) {
        Student student = new Student("201808020125", "MateMaster", MajorEnum.COMPUTER_SCIENCE);
        String serialize = serialize(student);
        System.out.println(serialize);
    }

    /**
     *         ALWAYS, 默认策略序列化全部内容
     *         NON_NULL,
     *         NON_ABSENT,
     *         NON_EMPTY,
     *         NON_DEFAULT,
     *         CUSTOM,
     *         USE_DEFAULTS;
     */
    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
}
