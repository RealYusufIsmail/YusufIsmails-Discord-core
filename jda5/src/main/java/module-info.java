module YusufIsmail.Discord.core.jda5.main {
    //annotations used in the lib
    requires annotations;
    requires org.jetbrains.annotations;
    requires jsr305;
    //JDA 5
    requires net.dv8tion.jda;
    //The loggers that are used in this lib.
    requires org.slf4j;
    //Used for .env
    requires config;
    requires java.desktop;
}