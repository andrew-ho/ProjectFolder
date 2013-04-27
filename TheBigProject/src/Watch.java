class Watch extends Thread
{
	public Watch(){} 

	public void run()
	{
		  /*
			1000 milliseconds = 1 second
			60 seconds = 1 minute
			60  * 1000 * 5 = 300,000 milliseconds
			Reduce the thousands place, and you get 300 increments of 1000 milliseconds
		  */
		  for(int i = 300; i >= 0; i -= 1){
				  if(i == 0) System.exit(0);
				  try{
					 Thread.sleep(1000);
					}
				  catch(InterruptedException e){}
				  }
		  }
}
