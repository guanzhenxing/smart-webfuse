package cn.webfuse.cloud.uaa;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class UaaApplicationTest {

    @Test
    public void test() {
        Pattern BCRYPT_PATTERN = Pattern
                .compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");

        String encodedPassword = "$2a$10$TvQlGVKJ0PbEZN.T63lH4u1p3i0n1LK3iOrgXTPvvUEOS5.K4cD1.";

        assertTrue(BCRYPT_PATTERN.matcher(encodedPassword).matches());
    }

}