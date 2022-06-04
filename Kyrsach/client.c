#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

int main()
{   
    int client;
    struct sockaddr_in addr;
    char buf[4][140];
    char buf1[4][140];
    int bytes_read;
    FILE *out;
    const  char *ip="192.168.193.3";

    client = socket(AF_INET, SOCK_DGRAM, 0);
    if(client < 0)
    {
        perror("socket");
        exit(1);
    }
    
    addr.sin_family = AF_INET;
    addr.sin_port = htons(3425);
    addr.sin_addr.s_addr = inet_addr(ip);
    if(bind(client, (struct sockaddr *)&addr, sizeof(addr)) < 0)
    {
        perror("badbind");
        exit(2);
    }
    out=fopen("res.txt","w"); 
    while(1) {
   	if(!bytes_read){
   		bytes_read = recvfrom(client, buf, sizeof(buf), 0, NULL, NULL);
   		if(bytes_read<=1)
   	        	break;
		int i,j;
		for(i=0;i<4;i++){
			for(j=0;j<140;j++){
				if(buf[i][j]!='0')
    	                            putc(buf[i][j],out);
    	
                 	}
	       	}
		memset(buf,'0',sizeof(buf));
	}
	if(bytes_read){
		bytes_read = recvfrom(client, buf1, sizeof(buf1), 0, NULL, NULL);
		if(bytes_read<=1) 
			break;
		bytes_read=0;
        	int i,j;
                for(i=0;i<4;i++){
                        for(j=0;j<140;j++){
                                if(buf1[i][j]!='0')
                                    putc(buf1[i][j],out);

                        }
                }
                memset(buf1,'0',sizeof(buf1));

    	
	}
   }
	fclose(out);
	close(client);
   
    
    return 0;
}
