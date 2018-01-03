import java.util.Scanner;

			/* 
			   This java's code  execute some scripts then has controller tomcat's command of service: start, info, stop.
			   The code create a history info status called satatus.log	
			 */


public class TomcatControllerService {	
	
	
	public static void menu(){
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("\n\n\n\n\n\n\n\t\t TOMCAT SERVICE MENU - Linux Server");
		System.out.println("\n\n\t\t (s) Start - Start tomcat service: Press key.");  
        System.out.println("\n\t\t (t) Test- Info tomcat service: Press key.");    
        System.out.println("\n\t\t (f) Finish - Stop tomcat service: Press key.");  
        System.out.println("\n\t\t (q) Quit- exit tomcat service: Press key."); 
	}
	
	
	public static void main(String[] args) {
		
		System.out.print("\033[H\033[2J");
		System.out.flush();
		menu();	 		
        Scanner sc= new Scanner (System.in);          
		String op ="";   
		ProcessBuilder pb;		
		
		do{		
			System.out.print("\n\n\t key Option: ");
			op =sc.next(); 		
		
			switch(op){
			
				//Start service
				//sudo systemctl start tomcat		
				case "s": 
					try {
					     pb = new ProcessBuilder("bash", "-c","./resource/Start_tomcat.sh");          
					     pb.inheritIO();
					     pb.start();
					     menu();
					     System.out.println("\n\t\t\tTomcat it's running!!!\n");
					} catch (Exception e) {
					     e.printStackTrace();
					}					
					break;
	
				//Check service
				//sudo systemctl status tomcat	
					
					
				case "t": ;
					try {
					     pb = new ProcessBuilder("bash", "-c","./resource/Status_tomcat.sh");         
					     pb.inheritIO();
					     pb.start();	
					     menu();
					     System.out.println("\n\n\t\t\tTomcat tested!!!\n\n");    
					     System.out.println("\n\n");
			                } catch (Exception e) {
					     e.printStackTrace();
					}							
					break;
					
				//Stop service
				//sudo systemctl stop tomcat
				case "f": ;
					try {
						 System.out.println("\n\n\n\n\n\n\\n");
					     pb = new ProcessBuilder("bash", "-c","./resource/Stop_tomcat.sh");           
					     pb.inheritIO();
					     pb.start();
					     menu();
					     System.out.println("\n\t\t\tTomcat it's stopped!!!\n");
					} catch (Exception e) {
					     e.printStackTrace();
					}					
					break;
				
				//Exit 
				case "q": 
					System.out.print("\033[H\033[2J");
					System.out.flush();
					System.out.println("\n\n\n\n\n\n\n\n\n\t\t\t\t\tYou're out!!!\n\n\n\n\n\n\n\n\n");
					System.exit(0);
				
				
				//Other key		
				default: 
					menu();
					System.err.println("\n\t\tPress the correct key!!!\n");
			}				
		}while(!op.equals("q"));
	}
}

