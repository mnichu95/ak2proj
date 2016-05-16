package lab5;



import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.RoundRobinPool; 


public class MyCollector extends UntypedActor {

  private ActorRef explorer;
  int pendingWork;
  int numberOfFiles;

  
  
  
  @Override
  public void preStart() {
    explorer = getContext().actorOf(Props.create(ExploreFile.class).withRouter(new RoundRobinPool(999999999)));
  }

  
  
  
  @Override
  public void onReceive(final Object message) {
   
	  double a= 443443.3232;  
	    double b= 323232.3213; 
	    double c=0; 
	    double d=0;
	    for(double i=0 ;i<44343434; i++){ 
	     c=a*b/a; 
	     c=a*a;
	     for(double j=0 ; j<32323232; j++){ 
	      d=c*c; 
	      d=b*b; 
	      for(double w=0 ; w<32323232; w++){ 
	    	  for(double r=0 ; r<32323232; r++){ 
	    	      d=c*c; 
	    	      d=b*b; 
	    	      d=c/a*b*b ;
	    	     }
	    	  for(double t=0 ; t<32323232; t++){ 
	    	      d=c*a; 
	    	      d=b*a; 
	    	      d=c/b*b*b ;
	    	     }
	    	  for(double u=0 ; u<32323232; u++){ 
	    	      d=b*c;  
	    	      d=c*b; 
	    	      d=b/a*b*b ;
	    	     }
	    	  d=c*a; 
		      d=b*a; 
		      d=c/a*b*b ;
		     }
	      d=c/a*b*b ;
	     }
	     }
	  
	  if(message instanceof String) {
      pendingWork++;
      String path = (String) message;
      explorer.tell(path, self());
    
	  } else {
      
		  pendingWork--;
      int count = (Integer) message;
      numberOfFiles += count;
    }

    if(pendingWork == 0) {
      System.out.println("Total: " + numberOfFiles);
      getContext().system().shutdown();
    }
  }
}
