package lab5;



import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import scala.concurrent.duration.Duration;
import java.util.concurrent.TimeUnit;

public class Sample {
  
	public static void main(String[] args) throws InterruptedException {
     
	  final String PATH = "C:\\Users\\User\\Desktop\\gangbanana";


      countConcurrent(PATH); 

  }

   

    

    private static void countConcurrent(final String path) {
      
    	long start = System.nanoTime();
      
    	ActorSystem actorSystem = ActorSystem.create();
      ActorRef actorRef = actorSystem.actorOf(Props.create(MyCollector.class));
      actorRef.tell(path, null);
      actorSystem.awaitTermination(Duration.create(10, TimeUnit.MINUTES));

      long end = System.nanoTime();
      
      System.out.println("Time taken concurent: " + (end - start)/1.0e9);
    }
}
