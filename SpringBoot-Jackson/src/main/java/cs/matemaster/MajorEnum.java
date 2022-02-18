package cs.matemaster;

import lombok.Getter;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/18 16:35
 */
@Getter
public enum MajorEnum {
    /**
     * 计科
     */
    COMPUTER_SCIENCE("计算机科学与技术", "80901"),

    /**
     * 软工
     */
    SOFTWARE_ENGINEERING("软件工程","80902"),

    /**
     * 物联网
     */
    IOT_ENGINEERING("物联网工程","80905");


    private String major;
    private String code;

    MajorEnum(String major, String code) {
        this.major = major;
        this.code = code;
    }
}
