#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>

int main(){
    char msg='v';
    int server;
    struct sockaddr_in addr;
    struct sockaddr_in addr1;
    char data_matr[4][140];
    size_t nread;
    FILE *in;
    const char *ip="192.168.193.3";
    const char *ip1="192.168.193.5";
    server = socket(AF_INET, SOCK_DGRAM, 0);
    if(server < 0)
    {
        perror("socket");
        exit(1);
    }

    addr.sin_family = AF_INET;
    addr.sin_port = htons(3425);
    addr.sin_addr.s_addr =inet_addr(ip);
    addr1.sin_family = AF_INET;
    addr1.sin_port = htons(3425);
    addr1.sin_addr.s_addr =inet_addr(ip1);

    if(bind(server, (struct sockaddr *)&addr, sizeof(addr)) < 0){
        perror("bind");
      exit(2);   
    }
    in = fopen("qwe/qwe.txt","r");
    sleep(10);
	    while(!feof(in)){
    		nread = fread(data_matr, sizeof(char), sizeof(data_matr),in);
    		sendto(server, data_matr, nread, 0, (struct sockaddr *)&addr1, sizeof(addr1));
		}
 	    sendto(server, &msg, sizeof(msg), 0, (struct sockaddr *)&addr1, sizeof(addr1));
            fclose(in);
    close(server);  
    return 0;
}
