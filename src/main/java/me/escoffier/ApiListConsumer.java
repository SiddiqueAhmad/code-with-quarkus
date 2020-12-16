package me.escoffier;



        import devdbserver1.dev_16_t_cloud_clinic.api_list.Envelope;
        import devdbserver1.dev_16_t_cloud_clinic.api_list.Value;
        import org.eclipse.microprofile.reactive.messaging.Incoming;
        import org.eclipse.microprofile.reactive.messaging.Acknowledgment;
        import org.jboss.logging.Logger;

        import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApiListConsumer {

    private static final Logger LOGGER =
            Logger.getLogger("MovieConsumer");

    @Incoming("api-list-from-kafka")
    public void receive(Envelope envelope) {
        if(envelope != null){
            LOGGER.info("Received envelope");
            if(envelope.getAfter() != null)
            LOGGER.infof("envelope source db %s", envelope.getAfter().getName());
        }

        else
            LOGGER.info("Received null envelope");





    }


}
