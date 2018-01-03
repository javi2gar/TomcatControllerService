#!/bin/bash
shopt -s xpg_echo
string=$(echo "cfgs" | sudo -s systemctl status tomcat | sudo tee -a status.log)



if [[ $string == *inactive* ]]
then
   	clear 
	echo "\n\n\t\t\tTomcat it's stopped!!! Inactive status add to status.log   ";
    echo -n "\n\n\t\tKey Option: " 

elif [[ $string == *active* ]]
then
	clear
	echo "\n\n\t\t\tTomcat it's running!!! Active status add to status log   "; 
	echo -n "\n\n\t\tKey option:"  	

fi


