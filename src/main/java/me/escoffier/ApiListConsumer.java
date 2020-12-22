package me.escoffier;


        import olive_db.olive_16_t_cloud_clinic.visit_services.Envelope;
        import olive_db.olive_16_t_cloud_clinic.visit_services.Value;
        import org.eclipse.microprofile.reactive.messaging.Incoming;
        import org.eclipse.microprofile.reactive.messaging.Message;
        import org.jboss.logging.Logger;

        import javax.enterprise.context.ApplicationScoped;
        import java.util.Objects;
        import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class ApiListConsumer {

    private static final Logger LOGGER =
            Logger.getLogger("ApiListConsumer");

    @Incoming("visit-services-from-kafka")
    public CompletionStage<Void> consume(Message<Envelope> envelopeMessage) {

        try {

{

                String op = envelopeMessage.getPayload().getOp();

                Value visitService = null;

                if (op.equals("c")) {
                    visitService = envelopeMessage.getPayload().getAfter();
                } else if (op.equals("u")) {
                    visitService = envelopeMessage.getPayload().getAfter();
                } else  {
                    LOGGER.info("neither u nor c");
                    visitService = envelopeMessage.getPayload().getBefore();
                }

    int id = visitService.getId();

    LOGGER.infof("visitServiceId is %s", id);

}
            // Acknowledge the incoming message (commit the offset)


        }catch (Exception e){
            LOGGER.infof(e, "message thrown %s", e.getMessage());
        }
        return envelopeMessage.ack();
    }

}
