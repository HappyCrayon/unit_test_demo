package jmockit.verify_actions;

import jmockit.verify_actions.inner.ADao;
import jmockit.verify_actions.inner.BDao;
import jmockit.verify_actions.inner.MailSenter;

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
