import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import javax.enterprise.context.ApplicationScoped;
import java.time.Duration;
import java.util.Random;

@ApplicationScoped
public class PingProducer {

    private final Random random = new Random();

    @Outgoing("testeout")
    public Multi<String> generate() {
        // Build an infinite stream of random prices
        // It emits a price every second
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
            .map(x -> "ping " + random.nextDouble());
    }

}