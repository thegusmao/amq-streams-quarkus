import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PongConsumer {

    @Incoming("teste")
    public void consume(String mensagem) {
        System.out.println("Pong: " + mensagem);
    }

}