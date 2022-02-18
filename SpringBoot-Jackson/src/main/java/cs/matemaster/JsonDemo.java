package cs.matemaster;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Description:
 * @Author: MateMaster
 * @Date: 2022/2/18 19:37
 */
public class JsonDemo {
    public static void main(String[] args) {
        SysUser sysUser = new SysUser();
        sysUser.setUid(1L);
        sysUser.setName("MateMaster");
        sysUser.setPassword("cmbChina9!");
        sysUser.setRegisterDate(new Date());
        sysUser.setBirth(LocalDateTime.now());

        String result = JsonUtil.serialize(sysUser);
        System.out.println(result);
    }
}
