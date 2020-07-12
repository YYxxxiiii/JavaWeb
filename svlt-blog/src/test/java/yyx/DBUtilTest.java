package yyx;

import org.junit.Assert;
import org.junit.Test;
import yyx.util.DBUtil;

public class DBUtilTest {

    @Test
    public void t1() {
        Assert.assertNotNull(DBUtil.getConnection());
    }
}
