package cn.hh.test;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptTest {
    @Test
    public void test() {
        // spring的安全框架提供的加密方法，可以自动加盐，无需自己保存盐值
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode1 = bCryptPasswordEncoder.encode("123456");
        String encode2 = bCryptPasswordEncoder.encode("123456");
        String encode3 = bCryptPasswordEncoder.encode("huhang");
        System.out.println(encode1);
        System.out.println(encode2);
        System.out.println(encode3);

        // 验证
        boolean m1 = bCryptPasswordEncoder.matches("123456", "$2a$10$y.oi72sYlIjOjLoqrzzrnOOmLYuBVhFwcE46WZqDr5zt6bKnWi.Qm");
        boolean m2 = bCryptPasswordEncoder.matches("123456", "$2a$10$feGevQstx52r9b5i9PLsYe6G980zMn1hT8DsePB4lRNSoa462GZi6");
        System.out.println(m1 +", " + m2);
    }
}
