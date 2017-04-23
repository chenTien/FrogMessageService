package MessageQueueService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

/**
 * Created by chen.Tian on 2017/4/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/mq.xml")
public class ProducerConsumerTest {
    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;
    @Autowired
    private ProducerService producerService;
    @Test
    public void testSend(){
        for (int i=0;i<2;i++){
            producerService.sendMessage(destination,"hi, this is send from producer, ÄÚÈÝÊÇ:" + (i+1));
        }
    }
}
