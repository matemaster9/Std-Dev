package cs.matemaster;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/18 17:22
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

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
        ObjectMapper objectMapper = OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String result;
        try {
            result = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return result;
    }

    public static <T> T deserialize(String jsonData, TypeReference<T> reference) {
        if (jsonData == null || jsonData.length() == 0) {
            return null;
        }

        try {
            return OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL).readValue(jsonData, new TypeReference<T>() {
            });
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        Student student = new Student("201808020125", "MateMaster", MajorEnum.COMPUTER_SCIENCE);
        String serialize = serialize(student);
        System.out.println(serialize);

        // 反序列化演示
        SysUser sysUser = new SysUser();
        sysUser.setUid(1L);
        sysUser.setName("MateMaster");
        sysUser.setPassword("cmbChina9!");
        sysUser.setRegisterDate(new Date());
        sysUser.setBirth(LocalDateTime.now());

        SysUser result = OBJECT_MAPPER.readValue(serialize(sysUser), SysUser.class);

        System.out.println(result);
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
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.ALWAYS);
    }
}
