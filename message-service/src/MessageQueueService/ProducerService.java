package MessageQueueService;

import javax.jms.Destination;

/**
 * Created by chen.Tian on 2017/4/14.
 */
public interface ProducerService {
    void sendMessage(Destination destination,String messsge);
}
