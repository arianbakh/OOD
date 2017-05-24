import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new CheckStock(), 0, TimeUnit.MINUTES.toMillis(1));
	}

}
