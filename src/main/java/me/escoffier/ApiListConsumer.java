package me.escoffier;



        import devdbserver1.dev_16_t_cloud_clinic.api_list.Envelope;
        import devdbserver1.dev_16_t_cloud_clinic.api_list.Value;
        import org.eclipse.microprofile.reactive.messaging.Incoming;
        import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
        import org.eclipse.microprofile.reactive.messaging.Message;
        import org.jboss.logging.Logger;

        import javax.enterprise.context.ApplicationScoped;
        import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class ApiListConsumer {

    private static final Logger LOGGER =
            Logger.getLogger("MovieConsumer");

//    @Incoming("api-list-from-kafka")
//    @Acknowledgment(Acknowledgment.Strategy.POST_PROCESSING)
//    public void receive(Envelope envelope) {
//        if(envelope != null){
//            LOGGER.info("Received envelope");
//            if(envelope.getAfter() != null)
//            LOGGER.infof("envelope source db %s", envelope.getAfter().getName());
//        }
//
//        else
//            LOGGER.info("Received null envelope");
//
//    }

    @Incoming("api-list-from-kafka")
    public CompletionStage<Void> consume(Message<Envelope> envelopeMessage) {
        // process your price.

        // Acknowledge the incoming message (commit the offset)
        return envelopeMessage.ack();
    }


}
