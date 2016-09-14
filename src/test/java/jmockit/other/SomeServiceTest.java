package jmockit.other;

import jmockit.other.inner.ADao;
import jmockit.other.inner.BDao;
import jmockit.other.inner.MailSenter;
import mockit.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yonggao.Dong on 16/9/13.
 */
public class SomeServiceTest {

    @Tested
    SomeService someService;

    @Injectable
    ADao aDao;

    @Injectable
    BDao bDao;

    @Test
    public void show_static_mock(@Mocked final MailSenter mailSenter) throws Exception {


        someService.doSome();

        new Verifications() {{
            aDao.update();
            bDao.delete();
            MailSenter.sendMail();
        }};
    }



    @Test
    public void show_diff_between_mocked_and_injectable(@Mocked final ADao aDao,@Injectable final BDao bDao){
        new Expectations(){{
            aDao.update();result=1;
            bDao.delete();result=1;
        }};

        assertEquals(1,aDao.update());
        assertEquals(1,bDao.delete());


        final ADao aDao1 = new ADao();
        final BDao bDao1 = new BDao();

        new Expectations(){{
            aDao1.update();result=2;
            bDao1.delete();result=2;
        }};

        assertEquals(2,aDao1.update());
        assertEquals(100,bDao1.delete());
    }


}