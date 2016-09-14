package jmockit.other;

import jmockit.other.inner.ADao;
import jmockit.other.inner.BDao;
import jmockit.other.inner.MailSenter;

/**
 * Created by Yonggao.Dong on 16/9/13.
 */

public class SomeService {

    private ADao aDao;
    private BDao bDao;


    public void doSome(){
        aDao.update();
        bDao.delete();

        MailSenter.sendMail();
    }
}
