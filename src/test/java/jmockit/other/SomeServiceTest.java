package jmockit.other;

import jmockit.other.inner.ADao;
import jmockit.other.inner.BDao;
import jmockit.other.inner.MailSenter;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import mockit.Verifications;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by twer on 2017/6/1.
 */
public class SomeServiceTest {

    @Tested
    SomeService someService;

    @Injectable
    ADao aDao;

    @Injectable
    BDao bDao;

    @Mocked
    MailSenter mailSenter;


    @Test
    public void should_update_A_delete_B_and_sendMail(){

        someService.doSome();

        new Verifications(){{
            aDao.update();
            bDao.delete();
            MailSenter.sendMail();
        }};

    }
}