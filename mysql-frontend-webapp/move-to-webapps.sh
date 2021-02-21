if [[ -d /home/yusoli/.local/share/apache-tomcat-8.5.63/webapps/javaweb-self-practice/ ]]; then
    rm -rf /home/yusoli/.local/share/apache-tomcat-8.5.63/webapps/javaweb-self-practice/
fi
cp -r /home/yusoli/Documents/00-Github/javaweb-self-practice/ /home/yusoli/.local/share/apache-tomcat-8.5.63/webapps/
rm -rf /home/yusoli/.local/share/apache-tomcat-8.5.63/webapps/javaweb-self-practice/.git/
