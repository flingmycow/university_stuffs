public class ThreadExample1{

    public static void main(String args[]){
        
        //Three threads in Java which runs in Parallel
        Thread threadA = new Thread(new Runnable(){
        public void run(){
        for(int i = 0; i < 8; i++){
        System.out.println("This is thread : " + Thread.currentThread().getName());
        		}
        	}
        }, "Thread A");
        
        //Runnable interface is implemented using Anonymous Class
        Thread threadB = new Thread(new Runnable(){
	public void run(){
	for(int i = 0; i < 8; i++){
	System.out.println("This is thread : " + Thread.currentThread().getName());
                }
            }
        }, "Thread B");
        
        Thread threadC = new Thread(new Runnable(){
	public void run(){
	for(int i = 0; i < 8; i++){
	System.out.println("This is thread : " + Thread.currentThread().getName());
                }
            }
        }, "Thread C");
        
        //starting all 3 Thread's in Java
        threadA.start(); //start will call run method in new thread
        threadB.start();
        threadC.start();
        
    }   

}

