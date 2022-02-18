package cs.matemaster;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/18 16:23
 */
@Data
public class Student implements Serializable {
    private String stuID;
    private String name;
    private MajorEnum major;

    public Student(String stuID, String name, MajorEnum major) {
        this.stuID = stuID;
        this.name = name;
        this.major = major;
    }
}
